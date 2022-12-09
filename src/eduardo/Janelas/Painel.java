package eduardo.Janelas;

import java.util.ArrayList;

import javax.swing.JPanel;

import ListaDeAquecimento.CentralDeInformacoes;
import ListaDeAquecimento.ComparacaoData;
import ListaDeAquecimento.Corrida;
import ListaDeAquecimento.Persistencia;
import ListaDeAquecimento.Usuario;

public abstract class Painel extends JPanel{
	protected ArrayList < Corrida > corridasTodasAsDisponiveis;
	protected CentralDeInformacoes central;
	protected Persistencia persistencia; 
	protected Usuario usuario;
	
	public Painel(ArrayList<Corrida> corridasTodasAsDisponiveis, CentralDeInformacoes central,
			Persistencia persistencia, Usuario usuario) {
		this.corridasTodasAsDisponiveis = corridasTodasAsDisponiveis;
		this.central = central;
		this.persistencia = persistencia;
		this.usuario = usuario;
		this.preencherPainel();
	}
	public abstract void preencherPainel();
	public ArrayList<Corrida> getCorridasTodasAsDisponiveis() {
		return corridasTodasAsDisponiveis;
	}
	public CentralDeInformacoes getCentral() {
		return central;
	}
	public Persistencia getPersistencia() {
		return persistencia;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public ArrayList<Corrida> getCorridasOrganizadasMaisRecentes() {
		ArrayList<Corrida> corrida = corridasTodasAsDisponiveis;
		corrida.sort(new ComparacaoData());
		return corrida;
	}
}
