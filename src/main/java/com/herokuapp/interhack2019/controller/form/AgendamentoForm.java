package com.herokuapp.interhack2019.controller.form;

import com.herokuapp.interhack2019.modelo.Agendamento;
import com.herokuapp.interhack2019.modelo.Espaco;
import com.herokuapp.interhack2019.modelo.Modalidade;
import com.herokuapp.interhack2019.modelo.StatusAgendamento;
import com.herokuapp.interhack2019.modelo.keys.AgendamentoKey;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

@Validated
public class AgendamentoForm {

    @NotNull
    private Integer idE;

    @NotNull
    private Integer idM;

    @NotEmpty @NotNull
    private String reserva;

    @NotEmpty @NotNull
    private String entidade;

    @NotNull @NotEmpty
    private String justificativa;


    public Agendamento converter(Espaco espaco, Modalidade modalidade) {

        LocalDateTime dia = LocalDateTime.parse(reserva, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        AgendamentoKey key = new AgendamentoKey(espaco,modalidade);
        key.setId(Integer.parseInt(Long.toString(Math.round((Math.random()+1)*20))));

        Agendamento agendamento = new Agendamento(
                key,
                dia,
                this.entidade,
                LocalDateTime.now(),
                StatusAgendamento.EM_ANALISE,
                this.justificativa
        );
        return agendamento;
    }

    public AgendamentoForm() {
    }

    public AgendamentoForm(Integer idE, Integer idM, String reserva, String entidade, String justificativa) {
        this.idE = idE;
        this.idM = idM;
        this.reserva = reserva;
        this.entidade = entidade;
        this.justificativa = justificativa;
    }

    public Integer getIdE() {
        return idE;
    }

    public void setIdE(Integer idE) {
        this.idE = idE;
    }

    public Integer getIdM() {
        return idM;
    }

    public void setIdM(Integer idM) {
        this.idM = idM;
    }

    public String getReserva() {
        return reserva;
    }

    public void setReserva(String reserva) {
        this.reserva = reserva;
    }

    public String getEntidade() {
        return entidade;
    }

    public void setEntidade(String entidade) {
        this.entidade = entidade;
    }

    public String getJustificativa() {
        return justificativa;
    }

    public void setJustificativa(String justificativa) {
        this.justificativa = justificativa;
    }
}
