package com.thomas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.thomas.entity.Usuario;
import com.thomas.service.UsuarioService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

  @Autowired
  private UsuarioService usuarioService;

  @GetMapping
  public List<Usuario> getAllUsuarios() {
    return usuarioService.findAll();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Usuario> getUsuarioById(@PathVariable Long id) {
    Optional<Usuario> usuario = usuarioService.findById(id);
    return usuario.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
  }

  @PostMapping
  public Usuario createUsuario(@RequestBody Usuario usuario) {
    return usuarioService.save(usuario);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Usuario> updateUsuario(@PathVariable Long id, @RequestBody Usuario usuarioDetails) {
    return usuarioService.updateUsuario(id, usuarioDetails);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteUsuario(@PathVariable Long id) {
    usuarioService.deleteById(id);
    return ResponseEntity.noContent().build();
  }
}
