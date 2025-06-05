package com.fagammon.raizfagammon.repository;

import com.fagammon.raizfagammon.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {
    Optional<UsuarioEntity> findFirstByEmailAndSenha(String email, String senha);

    @Query(value = "SELECT nome FROM usuario_entity WHERE usuario = ?1", nativeQuery = true)
    Optional<String> findNomeByEmail(String email);
}
