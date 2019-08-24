package com.herokuapp.interhack2019.modelo;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="ESP_MOD")
public class EspacoModalidade implements Serializable {

    @Id
    @ManyToOne
    private Espaco id_e;

    @Id
    @ManyToOne
    private Modalidade id_m;

    public Espaco getId_e() {
        return id_e;
    }

    public Modalidade getId_m() {
        return id_m;
    }

    public EspacoModalidade() {
    }
}
