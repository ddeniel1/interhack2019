package com.herokuapp.interhack2019.controller.dto;

import com.herokuapp.interhack2019.modelo.Espaco;

import java.util.List;
import java.util.stream.Collectors;

public class EspacoDto {

    private Integer id;
    private String nome;

    public EspacoDto(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public EspacoDto() {
    }

    public EspacoDto(Espaco espaco) {
        this.id = espaco.getId();
        this.nome = espaco.getNome();
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public static List<EspacoDto> converter (List<Espaco> espacos){
        return espacos.stream().map(EspacoDto::new).collect(Collectors.toList());
    }
}
