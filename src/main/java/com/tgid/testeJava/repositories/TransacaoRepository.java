package com.tgid.testeJava.repositories;

import com.tgid.testeJava.entities.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransacaoRepository extends JpaRepository<Transacao, Long> {
}
