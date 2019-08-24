package com.herokuapp.interhack2019.modelo;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="ESPACO")
@SequenceGenerator(name = "ESPACO_SEQ", sequenceName = "SEQ_ESP", allocationSize = 1)
public class Espaco implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ESP_SEQ")
    private int id;

    @Column(name = "NOME")
    private String nome;

    public Espaco() {
    }

    public Espaco(String nome) {
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