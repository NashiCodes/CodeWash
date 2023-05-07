package com.dcc025.trabalhooop;


public class Cadastro extends Login{

    private String tipoUser;

    public Cadastro(String email, String senha, String tipoUser)
    {
        super(email, senha);
        this.tipoUser = tipoUser;
    }

    public String getTipoUser()
    {
        return tipoUser;
    }
}
