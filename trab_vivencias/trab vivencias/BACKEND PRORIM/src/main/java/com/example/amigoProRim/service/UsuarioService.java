package com.example.amigoProRim.service;

import com.example.amigoProRim.model.Usuario;
import com.example.amigoProRim.model.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> listarTodosUsuarios() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> buscarUsuarioPorId(int id) {
        return usuarioRepository.findById(id);
    }

    public Usuario criarOuAtualizarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public void deletarUsuario(int id) {
        usuarioRepository.deleteById(id);
    }
}
