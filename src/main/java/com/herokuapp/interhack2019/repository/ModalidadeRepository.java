package com.herokuapp.interhack2019.repository;

import com.herokuapp.interhack2019.modelo.Modalidade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ModalidadeRepository extends JpaRepository<Modalidade, Long> {
    List<Modalidade> findById(Integer id);

    Modalidade findFirstById(Integer id);

    List<Modalidade> findByNome(String nome);
}
