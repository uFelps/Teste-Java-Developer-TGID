package com.tgid.testeJava.controllers;

import com.tgid.testeJava.dto.DepositoDTO;
import com.tgid.testeJava.dto.SaqueDTO;
import com.tgid.testeJava.dto.TransacaoDTO;
import com.tgid.testeJava.services.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("transacao")
public class TransacaoController {

    @Autowired
    private TransacaoService service;

    @PostMapping("/deposito")
    public ResponseEntity<TransacaoDTO> realizarDeposito(@RequestBody DepositoDTO dto){
        return ResponseEntity.ok(service.realizarDeposito(dto));
    }

    @PostMapping("/saque")
    public ResponseEntity<TransacaoDTO> realizarSaque(@RequestBody SaqueDTO dto){
        return ResponseEntity.ok(service.realizarSaque(dto));
    }
}
