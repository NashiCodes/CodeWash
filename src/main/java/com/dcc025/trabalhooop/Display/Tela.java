package com.dcc025.trabalhooop.Display;

import javax.swing.*;

public class Tela extends JFrame {

    public Tela() {
        super("Tela");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        pack();
    }

    public void telaLogin() {
        TelaLogin telaLogin = new TelaLogin();
        telaLogin.login();
    }

    public void telaCadastro() {
        TelaCadastro telaCadastro = new TelaCadastro();
        telaCadastro.telaCadastro();
    }

    public void display() {
        JPanel painel = new JPanel();
        painel.setBorder(BorderFactory.createTitledBorder("Lava Jato"));
        painel.setPreferredSize(new Dimension(WIDTH / 3, HEIGHT));

    }

}
