package com.example.projetodesafio;

public enum TipoKitEnum {

    MASC(1),
    FEM(2);

    private Integer tipoKit;

    TipoKitEnum(Integer tipoKit){
        this.tipoKit = tipoKit;
    }

    public Integer getTipoKit() {
        return this.tipoKit;
    }
}
