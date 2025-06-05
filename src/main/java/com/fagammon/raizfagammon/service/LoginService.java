package com.fagammon.raizfagammon.service;

import com.fagammon.raizfagammon.dtos.CadastroDTO;
import com.fagammon.raizfagammon.dtos.LoginDTO;
import com.fagammon.raizfagammon.entity.UsuarioEntity;
import com.fagammon.raizfagammon.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public CadastroDTO adicionandoUsuario(UsuarioEntity dados) {
        try {
            UsuarioEntity salvo = usuarioRepository.save(dados);

            CadastroDTO loginDTO = new CadastroDTO();
            loginDTO.setNome(salvo.getNome());
            loginDTO.setEmail(salvo.getEmail());
            loginDTO.setCurso(salvo.getCurso());
            loginDTO.setAno_conclusao(salvo.getAno_conclusao());
            loginDTO.setData_cadastro(salvo.getData_cadastro());

            return loginDTO;
        }
        catch (Exception e){
            throw new RuntimeException("Erro ao cadastrar usuário");
        }
    }

    private String gerarCodigo() {
        return String.valueOf((int)(Math.random() * 900000) + 100000);
    }

    public boolean autenticar(LoginDTO loginDTO) {
        try {
            Optional<UsuarioEntity> usuario = usuarioRepository.findFirstByEmailAndSenha(
                    loginDTO.getEmail(),
                    loginDTO.getSenha()
            );
            return usuario.isPresent();
        }catch (Exception e){
            throw new RuntimeException("Erro ao logar!");
        }

    }
}
