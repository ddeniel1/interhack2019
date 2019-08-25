package com.herokuapp.interhack2019.modelo;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class EspacoModalidadeKey implements Serializable {


    @ManyToOne
    private Espaco idE;

    @ManyToOne
    private Modalidade idM;

    public EspacoModalidadeKey() {
    }

    public EspacoModalidadeKey(Espaco idE, Modalidade idM) {
        this.idE = idE;
        this.idM = idM;
    }

    public Espaco getIdE() {
        return idE;
    }

    public void setIdE(Espaco idE) {
        this.idE = idE;
    }

    public Modalidade getIdM() {
        return idM;
    }

    public void setIdM(Modalidade idM) {
        this.idM = idM;
    }
}
