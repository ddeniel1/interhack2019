package com.herokuapp.interhack2019.modelo;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class AgendamentoKey implements Serializable {

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AGENDAMENTO_SEQ")
    private Integer id;

    @ManyToOne
    private Espaco idE;

    @ManyToOne
    private Modalidade idM;

    public AgendamentoKey(Espaco id_e, Modalidade id_m) {
        this.idE = id_e;
        this.idM = id_m;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Espaco getId_e() {
        return idE;
    }

    public void setId_e(Espaco id_e) {
        this.idE = id_e;
    }

    public Modalidade getIdM() {
        return idM;
    }

    public void setIdM(Modalidade idM) {
        this.idM = idM;
    }
}
