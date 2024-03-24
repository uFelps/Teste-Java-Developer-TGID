package com.tgid.testeJava.services.exceptions;

public class NotificationServiceException extends RuntimeException {
    public NotificationServiceException(String erroAoEnviarNotificação) {
        super(erroAoEnviarNotificação);
    }
}
