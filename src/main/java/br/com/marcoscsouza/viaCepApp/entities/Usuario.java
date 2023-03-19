package br.com.marcoscsouza.viaCepApp.entities;

import javax.persistence.*;

@Entity
@Table(name = "tb_user")
public class Usuario {
    //nome, email, telefone, CEP e endereço
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String cep;
    private String endereco;

    public Usuario() {
    }

    public Usuario(String nome, String email, String telefone, String cep) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.cep = cep;
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

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
