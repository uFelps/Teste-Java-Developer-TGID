package com.tgid.testeJava.services;

import com.tgid.testeJava.dto.DepositoDTO;
import com.tgid.testeJava.dto.SaqueDTO;
import com.tgid.testeJava.dto.TransacaoDTO;
import com.tgid.testeJava.entities.Transacao;
import com.tgid.testeJava.entities.User;
import com.tgid.testeJava.entities.UserRole;
import com.tgid.testeJava.repositories.TransacaoRepository;
import com.tgid.testeJava.services.exceptions.TransacaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TransacaoService {

    private final static Double taxa = 5.0;// taxa definida no valor de 5%

    @Autowired
    private TransacaoRepository repository;

    @Autowired
    private UserService userService;

    @Autowired
    private NotificationService notificationService;


    public TransacaoDTO realizarSaque(SaqueDTO dto){

        User remetente = userService.buscarUserPeloId(dto.getRemetente());
        User destinatario = userService.buscarUserPeloId(dto.getDestinatario());

        //verificando se o remetente tem saldo o suficiente, e se o remetente é um usuario e o destinatário é uma empresa
        validarSaque(remetente, destinatario, dto);
        return realizarTransferencia(remetente, destinatario, dto.getQuantiaSaque());
    }

    public TransacaoDTO realizarDeposito(DepositoDTO dto){

        User remetente = userService.buscarUserPeloId(dto.getRemetente());
        User destinatario = userService.buscarUserPeloId(dto.getDestinatario());

        //verificando se o remetente tem saldo o suficiente, e se o remetente é um usuario e o destinatário é uma empresa
        validarDeposito(remetente, destinatario, dto);
        return realizarTransferencia(remetente, destinatario, dto.getQuantiaDeposito());
    }

    public TransacaoDTO realizarTransferencia(User remetente, User destinatario, Double quantiaTransferida){
        Double valorLiquido = calcularValorLiquido(quantiaTransferida);

        Transacao novaTransacao = new Transacao(null, remetente, destinatario, LocalDateTime.now(), quantiaTransferida, taxa, valorLiquido);
        remetente.setSaldo(remetente.getSaldo() - quantiaTransferida);
        destinatario.setSaldo(destinatario.getSaldo() + valorLiquido);


        userService.salvarUser(remetente);
        userService.salvarUser(destinatario);

        //enviando email para o cliente e empresa informando a transação
        notificationService.sendEmailNotification(remetente.getEmail());
        notificationService.sendEmailNotification(destinatario.getEmail());
        return new TransacaoDTO(repository.save(novaTransacao));
    }

    public Double calcularValorLiquido(Double quantiaInicial){
        Double valorASerRetirado = quantiaInicial * (taxa / 100);
        return quantiaInicial - valorASerRetirado;
    }

    public void validarDeposito(User remetente, User destinatario, DepositoDTO dto){

        //caso cliente não tenha saldo o suficiente para fazer o deposito
        if(remetente.getSaldo() < dto.getQuantiaDeposito()){
            throw new TransacaoException("O cliente não possui saldo suficiente para fazer o deposito da quantia informada");
        }

        //verificando se o remetente é um CLIENTE e o destinatario é UMA EMPRESA
        if(remetente.getUserRole() == UserRole.EMPRESA || destinatario.getUserRole() == UserRole.CLIENTE){
            throw new TransacaoException("Para efetuar o Deposito, o remetente precisa ser um CLIENTE e o destinatario uma EMPRESA");
        }
    }

    public void validarSaque(User remetente, User destinatario, SaqueDTO dto) {
        //caso cliente não tenha saldo o suficiente para fazer o deposito
        if(remetente.getSaldo() < dto.getQuantiaSaque()){
            throw new TransacaoException("A Empresa não possui saldo suficiente para fazer o saque da quantia informada");
        }

        //verificando se o remetente é um CLIENTE e o destinatario é UMA EMPRESA
        if(remetente.getUserRole() == UserRole.CLIENTE || destinatario.getUserRole() == UserRole.EMPRESA){
            throw new TransacaoException("Para efetuar o Saque, o remetente precisa ser uma EMPRESA e o destinatario um CLIENTE");
        }
    }
}
