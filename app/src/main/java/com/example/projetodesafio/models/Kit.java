package com.example.projetodesafio.models;

public abstract class Kit {

    private Long id;
    private TipoKitEnum tipoKit;
    private double valor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TipoKitEnum getTipoKit() {
        return tipoKit;
    }

    public void setTipoKit(TipoKitEnum tipoKit) {
        this.tipoKit = tipoKit;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
