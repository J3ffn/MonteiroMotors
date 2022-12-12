package janelas.janelasDeCorridas;

import java.util.ArrayList;

import sistemas.Corridas.Corrida;
import sistemas.Usuários.Passageiro;
import sistemas.painel.Painel;

public class PainelListaCorridasPassageiro extends Painel {

	public PainelListaCorridasPassageiro(ArrayList<Corrida> corridasTodasAsDisponiveis, Passageiro usuario) {
		super(corridasTodasAsDisponiveis, usuario);
	}
}
