package com.example.projetodesafio.models;

public class UserAdmin extends User {

    private Long idAdmin;

    public UserAdmin() {
        this.setTipoUser(TipoUserEnum.ADMIN);
    }

    public Long getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(Long idAdmin) {
        this.idAdmin = idAdmin;
    }
}
