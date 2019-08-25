package com.herokuapp.interhack2019.repository;

import com.herokuapp.interhack2019.modelo.Espaco;
import com.herokuapp.interhack2019.modelo.EspacoModalidade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EMRepository extends JpaRepository<EspacoModalidade, Espaco>{

    List<EspacoModalidade> findByEspacoModalidadeKey_IdM_Id(Integer id);

    List<EspacoModalidade> findByEspacoModalidadeKey_IdE_Id(Integer id);

}
