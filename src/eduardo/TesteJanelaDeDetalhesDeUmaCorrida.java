package eduardo;

import java.util.ArrayList;

import ListaDeAquecimento.CentralDeInformacoes;
import ListaDeAquecimento.Corrida;
import ListaDeAquecimento.Persistencia;
import ListaDeAquecimento.Usuario;
import eduardo.JanelaCorridasDisponiveis.JanelaDeAvaliacao;
import eduardo.JanelaCorridasDisponiveis.JanelaDeDetalhesDeUmaCorrida;

public class TesteJanelaDeDetalhesDeUmaCorrida {

	public static void main(String[] args) {
		
		CentralDeInformacoes central = null;
		try {
			central = (CentralDeInformacoes) new Persistencia().recuperar("dados-passageiros.xml");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		ArrayList<Corrida> corrida = central.recuperarCorridasDeUmPassageiro("jefferson.passageiro@gmail.com");
		Usuario usuario = central.recuperarUsuarioPeloEmail("jefferson.passageiro@gmail.com");
//		
//		JanelaDeDetalhesDeUmaCorrida tela = new JanelaDeDetalhesDeUmaCorrida(corrida.get(0), usuario);
		
		new JanelaDeAvaliacao(corrida.get(0), usuario);
		
	}
}
