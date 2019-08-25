package com.herokuapp.interhack2019.modelo;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "AGENDAMENTO")
@SequenceGenerator(name = "AGENDAMENTO_SEQ", sequenceName = "SEQ_AGE", allocationSize = 1)
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

    public Agendamento() {
    }

    public Agendamento(AgendamentoKey agendamentoKey, LocalDateTime reserva, String entidade, LocalDateTime solicitacao, StatusAgendamento status) {
        this.agendamentoKey = agendamentoKey;
        this.reserva = reserva;
        this.entidade = entidade;
        this.solicitacao = solicitacao;
        this.status = status;
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
