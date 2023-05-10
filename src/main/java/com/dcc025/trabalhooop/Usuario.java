package com.dcc025.trabalhooop;

public class Usuario {
    protected String nome;
    protected String telefone;
    protected String email;
    protected String senha;

    public Usuario(String nome, String telefone, String email, String senha)
    {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.senha = senha;
    }

    protected String getNome() {
        return nome;
    }

    protected String getTelefone() {
        return telefone;
    }

    protected String getEmail() {
        return email;
    }

    protected void setNome(String nome) {
        this.nome = nome;
    }

    protected void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    protected void setEmail(String email) {
        this.email = email;
    }

    protected void setSenha(String novaSenha) {
        this.senha = novaSenha;
    }
}
