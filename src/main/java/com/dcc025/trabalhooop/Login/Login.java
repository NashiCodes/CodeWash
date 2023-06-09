// NOME: Gabriel de Oliveira Vieira                               MATRÍCULA: 202265029A
// NOME: Ítalo de Almeida Ribeiro                                 MATRÍCULA: 202176009
// NOME: João Victor Pereira dos Anjos                        MATRÍCULA: 202176010
// NOME: Lucas Henrique de Arruda Ferreira                MATRÍCULA: 202165193AC

package com.dcc025.trabalhooop.Login;

import java.util.regex.*;

import com.dcc025.trabalhooop.exception.EmailException;

public class Login {

    private String email;
    private String senha;

    public Login(String email, String senha) throws EmailException{
        setEmail(email);
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

    protected void setEmail(String novoEmail) throws EmailException{
        if (!isValido(novoEmail))
            throw new EmailException();
        else
            this.email = novoEmail;
    }

    protected void setSenha(String novaSenha) {
        this.senha = novaSenha;
    }
}
