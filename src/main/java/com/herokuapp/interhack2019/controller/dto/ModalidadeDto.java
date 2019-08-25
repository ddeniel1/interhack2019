package com.herokuapp.interhack2019.controller.dto;

import com.herokuapp.interhack2019.modelo.Modalidade;

import java.util.List;
import java.util.stream.Collectors;

public class ModalidadeDto {

    private Integer id;
    private String nome;

    public ModalidadeDto(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public static List<ModalidadeDto> converter(List<Modalidade> modalidades){
        return modalidades.stream().map((Modalidade id1) ->
                new ModalidadeDto(id1.getId(),id1.getNome())).collect(Collectors.toList());
    }

}
