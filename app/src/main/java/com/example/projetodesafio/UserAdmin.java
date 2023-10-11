package com.example.projetodesafio;

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
