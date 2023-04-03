package br.com.marcoscsouza.viaCepApp.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "tb_produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private double preco;
    private int quantidade;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    @JsonBackReference
    private Usuario usuario;

    public Produto() {
    }

}
