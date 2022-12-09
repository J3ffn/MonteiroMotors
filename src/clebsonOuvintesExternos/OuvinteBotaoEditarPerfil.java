package clebsonOuvintesExternos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import clebson.JanelaEditarPerfil;

public class OuvinteBotaoEditarPerfil implements ActionListener{
	
	JFrame janela;
	public OuvinteBotaoEditarPerfil(JFrame j) {
		janela = j;
	}
	public void actionPerformed(ActionEvent e) {
		janela.dispose();
		new JanelaEditarPerfil();
	}

}
