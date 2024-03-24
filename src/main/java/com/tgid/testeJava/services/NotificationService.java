package com.tgid.testeJava.services;

import com.tgid.testeJava.services.exceptions.NotificationServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NotificationService {

    @Autowired
    private RestTemplate restTemplate;

    public void sendEmailNotification(String email){

        ResponseEntity<String> response = restTemplate.getForEntity("https://webhook.site/78ce834e-da77-41e4-aa67-5a6ac8fc30e7", String.class);

        if(!(response.getStatusCode() == HttpStatus.OK)){
            throw new NotificationServiceException("Erro ao enviar notificação");
        }


        System.out.println("Email enviado com succeso para: "+ email);
        System.out.println("Resposta: " + response.getBody());
    }
}
