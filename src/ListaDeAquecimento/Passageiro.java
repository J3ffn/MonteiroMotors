package ListaDeAquecimento;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Passageiro extends Usuario{
	private ArrayList < Mototaxista > mototaxistasBloqueados = new ArrayList < Mototaxista >();
	
	public Passageiro(String nome, String sexo, String email, String senha, LocalDate i) {
		super(nome, sexo, email, senha, i);
		this.setTipoDeConta(TipoDeConta.PASSAGEIRO);
	}
	public String recuperarCargo() {
		return "Passageiro";
	}
	public void cadastrarCorrida(String enderecoP, String enderecoD, float distancia, boolean paraAgora, LocalDateTime data, CentralDeInformacoes central) throws CorridaNaoAdicionadaException{
		boolean deuCerto = central.adicionarCorrida(new Corrida(enderecoP, enderecoD, distancia, paraAgora, data, this, new ValorCorrida(1, data)));
		if(!deuCerto)
			throw new CorridaNaoAdicionadaException();
	}
	public void avaliarCorrida(Corrida cor, Mototaxista mot, float nota, String comentario, CentralDeInformacoes central) {
		central.adicionarAvaliacao(new Avaliacao(cor, this, mot, nota, comentario));
	}
	public void bloquearMototaxista(Mototaxista mototaxista) {
		mototaxistasBloqueados.add(mototaxista);
	}
	public boolean verificarSeEBloqueado(Mototaxista mototaxista) {
		for(Mototaxista m : mototaxistasBloqueados) {
			if(mototaxista.equals(m)) {
				return true;
			}
		}
		return false;
	}
}
