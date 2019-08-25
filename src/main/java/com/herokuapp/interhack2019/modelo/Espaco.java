package com.herokuapp.interhack2019.modelo;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="ESPACO")
@SequenceGenerator(name = "ESPACO_SEQ", sequenceName = "SEQ_ESP", allocationSize = 1)
public class Espaco implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ESP_SEQ")
    private Integer id;

    @Column(name = "NOME")
    private String nome;

    public Espaco() {
    }



    public Espaco(String nome) {
        this.nome = nome;
    }

    public Espaco(EspacoModalidade espacoModalidade) {
        this.id = espacoModalidade.getEspacoModalidadeKey().getIdE().getId();
        this.nome = espacoModalidade.getEspacoModalidadeKey().getIdE().getNome();
    }

    public Espaco(Espaco espaco) {
        this.id = espaco.getId();
        this.nome = espaco.getNome();
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
