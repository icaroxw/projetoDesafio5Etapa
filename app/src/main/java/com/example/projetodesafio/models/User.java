package com.example.projetodesafio.models;

import java.util.Date;

public abstract class User {

    private Long id;
    private TipoUserEnum tipoUser;
    private String nome;
    private Date dataNascimento;
    private String cpf;
    private String email;
    private String usuario;
    private String senha;

    public User() {}

    public User(String email, String usuario, String senha) {
        this.setEmail(email);
        this.setUsuario(usuario);
        this.setSenha(senha);
    }

    public User(String nome, Date dataNascimento, String cpf, String email, String usuario, String senha) {
        this.setNome(nome);
        this.setDataNascimento(dataNascimento);
        this.setCpf(cpf);
        this.setEmail(email);
        this.setUsuario(usuario);
        this.setSenha(senha);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TipoUserEnum getTipoUser() {
        return tipoUser;
    }

    public void setTipoUser(TipoUserEnum tipoUser) {
        this.tipoUser = tipoUser;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
