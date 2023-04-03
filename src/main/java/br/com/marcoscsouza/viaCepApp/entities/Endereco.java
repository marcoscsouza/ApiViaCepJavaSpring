package br.com.marcoscsouza.viaCepApp.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "tb_endereco")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String cep;
    private String logradouro;
    private String bairro;
    private String localidade;
    private String uf;

    public Endereco() {
    }

    @Override
    public String toString() {
        return String.format(
                " O endereço %s, %s, %s, %s, %s, %s.",
                cep, logradouro, bairro, localidade, uf);
    }

}
