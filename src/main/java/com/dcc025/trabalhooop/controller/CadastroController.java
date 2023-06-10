package com.dcc025.trabalhooop.controller;

import com.dcc025.trabalhooop.view.Tela;

import java.awt.event.*;

public class CadastroController implements ActionListener {
    private final Tela tela; // Tela é a classe que contém os métodos que serão chamados
    private final boolean handle;

    public CadastroController(Tela tela, boolean handle) { // Construtor da classe
        this.tela = tela; // Atribui a tela que será usada
        this.handle = handle;
    }

    @Override
    public void actionPerformed(ActionEvent e) { // Método que será chamado quando o botão for clicado
        if (handle) tela.cadastro(); // Chama o método da tela que será executado
        else tela.telaCadastro(); // Chama o método da tela que será executado
    }

}
