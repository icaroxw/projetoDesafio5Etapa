package com.example.projetodesafio.models;

import java.util.Date;

public class Cupom {

    private Long id;
    private String codigo ;
    private Date dataInicio;
    private Date dataFim;
    private Integer usosPermitidos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public Integer getUsosPermitidos() {
        return usosPermitidos;
    }

    public void setUsosPermitidos(Integer usosPermitidos) {
        this.usosPermitidos = usosPermitidos;
    }
}
