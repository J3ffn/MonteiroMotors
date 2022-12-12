package ouvintes.login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import janelas.janelasDeRecuperacao.JanelaDeRecuperarSenha;

public class OuvinteBotaoEsqueceuSenha implements ActionListener {

	private JFrame tela;

	public OuvinteBotaoEsqueceuSenha(JFrame tela) {
		this.tela = tela;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		tela.dispose();
		new JanelaDeRecuperarSenha();
	}

}
