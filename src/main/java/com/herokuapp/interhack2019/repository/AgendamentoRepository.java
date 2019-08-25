package com.herokuapp.interhack2019.repository;

import com.herokuapp.interhack2019.modelo.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {
    List<Agendamento> findByAgendamentoKey_Id(Integer id);

    List<Agendamento> findByAgendamentoKey_IdE(Integer id);

    List<Agendamento> findByAgendamentoKey_IdEAndReserva(Integer id, LocalDateTime reserva);

    List<Agendamento> findByAgendamentoKey_IdM(Integer id);

    List<Agendamento> findByAgendamentoKey_IdMAndAgendamentoKey_IdE(Integer id, Integer id2);
}
