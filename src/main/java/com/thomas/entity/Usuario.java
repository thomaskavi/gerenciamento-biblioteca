package com.thomas.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Usuario {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)

  private Long id;
  private String nome;
  private String email;
  private String telefone;
  private String cpf;
  private String senha;

  @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
  private List<Endereco> enderecos;

  public Usuario() {
  }

  public Usuario(Long id, String nome, String email, String telefone, String cpf, String senha) {
    this.id = id;
    this.nome = nome;
    this.email = email;
    this.telefone = telefone;
    this.cpf = cpf;
    this.senha = senha;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getTelefone() {
    return telefone;
  }

  public void setTelefone(String telefone) {
    this.telefone = telefone;
  }

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public String getSenha() {
    return senha;
  }

  public void setSenha(String senha) {
    this.senha = senha;
  }

  @Override
  public String toString() {
    return "Usuario [id=" + id + ", nome=" + nome + ", email=" + email + ", telefone=" + telefone + ", cpf=" + cpf
        + ", senha=" + senha + "]";
  }

}
