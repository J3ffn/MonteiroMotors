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

	private Usuario usuario;
	
	public Painel(ArrayList<Corrida> corridasTodasAsDisponiveis, Usuario usuario) {
		this.setCorridasTodasAsDisponiveis(corridasTodasAsDisponiveis);
		try {
			this.central = (CentralDeInformacoes)new Persistencia().recuperar("dados-passageiros.xml");
		} catch (Exception e) {
			e.printStackTrace();
		}
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
	public void setCentral(CentralDeInformacoes central) {
		this.central = central;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}
