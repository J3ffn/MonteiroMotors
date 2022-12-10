package eduardo.JanelaCorridasDisponiveis;

import java.util.ArrayList;

import javax.swing.JPanel;

import ListaDeAquecimento.CentralDeInformacoes;
import ListaDeAquecimento.ComparacaoData;
import ListaDeAquecimento.ComparacaoData2;
import ListaDeAquecimento.Corrida;
import ListaDeAquecimento.Persistencia;
import ListaDeAquecimento.Usuario;

public abstract class Painel extends JPanel{
	private ArrayList < Corrida > corridasTodasAsDisponiveis;
	private  CentralDeInformacoes central;

	private Persistencia persistencia; 
	private Usuario usuario;
	
	public Painel(ArrayList<Corrida> corridasTodasAsDisponiveis, CentralDeInformacoes central,
			Persistencia persistencia, Usuario usuario) {
		this.setCorridasTodasAsDisponiveis(corridasTodasAsDisponiveis);
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
		ArrayList<Corrida> corrida = getCorridasTodasAsDisponiveis();
		ComparacaoData c = new ComparacaoData();
		corrida.sort(c);
		return corrida;
	}
	public ArrayList <Corrida> getCorridasOrganizadasMaisAntigas() {
		ArrayList <Corrida> corrida = getCorridasTodasAsDisponiveis();
		ComparacaoData2 c = new ComparacaoData2();
		corrida.sort(c);
		return corrida;
	}
	public void setCorridasTodasAsDisponiveis(ArrayList < Corrida > corridasTodasAsDisponiveis) {
		this.corridasTodasAsDisponiveis = corridasTodasAsDisponiveis;
	}
}
