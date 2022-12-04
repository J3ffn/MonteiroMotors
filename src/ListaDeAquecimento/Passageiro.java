package ListaDeAquecimento;

import java.time.LocalDate;
import java.util.ArrayList;

public class Passageiro extends Usuario{
	private ArrayList < Mototaxista > mototaxistasBloqueados = new ArrayList < Mototaxista >();
	
	public Passageiro(String nome, String sexo, String email, String senha, LocalDate i) {
		super(nome, sexo, email, senha, i);
	}
	
	public void cadastrarCorrida(String enderecoP, String enderecoD, float distancia, boolean paraAgora, LocalDate data, CentralDeInformacoes central) throws CorridaNaoAdicionadaException{
		boolean deuCerto = central.adicionarCorrida(new Corrida(enderecoP, enderecoD, distancia, paraAgora, data, this));
		if(!deuCerto)
			throw new CorridaNaoAdicionadaException();
	}
	public void avaliarCorrida(Corrida cor, Mototaxista mot, float nota, String comentario, CentralDeInformacoes central) {
		central.adicionarAvaliacao(new Avaliacao(cor, this, mot, nota, comentario));
	}
	public void bloquearMototaxista(Mototaxista mototaxista) {
		mototaxistasBloqueados.add(mototaxista);
	}
}
