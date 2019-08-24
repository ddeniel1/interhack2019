package com.herokuapp.interhack2019.modelo;

import org.apache.tomcat.jni.Local;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "AGENDAMENTO")
@SequenceGenerator(name = "AGENDAMENTO_SEQ", sequenceName = "SEQ_AGE", allocationSize = 1)
public class Agendamento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AGENDAMENTO_SEQ")
    private int id;

    @Id
    @ManyToOne
    private Espaco id_e;

    @Id
    @ManyToOne
    private Modalidade id_m;

    @Column(name = "DATA_RESERVA")
    private LocalDateTime reserva;

    @Column(name = "ENTIDADE")
    private String entidade;

    @Column(name = "DATA_SOLICITACAO")
    private LocalDateTime solicitacao;

    @Column(name = "STATUS")
    private int status;

    public Agendamento() {
    }

    public Agendamento(Espaco id_e, Modalidade id_m, LocalDateTime reserva,
                       String entidade, LocalDateTime solicitacao) {
        this.id_e = id_e;
        this.id_m = id_m;
        this.reserva = reserva;
        this.entidade = entidade;
        this.solicitacao = solicitacao;
    }

    public int getId() {
        return id;
    }

    public Espaco getId_e() {
        return id_e;
    }

    public Modalidade getId_m() {
        return id_m;
    }

    public LocalDateTime getReserva() {
        return reserva;
    }

    public String getEntidade() {
        return entidade;
    }

    public LocalDateTime getSolicitacao() {
        return solicitacao;
    }

    public int getStatus() {
        return status;
    }

    public void setId_e(Espaco id_e) {
        this.id_e = id_e;
    }

    public void setId_m(Modalidade id_m) {
        this.id_m = id_m;
    }

    public void setReserva(LocalDateTime reserva) {
        this.reserva = reserva;
    }

    public void setEntidade(String entidade) {
        this.entidade = entidade;
    }

    public void setSolicitacao(LocalDateTime solicitacao) {
        this.solicitacao = solicitacao;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
