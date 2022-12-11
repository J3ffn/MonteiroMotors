package clebson;

import javax.swing.JFrame;

import ListaDeAquecimento.CentralDeInformacoes;
import ListaDeAquecimento.Passageiro;
import ListaDeAquecimento.Persistencia;
import ListaDeAquecimento.Usuario;

@SuppressWarnings("serial")
public class JanelaPadrao extends JFrame {
	private CentralDeInformacoes central;
	private Persistencia persistencia;
	private Usuario usuario;
	
	public CentralDeInformacoes getCentral() {
		return central;
	}

	public Persistencia getPersistencia() {
		return persistencia;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public JanelaPadrao(String titulo, Usuario usuario) {
		try {
			this.setCentral((CentralDeInformacoes)new Persistencia().recuperar("dados-passageiros.xml"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.usuario = usuario;
		setTitle(titulo);
		setSize(498, 462);
		setResizable(false);
		setLocationRelativeTo(null);				
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	public void setCentral(CentralDeInformacoes central) {
		this.central = central;
	}

	public void setPersistencia(Persistencia persistencia) {
		this.persistencia = persistencia;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
