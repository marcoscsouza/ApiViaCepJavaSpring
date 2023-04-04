package br.com.marcoscsouza.viaCepApp.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "tb_usuario")
public class Usuario {
    //nome, email, telefone, CEP e endereço
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String email;
    private String telefone;
    private String foto;
    private String endereco;

    @OneToMany(cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JoinColumn(name = "idUsuario")
    @JsonManagedReference
    private List<Produto> produtos;

    public Usuario() {
    }
}
