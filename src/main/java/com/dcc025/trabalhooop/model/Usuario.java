// NOME: Gabriel de Oliveira Vieira                               MATRÍCULA: 202265029A
// NOME: Ítalo de Almeida Ribeiro                                 MATRÍCULA: 202176009
// NOME: João Victor Pereira dos Anjos                        MATRÍCULA: 202176010
// NOME: Lucas Henrique de Arruda Ferreira                MATRÍCULA: 202165193AC

package com.dcc025.trabalhooop.model;

import com.dcc025.trabalhooop.exception.EmailException;

import java.util.Scanner;
import java.util.regex.*;

public class Usuario {
    private static final Scanner scan = new Scanner(System.in);
    private String nome;
    private String telefone;
    private String email;
    private String senha;
    private final boolean Tipo;

    public Usuario(String nome, String telefone, String email, String senha, boolean Tipo) {
        this.nome = nome;
        this.telefone = telefone;
        try {
            if (isValido(email)) {
                this.email = email;
            } else {
                throw new EmailException();
            }
        } catch (EmailException e) {
            System.out.println(e.getMessage());
        }
        this.senha = senha;
        this.Tipo = Tipo;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String novaSenha) {
        this.senha = novaSenha;
    }

    private boolean isValido(String email) {
        String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public boolean getTipo() {
        return Tipo;
    }
}
