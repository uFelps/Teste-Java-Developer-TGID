package com.tgid.testeJava.services.validation;

import com.tgid.testeJava.controllers.exceptions.FieldMessage;
import com.tgid.testeJava.dto.NovoUserDTO;
import com.tgid.testeJava.entities.User;
import com.tgid.testeJava.services.UserService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class NovoUserValidator implements ConstraintValidator<NovoUserValid, NovoUserDTO> {

    @Autowired
    private UserService service;

    @Override
    public void initialize(NovoUserValid constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(NovoUserDTO dto, ConstraintValidatorContext context) {
        List<FieldMessage> list = new ArrayList<>();

        // Coloque aqui seus testes de validação, acrescentando objetos FieldMessage à lista
        User user = service.buscarUserPeloDocumento(dto.getDocumento());

        if(user != null){
            list.add(new FieldMessage("DOCUMENTO", "Esse CPF/CNPJ já foi cadastrado"));
        }


        for (FieldMessage e : list) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
                    .addConstraintViolation();
        }
        return list.isEmpty();
    }
}
