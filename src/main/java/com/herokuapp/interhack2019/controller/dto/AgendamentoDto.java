package com.herokuapp.interhack2019.controller.dto;

import com.herokuapp.interhack2019.modelo.Agendamento;
import com.herokuapp.interhack2019.modelo.StatusAgendamento;
import com.herokuapp.interhack2019.modelo.keys.AgendamentoKey;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class AgendamentoDto {

    private AgendamentoKey agendamentoKey;

    private LocalDateTime reserva;

    private String entidade;

    private LocalDateTime solicitacao;

    private StatusAgendamento status;

    private String justificativa;

    public AgendamentoDto(AgendamentoKey agendamentoKey, LocalDateTime reserva, String entidade, LocalDateTime solicitacao, StatusAgendamento status, String justificativa) {
        this.agendamentoKey = agendamentoKey;
        this.reserva = reserva;
        this.entidade = entidade;
        this.solicitacao = solicitacao;
        this.status = status;
        this.justificativa = justificativa;
    }

    public AgendamentoDto(Agendamento agendamento) {

        this.agendamentoKey = agendamento.getAgendamentoKey();
        this.reserva = agendamento.getReserva();
        this.entidade = agendamento.getEntidade();
        this.solicitacao = agendamento.getSolicitacao();
        this.status = agendamento.getStatus();
        this.justificativa = agendamento.getJustificativa();

    }

    public static List<AgendamentoDto> converter(List<Agendamento> agendamentos) {
        return agendamentos.stream().map((Agendamento a) ->
                new AgendamentoDto(a.getAgendamentoKey(),
                        a.getReserva(),a.getEntidade(),a.getSolicitacao(),a.getStatus(), a.getJustificativa())).collect(Collectors.toList());
    }

    public String getJustificativa() {
        return justificativa;
    }

    public AgendamentoKey getAgendamentoKey() {
        return agendamentoKey;
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

    public StatusAgendamento getStatus() {
        return status;
    }
}
