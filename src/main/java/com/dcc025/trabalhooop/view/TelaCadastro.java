package com.dcc025.trabalhooop.view;

import com.dcc025.trabalhooop.Login.Cadastro;

import javax.swing.*;

public class TelaCadastro extends JFrame {

public TelaCadastro() {
        super("TelaCadastro");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public Cadastro telaCadastro() {
        String email = JOptionPane.showInputDialog("Digite seu email: ");
        String senha = JOptionPane.showInputDialog("Digite sua senha: ");
        String tipoUser = JOptionPane.showInputDialog("Digite seu tipo de usuário: ");
        return new Cadastro(email, senha, tipoUser);
    }

}
