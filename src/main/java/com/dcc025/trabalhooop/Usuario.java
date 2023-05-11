package com.dcc025.trabalhooop;

import java.util.*;
import java.util.regex.*;

public class Usuario {
    private static final Scanner scan = new Scanner(System.in);
    protected String nome;
    protected String telefone;
    protected String email;
    protected String senha;

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

    protected String getNome() {
        return nome;
    }

    protected String getTelefone() {
        return telefone;
    }

    protected String getEmail() {
        return email;
    }

    protected String getSenha(List<Cadastro> usuarios) {
        for (Cadastro cadastro : usuarios) {
            if (cadastro.getEmail() == this.email)
                return null;
        }
        return senha;
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

    private static String leitor() {
        String string = scan.nextLine();
        return string;
    }

    private boolean isValido(String email) {
        String regex = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
