package com.example.projetodesafio;

public class UserAluno extends User {

    private Long codMatricula;
    private String curso;
    private Endereco endereco;

    public UserAluno() {
        this.setTipoUser(TipoUserEnum.ALUNO);
    }

    public Long getCodMatricula() {
        return codMatricula;
    }

    public void setCodMatricula(Long codMatricula) {
        this.codMatricula = codMatricula;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
