//package com.fagammon.raizfagammon.service;
//
//import com.fagammon.raizfagammon.entity.EmailEntity;
//import com.fagammon.raizfagammon.repository.UsuarioRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.stereotype.Service;
//
//@Service
//public class EmailService {
//
//    private final JavaMailSender mailSender;
//    private final UsuarioRepository usuarioRepository;
//
//    private String remetente;
//
//    @Autowired
//    public EmailService(JavaMailSender mailSender, UsuarioRepository usuarioRepository) {
//        this.mailSender = mailSender;
//        this.usuarioRepository = usuarioRepository;
//    }
//
//    public void sendMail(EmailEntity email) {
//        if (email.getTo() == null || email.getTo().isBlank()) {
//            throw new IllegalArgumentException("Destinatário não pode ser nulo ou vazio");
//        }
//        if (email.getBody() == null || email.getBody().isBlank()) {
//            throw new IllegalArgumentException("Corpo do e-mail não pode ser nulo ou vazio");
//        }
//
//        var message = new SimpleMailMessage();
//        message.setFrom(remetente);
//        message.setTo(email.getTo());
//        message.setText(email.getBody());
//
//        mailSender.send(message);
//    }
//8
//    public String filtrandoSeEmailExisteParaMandarCodigo(String usuario) {
//        String nome = usuarioRepository.findNomeByEmail(usuario)
//                .orElseThrow(() -> new IllegalArgumentException("E-mail não encontrado."));
//
//        String codigoRecuperacao = gerarCodigo();
//        String corpoEmail = "Olá " + nome + ", seu código de recuperação é: " + codigoRecuperacao;
//
//        EmailEntity emailEntity = new EmailEntity();
//        emailEntity.setTo(usuario);
//        emailEntity.setBody(corpoEmail);
//
//        sendMail(emailEntity);
//
//        return "Código enviado para o seu e-mail.";
//    }
//
//    private String gerarCodigo() {
//        return String.valueOf((int)(Math.random() * 900000) + 100000);
//    }
//}
