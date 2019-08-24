package com.herokuapp.interhack2019.modelo;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="MODALIDADE")
@SequenceGenerator(name = "MODALIDADE_SEQ", sequenceName = "SEQ_MOD", allocationSize = 1)
public class Modalidade implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MODALIDADE_SEQ")
    private int id;

    @Column(name = "NOME")
    private String nome;

    public Modalidade() {
    }

    public Modalidade(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
