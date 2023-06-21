package com.dcc025.trabalhooop.controller.TelaInicial;

import com.dcc025.trabalhooop.view.TelaInicial;

import java.awt.event.*;

public class LoginController implements ActionListener {
    private final TelaInicial tela; // Tela é a classe que contém os métodos que serão chamados

    public LoginController(TelaInicial tela) {// Construtor da classe
        this.tela = tela; // Atribui a tela que será usada
    }

    @Override
    public void actionPerformed(ActionEvent e) { // Método que será chamado quando o botão for clicado
        tela.login(); // Chama o método da tela que será executado
    }

}
