package com.meusistema.pedidos.controller;

import com.meusistema.pedidos.model.Usuario;
import com.meusistema.pedidos.repositories.UsuarioRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioRepository usuarioRepository;

    public UsuarioController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @PostMapping("/cadastro")
    public ResponseEntity<String> cadastrar(@RequestBody Usuario usuario) {
        if (usuarioRepository.findByUsuario(usuario.getUsuario()).isPresent()) {
            return ResponseEntity.badRequest().body("Usuário já existe!");
        }
        usuarioRepository.save(usuario);
        return ResponseEntity.ok("Usuário cadastrado com sucesso!");
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Usuario usuario) {
        Optional<Usuario> usuarioEncontrado = usuarioRepository.findByUsuario(usuario.getUsuario());

        if (usuarioEncontrado.isPresent() && usuarioEncontrado.get().getSenha().equals(usuario.getSenha())) {
            return ResponseEntity.ok("Login bem-sucedido!");
        } else {
            return ResponseEntity.status(401).body("Credenciais inválidas!");
        }
    }

    @PutMapping("/editar/{usuario}")
    public ResponseEntity<String> editar(@PathVariable String usuario, @RequestBody Usuario novosDados) {
        Optional<Usuario> usuarioExistente = usuarioRepository.findByUsuario(usuario);

        if (usuarioExistente.isPresent()) {
            Usuario usuarioAtualizado = usuarioExistente.get();
            usuarioAtualizado.setSenha(novosDados.getSenha()); // Atualiza apenas a senha (ou adicione mais campos)
            usuarioRepository.save(usuarioAtualizado);
            return ResponseEntity.ok("Usuário atualizado com sucesso!");
        }
        return ResponseEntity.badRequest().body("Usuário não encontrado!");
    }

    @DeleteMapping("/remover/{usuario}")
    public ResponseEntity<String> remover(@PathVariable String usuario) {
        Optional<Usuario> usuarioExistente = usuarioRepository.findByUsuario(usuario);

        if (usuarioExistente.isPresent()) {
            usuarioRepository.delete(usuarioExistente.get());
            return ResponseEntity.ok("Usuário removido com sucesso!");
        }
        return ResponseEntity.badRequest().body("Usuário não encontrado!");
    }
}
