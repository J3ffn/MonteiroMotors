package ListaDeAquecimento;

import java.time.LocalDate;
import java.util.ArrayList;

public class Mototaxista extends Usuario{
	private ArrayList < Avaliacao > avaliacoes = new ArrayList < Avaliacao >();
	private ArrayList < Credito > creditos = new ArrayList < Credito >();
	
	public Mototaxista(String nome, String sexo, String email, String senha, LocalDate i) {
		super(nome, sexo, email, senha, i);
	}
	public String recuperarCargo() {
		return "Mototaxista";
	}
	public void addAvaliacao(Avaliacao a) {
		avaliacoes.add(a);
	}
	public ArrayList<Credito> getCreditos() {
		return creditos;
	}
	public float adicionarCreditos(int num, CentralDeInformacoes central) {
		float totalASerPago = 0;
		for(int i = 0; i < num; i++) {
			Credito c = new Credito(central);
			creditos.add(c);
			totalASerPago += c.getValor();
		}
		return totalASerPago;
	}
	public void reinvidicarCorrida(Corrida corrida) throws MotoTaxistaSemCreditosCreditosException {
		if(!creditos.isEmpty()) {
			creditos.remove(0);
			corrida.setMototaxista(this);
			corrida.setStatus(Status.EM_CURSO);
		} else {
			throw new MotoTaxistaSemCreditosCreditosException();
		}
	}
}
