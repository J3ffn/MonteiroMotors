package clebsonOuvintesExternos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import jefferson.telaDeLogin.telas.TelaDeLogin;

public class OuvinteBotaoDeslogar implements ActionListener{

	JFrame janela;
	public OuvinteBotaoDeslogar(JFrame j) {
		janela = j;
	}
	public void actionPerformed(ActionEvent e) {
		janela.dispose();
		new TelaDeLogin();
	}

}
