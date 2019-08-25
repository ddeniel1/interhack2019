package com.herokuapp.interhack2019.controller.form;

import javax.validation.constraints.NotNull;

public class EspacoForm {

    @NotNull
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public EspacoForm(Integer id) {
    }
}
