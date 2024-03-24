package com.tgid.testeJava.services;

import com.tgid.testeJava.dto.NovoUserDTO;
import com.tgid.testeJava.dto.UserDTO;
import com.tgid.testeJava.entities.User;
import com.tgid.testeJava.repositories.UserRepostiory;
import com.tgid.testeJava.services.exceptions.DataNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepostiory repository;

    @Transactional
    public UserDTO criarNovoUser(NovoUserDTO dto){
        User novoUser = new User(null, dto.getNome(), dto.getDocumento(), dto.getEmail(), dto.getSenha(), dto.getSaldo(), dto.getUserRole());
        return new UserDTO(repository.save(novoUser));
    }


    @Transactional
    public User buscarUserPeloDocumento(String documento){
        return repository.findByDocumento(documento);
    }

    public User buscarUserPeloId(Long id) {
        Optional<User> user = repository.findById(id);

        if (user.isEmpty()){
            throw new DataNotFoundException("User com o id " + id + "não encontrado");
        }

        return user.get();
    }

    public void salvarUser(User clienteRemetente) {
        repository.save(clienteRemetente);
    }
}
