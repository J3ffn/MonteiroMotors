package clebsonOuvintesExternos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import ListaDeAquecimento.Usuario;
import clebson.JanelaEditarPerfil;

public class OuvinteBotaoEditarPerfil implements ActionListener{
	JFrame janela;
	Usuario usuario;
	
	public OuvinteBotaoEditarPerfil(JFrame j, Usuario usuario) {
		janela = j;
		this.usuario = usuario;
	}
	public void actionPerformed(ActionEvent e) {
		new JanelaEditarPerfil(usuario);
	}

}
