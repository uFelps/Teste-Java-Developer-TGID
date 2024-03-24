package com.tgid.testeJava.dto;

import com.tgid.testeJava.entities.User;
import com.tgid.testeJava.entities.UserRole;
import com.tgid.testeJava.services.validation.NovoUserValid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@NovoUserValid
public class NovoUserDTO {

    private Long id;
    @NotBlank
    private String nome;
    @NotBlank
    private String documento;
    @NotBlank
    private String email;
    @NotBlank
    private String senha;
    @NotNull
    private Double saldo;
    private UserRole userRole;

    public NovoUserDTO(User user){
        this.id = user.getId();
        this.nome = user.getNome();
        this.documento = user.getDocumento();
        this.email = user.getEmail();
        this.senha = user.getSenha();
        this.saldo = user.getSaldo();
        this.userRole = user.getUserRole();
    }
}
