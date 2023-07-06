// NOME: Gabriel de Oliveira Vieira                         MATRÍCULA: 202265029A
// NOME: Ítalo de Almeida Ribeiro                           MATRÍCULA: 202176009
// NOME: João Victor Pereira dos Anjos                      MATRÍCULA: 202176010
// NOME: Lucas Henrique de Arruda Ferreira                  MATRÍCULA: 202165193AC

package CodeWash.controller.TelaInicial;

import CodeWash.view.TelaInicial;

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
