package com.thomas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thomas.entity.Usuario;
import com.thomas.repository.UsuarioRepository;

@Service
public class UsuarioService {

  @Autowired
  private UsuarioRepository usuarioRepository;

  public List<Usuario> findAll() {
    return usuarioRepository.findAll();
  }

  public Optional<Usuario> findById(Long id) {
    return usuarioRepository.findById(id);
  }

  public Usuario save(Usuario usuario) {
    return usuarioRepository.save(usuario);
  }

  public void deleteById(Long id) {
    usuarioRepository.deleteById(id);
  }
}
