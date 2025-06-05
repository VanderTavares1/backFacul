//package com.fagammon.raizfagammon.controller;
//
//import com.fagammon.raizfagammon.dtos.EmailRequestDTO;
//import com.fagammon.raizfagammon.entity.EmailEntity;
//import com.fagammon.raizfagammon.service.EmailService;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/email")
//public class EmailController {
//
//    private final EmailService emailService;
//
//    public EmailController(EmailService emailService) {
//        this.emailService = emailService;
//    }
//
//    @PostMapping
//    public void sendEmail(@RequestBody EmailEntity email) {
//        emailService.sendMail(email);
//    }
//
//    @PostMapping("/recuperar-senha")
//    public String filtrandoSeEmailExisteParaMandarCodigo(@RequestBody EmailRequestDTO request) {
//        return emailService.filtrandoSeEmailExisteParaMandarCodigo(request.getUsuario());
//    }
//
//    @GetMapping
//    public String email() {
//        return "Código de verificação.";
//    }
//}
