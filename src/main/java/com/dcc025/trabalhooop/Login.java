package com.dcc025.trabalhooop;

public class Login {

    private String email;
    private String senha;


    public Login(String email, String senha)
    {
        this.email = email;
        this.senha = senha;
    }

    public String getEmail()
    {
        return email;
    }


    protected String getSenha()
    {
        return senha;
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
