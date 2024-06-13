package com.thomas.service;

import com.thomas.entity.Endereco;
import com.thomas.exceptions.ResourceNotFoundException;
import com.thomas.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService {

  @Autowired
  private EnderecoRepository enderecoRepository;

  public List<Endereco> findAll() {
    return enderecoRepository.findAll();
  }

  public Optional<Endereco> findById(Long id) {
    return enderecoRepository.findById(id);
  }

  public Endereco save(Endereco endereco) {
    return enderecoRepository.save(endereco);
  }

  public void deleteById(Long id) {
    enderecoRepository.deleteById(id);
  }

  public Endereco updateEndereco(Long id, Endereco enderecoDetails) {
    Endereco endereco = enderecoRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Endereço não encontrado com id " + id));

    endereco.setRua(enderecoDetails.getRua());
    endereco.setNumero(enderecoDetails.getNumero());
    endereco.setComplemento(enderecoDetails.getComplemento());
    endereco.setBairro(enderecoDetails.getBairro());
    endereco.setCidade(enderecoDetails.getCidade());
    endereco.setEstado(enderecoDetails.getEstado());
    endereco.setCep(enderecoDetails.getCep());
    endereco.setUsuario(enderecoDetails.getUsuario());

    return enderecoRepository.save(endereco);
  }
}
