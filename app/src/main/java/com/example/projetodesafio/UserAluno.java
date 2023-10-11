package com.example.projetodesafio;

public class UserAluno extends User {

    private String codMatricula;
    private String curso;

    public UserAluno() {
        this.setTipoUser(TipoUserEnum.ALUNO);
    }

}
