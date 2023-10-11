package com.example.projetodesafio;

public enum TipoUserEnum {

    ADMIN(1),
    ALUNO(2);

    private Integer tipoUser;

    TipoUserEnum(Integer tipoUser){
        this.tipoUser = tipoUser;
    }

    public Integer getTipoUser() {
        return this.tipoUser;
    }
}
