package clebson;

import javax.swing.JFrame;

import ListaDeAquecimento.CentralDeInformacoes;
import ListaDeAquecimento.Passageiro;
import ListaDeAquecimento.Persistencia;
import ListaDeAquecimento.Usuario;

@SuppressWarnings("serial")
public class JanelaPadrao extends JFrame {
	protected CentralDeInformacoes central;
	protected Persistencia persistencia;
	protected Usuario usuario;
	
	public CentralDeInformacoes getCentral() {
		return central;
	}

	public Persistencia getPersistencia() {
		return persistencia;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public JanelaPadrao(String titulo) {
		setTitle(titulo);
		setSize(498, 462);
		setResizable(false);
		setLocationRelativeTo(null);				
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}
