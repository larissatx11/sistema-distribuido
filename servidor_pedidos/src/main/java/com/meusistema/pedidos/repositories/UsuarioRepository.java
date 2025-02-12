package com.meusistema.pedidos.repositories;

import com.meusistema.pedidos.model.Usuario;
import com.meusistema.pedidos.repositories.UsuarioRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByUsuario(String usuario);
}
