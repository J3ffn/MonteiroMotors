package ouvintes.botoesPerfil;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import janelas.janelasDeUsuários.JanelaEditarPerfil;
import sistemas.Usuários.Usuario;

public class OuvinteBotaoEditarPerfil implements ActionListener {
	JFrame janela;
	Usuario usuario;

	public OuvinteBotaoEditarPerfil(JFrame j, Usuario usuario) {
		janela = j;
		this.usuario = usuario;
	}

	public void actionPerformed(ActionEvent e) {
		janela.dispose();
		new JanelaEditarPerfil(usuario);
	}

}
