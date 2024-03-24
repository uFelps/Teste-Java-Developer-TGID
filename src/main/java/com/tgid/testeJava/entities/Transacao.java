package com.tgid.testeJava.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity(name = "transacao")
@Table(name = "transacao")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "remetente_id")
    private User remetente;
    @ManyToOne
    @JoinColumn(name = "destinatario_id")
    private User destinatario;
    private LocalDateTime horario;
    private Double quantiaInicial;
    private Double taxa;
    private Double valorLiquido;
}
