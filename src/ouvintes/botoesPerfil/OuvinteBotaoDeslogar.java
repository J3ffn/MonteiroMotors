package ouvintes.botoesPerfil;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import janelas.janelaDeLogin.JanelaDeLogin;
import sistemas.GestãoDeInformacoes.CentralDeInformacoes;

public class OuvinteBotaoDeslogar implements ActionListener {

	JFrame janela;
	CentralDeInformacoes central;

	public OuvinteBotaoDeslogar(JFrame j, CentralDeInformacoes c) {
		janela = j;
		central = c;
	}

	public void actionPerformed(ActionEvent e) {
		janela.dispose();
		new JanelaDeLogin();

	}
}
