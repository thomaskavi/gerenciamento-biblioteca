package com.thomas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thomas.entity.Usuario;
import com.thomas.repository.UsuarioRepository;

@Service
public class UsuarioService {
  private UsuarioRepository usuarioRepository;

  @Autowired
  public UsuarioService(UsuarioRepository usuarioRepository) {
    this.usuarioRepository = usuarioRepository;
  }

  public List<Usuario> listarUsuarios() {
    return usuarioRepository.findAll();
  }

  public Optional<Usuario> buscarUsuarioPorId(Long id) {
    return usuarioRepository.findById(id);
  }

  public Usuario salvarUsuario(Usuario usuario) {
    return usuarioRepository.save(usuario);
  }

  public void deletarUsuario(Long id) {
    usuarioRepository.deleteById(id);
  }

  public Usuario atualizarUsuario(Long id, Usuario usuarioAtualizado) {
    Usuario usuarioExistente = usuarioRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

    usuarioExistente.setNome(usuarioAtualizado.getNome());
    usuarioExistente.setEmail(usuarioAtualizado.getEmail());
    usuarioExistente.setTelefone(usuarioAtualizado.getTelefone());
    usuarioExistente.setCpf(usuarioAtualizado.getCpf());
    usuarioExistente.setSenha(usuarioAtualizado.getSenha());

    return usuarioRepository.save(usuarioExistente);

  }
}
