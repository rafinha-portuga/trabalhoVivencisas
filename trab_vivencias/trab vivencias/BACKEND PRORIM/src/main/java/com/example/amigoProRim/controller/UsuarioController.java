package com.example.amigoProRim.controller;


import com.example.amigoProRim.model.Usuario;
import com.example.amigoProRim.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<Usuario> listarUsuarios() {
        return usuarioService.listarTodosUsuarios();
    }

    @GetMapping("/{id}")
    public Optional<Usuario> buscarUsuario(@PathVariable int id) {
        return usuarioService.buscarUsuarioPorId(id);
    }

    @PostMapping
    public Usuario criarUsuario(@RequestBody Usuario usuario) {
        return usuarioService.criarOuAtualizarUsuario(usuario);
    }

    @PutMapping("/{id}")
    public Usuario atualizarUsuario(@PathVariable int id, @RequestBody Usuario usuarioAtualizado) {
        usuarioAtualizado.setIdUsuario(id);
        return usuarioService.criarOuAtualizarUsuario(usuarioAtualizado);
    }

    @DeleteMapping("/{id}")
    public void deletarUsuario(@PathVariable int id) {
        usuarioService.deletarUsuario(id);
    }
}
