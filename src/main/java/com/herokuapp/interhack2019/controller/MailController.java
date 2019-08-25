package com.herokuapp.interhack2019.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/email-send", method = RequestMethod.GET)
public class MailController {
    @Autowired
    private JavaMailSender mailSender;

    @GetMapping("/{email}")
    public String sendMail(@PathVariable String email) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("Solicitação de Reserva");
        message.setText("Sua solicitação de reserva foi recebida e será analisada.");
        message.setTo(email);
        message.setFrom("cepeusphack@gmail.com");

        try {
            mailSender.send(message);
            return "Email enviado com sucesso!";
        } catch (Exception e) {
            e.printStackTrace();
            return "Erro ao enviar email.";
        }
    }
}
