package com.herokuapp.interhack2019.modelo;

import com.herokuapp.interhack2019.modelo.keys.EspacoModalidadeKey;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="ESP_MOD")
public class EspacoModalidade implements Serializable {

    @EmbeddedId
    private EspacoModalidadeKey espacoModalidadeKey;


    public EspacoModalidadeKey getEspacoModalidadeKey() {
        return espacoModalidadeKey;
    }

    public EspacoModalidade() {
    }
}
