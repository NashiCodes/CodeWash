// NOME: Gabriel de Oliveira Vieira                         MATRÍCULA: 202265029A
// NOME: Ítalo de Almeida Ribeiro                           MATRÍCULA: 202176009
// NOME: João Victor Pereira dos Anjos                      MATRÍCULA: 202176010
// NOME: Lucas Henrique de Arruda Ferreira                  MATRÍCULA: 202165193AC

package CodeWash.model;

import CodeWash.exception.EmailException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Usuario {
    private final String nome;
    private String email;
    private final String senha;
    private final boolean Tipo;

    public Usuario(String nome, String email, String senha, boolean Tipo) {
        this.nome = nome;
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

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
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

    public String getNome() {
        return nome;
    }
}
