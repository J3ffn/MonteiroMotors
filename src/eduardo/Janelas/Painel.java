package eduardo.Janelas;

import java.util.ArrayList;

import javax.swing.JPanel;

import ListaDeAquecimento.CentralDeInformacoes;
import ListaDeAquecimento.Corrida;
import ListaDeAquecimento.Persistencia;
import ListaDeAquecimento.Usuario;

public abstract class Painel extends JPanel{
	ArrayList < Corrida > corridasTodasAsDisponiveis;
	CentralDeInformacoes central;
	Persistencia persistencia; 
	Usuario usuario;
	
	public Painel(ArrayList<Corrida> corridasTodasAsDisponiveis, CentralDeInformacoes central,
			Persistencia persistencia, Usuario usuario) {
		this.corridasTodasAsDisponiveis = corridasTodasAsDisponiveis;
		this.central = central;
		this.persistencia = persistencia;
		this.usuario = usuario;
		this.preencherPainel();
	}
	public abstract void preencherPainel();
}
