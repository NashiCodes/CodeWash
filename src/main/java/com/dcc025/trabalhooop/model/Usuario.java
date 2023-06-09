// NOME: Gabriel de Oliveira Vieira                               MATRÍCULA: 202265029A
// NOME: Ítalo de Almeida Ribeiro                                 MATRÍCULA: 202176009
// NOME: João Victor Pereira dos Anjos                        MATRÍCULA: 202176010
// NOME: Lucas Henrique de Arruda Ferreira                MATRÍCULA: 202165193AC

package com.dcc025.trabalhooop.model;

import com.dcc025.trabalhooop.Login.Cadastro;

import java.util.*;
import java.util.regex.*;

public class Usuario {
    private static final Scanner scan = new Scanner(System.in);
    private String nome;
    private String telefone;
    private String email;
    private String senha;

    public Usuario(String nome, String telefone, String email, String senha) {
        this.nome = nome;
        this.telefone = telefone;
        while (!this.isValido(email)) {
            System.out.println("Email invalido, digite um novo email: ");
            email = leitor();
        }
        this.email = email;
        this.senha = senha;
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

    public String getSenha(List<Cadastro> usuarios) {
        for (Cadastro cadastro : usuarios) {
            if (cadastro.getEmail().equals(this.email))
                return null;
        }
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

    private static String leitor() {
        return scan.nextLine();
    }

    private boolean isValido(String email) {
        String regex = "^[\\w.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
