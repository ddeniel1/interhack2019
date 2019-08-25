package com.herokuapp.interhack2019.controller.dto;

import com.herokuapp.interhack2019.modelo.StatusAgendamento;

import java.time.LocalDateTime;

public class ReservasDto {

    private LocalDateTime data;

    private StatusAgendamento statusAgendamento;

    public StatusAgendamento getStatusAgendamento() {
        return statusAgendamento;
    }

    public void setStatusAgendamento(StatusAgendamento statusAgendamento) {
        this.statusAgendamento = statusAgendamento;
    }

    public ReservasDto(LocalDateTime data, StatusAgendamento statusAgendamento) {
        this.data = data;
        this.statusAgendamento = statusAgendamento;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }
}
