// NOME: Gabriel de Oliveira Vieira                               MATRÍCULA: 202265029A
// NOME: Ítalo de Almeida Ribeiro                                 MATRÍCULA: 202176009
// NOME: João Victor Pereira dos Anjos                        MATRÍCULA: 202176010
// NOME: Lucas Henrique de Arruda Ferreira                MATRÍCULA: 202165193AC

package com.dcc025.trabalhooop;


public class Cadastro extends Login{

    private final String tipoUser;

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
