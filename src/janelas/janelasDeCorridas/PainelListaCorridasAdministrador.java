package janelas.janelasDeCorridas;

import java.util.ArrayList;

import sistemas.Corridas.Corrida;
import sistemas.Usuários.Administrador;
import sistemas.painel.Painel;

public class PainelListaCorridasAdministrador extends Painel {
	public PainelListaCorridasAdministrador(ArrayList<Corrida> corridasTodasAsDisponiveis, Administrador usuario) {
		super(corridasTodasAsDisponiveis, usuario);
	}
}
