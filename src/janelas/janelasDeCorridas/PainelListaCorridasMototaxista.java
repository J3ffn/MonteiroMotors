package janelas.janelasDeCorridas;

import java.util.ArrayList;

import sistemas.Corridas.Corrida;
import sistemas.Usuários.Mototaxista;
import sistemas.painel.Painel;

public class PainelListaCorridasMototaxista extends Painel {

	public PainelListaCorridasMototaxista(ArrayList<Corrida> corridasTodasAsDisponiveis, Mototaxista usuario) {
		super(corridasTodasAsDisponiveis, usuario);
	}
}
