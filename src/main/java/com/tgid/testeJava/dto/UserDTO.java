package com.tgid.testeJava.dto;

import com.tgid.testeJava.entities.User;
import com.tgid.testeJava.entities.UserRole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.usertype.UserType;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDTO {

    private Long id;
    private String nome;
    private String documento;
    private String email;
    private Double saldo;
    private UserRole userRole;

    public UserDTO(User user){
        this.id = user.getId();
        this.nome = user.getNome();
        this.documento = user.getDocumento();
        this.email = user.getEmail();
        this.saldo = user.getSaldo();
        this.userRole = user.getUserRole();
    }
}
