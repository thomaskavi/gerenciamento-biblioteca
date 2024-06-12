package com.thomas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thomas.entity.Usuario;
import com.thomas.service.UsuarioService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

  private UsuarioService usuarioService;

  @Autowired
  public UsuarioController(UsuarioService usuarioService) {
    this.usuarioService = usuarioService;
  }

  @GetMapping
  public List<Usuario> listarUsuarios() {
    return usuarioService.listarUsuarios();
  }

  @GetMapping("/{id}")
  public Usuario buscarUsuario(@PathVariable Long id) {
    return usuarioService.buscarUsuarioPorId(id).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
  }

  @PostMapping
  public Usuario salvarUsuario(@RequestBody Usuario usuario) {
    return usuarioService.salvarUsuario(usuario);
  }

  @PutMapping("/{id}")
  public Usuario atualizarUsuario(@PathVariable Long id, @RequestBody Usuario usuario) {
    return usuarioService.atualizarUsuario(id, usuario);
  }

  @DeleteMapping("/{id}")
  public void deletarUsuario(@PathVariable Long id) {
    usuarioService.deletarUsuario(id);
  }
}
