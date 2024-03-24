package com.tgid.testeJava.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class DepositoDTO {
    private Long remetente;
    private Long destinatario;
    private Double quantiaDeposito;
}
