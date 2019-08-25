package com.herokuapp.interhack2019.modelo;

import com.herokuapp.interhack2019.modelo.keys.AgendamentoKey;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "AGENDAMENTO")
public class Agendamento implements Serializable {

    @EmbeddedId
    private AgendamentoKey agendamentoKey;

    @Column(name = "DATA_RESERVA")
    private LocalDateTime reserva;

    @Column(name = "ENTIDADE")
    private String entidade;

    @Column(name = "DATA_SOLICITACAO")
    private LocalDateTime solicitacao;

    @Column(name = "STATUS")
    private StatusAgendamento status;

    @Column(name = "JUSTIFICATIVA")
    private String justificativa;

    public Agendamento() {
    }

    public Agendamento(AgendamentoKey agendamentoKey, LocalDateTime reserva, String entidade, LocalDateTime solicitacao, StatusAgendamento status, String justificativa) {
        this.agendamentoKey = agendamentoKey;
        this.reserva = reserva;
        this.entidade = entidade;
        this.solicitacao = solicitacao;
        this.status = status;
        this.justificativa = justificativa;
    }

    public Agendamento(Agendamento agendamento) {

    }

    public String getJustificativa() {
        return justificativa;
    }

    public void setJustificativa(String justificativa) {
        this.justificativa = justificativa;
    }

    public AgendamentoKey getAgendamentoKey() {
        return agendamentoKey;
    }

    public void setAgendamentoKey(AgendamentoKey agendamentoKey) {
        this.agendamentoKey = agendamentoKey;
    }

    public StatusAgendamento getStatus() {
        return status;
    }

    public void setStatus(StatusAgendamento status) {
        this.status = status;
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

    public void setReserva(LocalDateTime reserva) {
        this.reserva = reserva;
    }

    public void setEntidade(String entidade) {
        this.entidade = entidade;
    }

    public void setSolicitacao(LocalDateTime solicitacao) {
        this.solicitacao = solicitacao;
    }
}
