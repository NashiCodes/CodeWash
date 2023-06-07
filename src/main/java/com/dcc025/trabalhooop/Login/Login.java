// NOME: Gabriel de Oliveira Vieira                               MATRÍCULA: 202265029A
// NOME: Ítalo de Almeida Ribeiro                                 MATRÍCULA: 202176009
// NOME: João Victor Pereira dos Anjos                        MATRÍCULA: 202176010
// NOME: Lucas Henrique de Arruda Ferreira                MATRÍCULA: 202165193AC

package com.dcc025.trabalhooop.Login;

import java.util.regex.*;

public class Login {

    private String email;
    private String senha;

    public Login(String email, String senha) {
        if (isValido(email))
            this.email = email;
         else
            System.out.println("Email invalido !!");
        this.senha = senha;
    }

    private boolean isValido(String email) {
        String regex = "^[\\w.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public String getEmail() {
        return email;
    }

    protected String getSenha() {
        return senha;
    }

    protected void setEmail(String novoEmail) {
        if (isValido(novoEmail))
            this.email = novoEmail;
        else
            System.out.println("Email invalido!!");
    }

    protected void setSenha(String novaSenha) {
        this.senha = novaSenha;
    }
}