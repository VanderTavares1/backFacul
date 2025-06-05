package com.fagammon.raizfagammon.controller;

import com.fagammon.raizfagammon.dtos.CadastroDTO;
import com.fagammon.raizfagammon.dtos.LoginDTO;
import com.fagammon.raizfagammon.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.fagammon.raizfagammon.entity.UsuarioEntity;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController
@RequestMapping("/usuario")
public class LoginController {

    @Autowired
    LoginService loginService;

    @PostMapping("/cadastro")
    public CadastroDTO adicionandoUsuario(@RequestBody UsuarioEntity dados) {
        try {
            if (dados == null) {
                throw new IllegalArgumentException("Dados vazios");
            }
            return loginService.adicionandoUsuario(dados);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao cadastrar usuário: " + e.getMessage(), e);
        }
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginDTO loginDTO) {
        boolean sucesso = loginService.autenticar(loginDTO);
        if (sucesso) {
            return "Login realizado com sucesso!";
        } else {
            return "Credenciais inválidas!";
        }
    }
}
