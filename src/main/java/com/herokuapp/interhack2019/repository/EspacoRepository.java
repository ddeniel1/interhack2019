package com.herokuapp.interhack2019.repository;

import com.herokuapp.interhack2019.modelo.Espaco;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EspacoRepository extends JpaRepository<Espaco, Long> {
    List<Espaco> findById(Integer id);

    Espaco findFirstById(Integer id);

    List<Espaco> findByNome(String nome);
}
