package ouvintes.botoesPerfil;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import janelas.janelasDeUsuários.JanelaEditarPerfil;
import sistemas.Usuários.Usuario;

public class OuvinteBotaoEditarPerfil implements ActionListener {
	private JFrame janela;
	private Usuario usuario;

	public OuvinteBotaoEditarPerfil(JFrame janelaAtual, Usuario usuario) {
		janela = janelaAtual;
		this.usuario = usuario;
	}

	public void actionPerformed(ActionEvent e) {
		janela.dispose();
		new JanelaEditarPerfil(janela, usuario);
	}

}
