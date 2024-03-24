package com.tgid.testeJava.dto;

import com.tgid.testeJava.entities.Transacao;
import com.tgid.testeJava.entities.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TransacaoDTO {
    private Long id;
    private LocalDateTime horario;
    private Double quantiaInicial;
    private Double taxa;
    private Double valorLiquido;
    private UserDTO remetente;
    private UserDTO destinatario;


    public TransacaoDTO(Transacao novaTransacao) {
        this.id = novaTransacao.getId();
        this.remetente = new UserDTO(novaTransacao.getRemetente());
        this.destinatario = new UserDTO(novaTransacao.getDestinatario());
        this.horario = novaTransacao.getHorario();
        this.quantiaInicial = novaTransacao.getQuantiaInicial();
        this.taxa = novaTransacao.getTaxa();
        this.valorLiquido = novaTransacao.getValorLiquido();
    }
}
