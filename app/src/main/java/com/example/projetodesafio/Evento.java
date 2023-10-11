package com.example.projetodesafio;

import java.util.Date;

public class Evento {

    private Long id;
    private String nome;
    private Date data;
    private Endereco endereco;

    public Evento(String nome, Date data, Endereco endereco) {
        this.setNome(nome);
        this.setData(data);
        this.setEndereco(endereco);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
