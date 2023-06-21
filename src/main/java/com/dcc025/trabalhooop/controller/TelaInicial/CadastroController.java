package com.dcc025.trabalhooop.controller.TelaInicial;

import com.dcc025.trabalhooop.view.TelaInicial;

import javax.swing.*;
import java.awt.event.*;

public class CadastroController implements ActionListener {
    private final TelaInicial tela; // Tela é a classe que contém os métodos que serão chamados
    private final boolean handle;
    private final JFrame frame;

    public CadastroController(TelaInicial tela, boolean handle, JFrame framer) { // Construtor da classe
        this.tela = tela; // Atribui a tela que será usada
        this.handle = handle;
        this.frame = framer;
    }

    @Override
    public void actionPerformed(ActionEvent e) { // Método que será chamado quando o botão for clicado
        if (handle){
            tela.cadastro(frame); // Chama o método da tela que será executado
        }
        else tela.telaCadastro(); // Chama o método da tela que será executado
    }

}
