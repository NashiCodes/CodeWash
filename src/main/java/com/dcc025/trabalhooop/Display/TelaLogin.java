package com.dcc025.trabalhooop.Display;

import javax.swing.*;
import com.dcc025.trabalhooop.Login.*;

public class TelaLogin extends JFrame {

    public TelaLogin() {
        super("TelaLogin");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public Login login() {
        String email = JOptionPane.showInputDialog("Digite seu email: ");
        String senha = JOptionPane.showInputDialog("Digite sua senha: ");
        return new Login(email, senha);
    }

}
