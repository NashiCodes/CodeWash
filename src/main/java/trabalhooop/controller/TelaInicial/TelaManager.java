package trabalhooop.controller.TelaInicial;

import trabalhooop.model.Usuario;
import trabalhooop.persistence.Persistence;
import trabalhooop.persistence.UserPersistence;
import trabalhooop.view.TelaInicial;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.List;

public class TelaManager implements WindowListener {

    private final TelaInicial tela;

    public TelaManager(TelaInicial tela) {
        this.tela = tela;
    }

    @Override
    public void windowOpened(WindowEvent e) {
        Persistence<Usuario> usuarioPersistence = new UserPersistence();
        List<Usuario> usuarios = usuarioPersistence.findAll();
        tela.carregaUsuarios(usuarios);
    }

    @Override
    public void windowClosing(WindowEvent e) {
        Persistence<Usuario> usuarioPersistence = new UserPersistence();
        usuarioPersistence.save(tela.getUsuarios());
    }

    @Override
    public void windowClosed(WindowEvent e) {
        Persistence<Usuario> usuarioPersistence = new UserPersistence();
        usuarioPersistence.save(tela.getUsuarios());
    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }
}