package com.thomas.controller;

import com.thomas.entity.Endereco;
import com.thomas.exceptions.ResourceNotFoundException;
import com.thomas.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

  @Autowired
  private EnderecoService enderecoService;

  @GetMapping
  public List<Endereco> getAllEnderecos() {
    return enderecoService.findAll();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Endereco> getEnderecoById(@PathVariable Long id) {
    return enderecoService.findById(id)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
  }

  @PostMapping
  public Endereco createEndereco(@RequestBody Endereco endereco) {
    return enderecoService.save(endereco);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Endereco> updateEndereco(@PathVariable Long id, @RequestBody Endereco enderecoDetails) {
    try {
      Endereco updatedEndereco = enderecoService.updateEndereco(id, enderecoDetails);
      return ResponseEntity.ok(updatedEndereco);
    } catch (ResourceNotFoundException e) {
      return ResponseEntity.notFound().build();
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteEndereco(@PathVariable Long id) {
    enderecoService.deleteById(id);
    return ResponseEntity.noContent().build();
  }
}
