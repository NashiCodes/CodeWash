package com.dcc025.trabalhooop.controller;

import com.dcc025.trabalhooop.view.Tela;

import java.awt.event.*;

public class LoginController implements ActionListener {
    private final Tela tela; // Tela é a classe que contém os métodos que serão chamados

    public LoginController(Tela tela) {// Construtor da classe
        this.tela = tela; // Atribui a tela que será usada
    }

    @Override
    public void actionPerformed(ActionEvent e) { // Método que será chamado quando o botão for clicado
        tela.login(); // Chama o método da tela que será executado
    }

}
