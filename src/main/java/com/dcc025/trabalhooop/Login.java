package com.dcc025.trabalhooop;

import java.util.*;

public class Login {

    private String email;
    private String senha;
    private String tipoUser;
    private List <Usuario> usuarios = new ArrayList<>();

    public Login(String email, String senha, String tipoUser)
    {
        this.email = email;
        this.senha = senha;
        this.tipoUser = tipoUser;
    }

    public String getEmail()
    {
        return email;
    }


    protected String getSenha()
    {
        return senha;
    }

    public String getTipoUser()
    {
        return tipoUser;
    }

    protected void setEmail(String novoEmail)
    {
        this.email = novoEmail;
    }

    protected void setSenha(String novaSenha)
    {
        this.senha = novaSenha;
    }
}
