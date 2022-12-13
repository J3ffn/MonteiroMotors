package sistemas.Usuários;

import java.time.LocalDate;
import java.util.ArrayList;

import exceções.AdicaoInvalidaException;
import exceções.MotoTaxistaSemCreditosCreditosException;
import sistemas.Corridas.Avaliacao;
import sistemas.Corridas.Corrida;
import sistemas.Corridas.Status;
import sistemas.GestãoDeInformacoes.CentralDeInformacoes;
import sistemas.GestãoDeInformacoes.Persistencia;

public class Mototaxista extends Usuario {
	private ArrayList<Avaliacao> avaliacoes = new ArrayList<Avaliacao>();
	private ArrayList<Credito> creditos = new ArrayList<Credito>();
	private Corrida corridaAtual;

	public Mototaxista(String nome, String sexo, String email, String senha, LocalDate i) {
		super(nome, sexo, email, senha, i);
		setTipoDeConta(TipoDeConta.MOTOTAXISTA);
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

	public float adicionarCreditos(int num, CentralDeInformacoes central) throws AdicaoInvalidaException {
		if (num <= 0) {
			throw new AdicaoInvalidaException();
		} else {
			float totalASerPago = 0;
			for (int i = 0; i < num; i++) {
				Credito c = new Credito(central, LocalDate.now());
				creditos.add(c);
				totalASerPago += c.getValor();
			}
			try {
				new Persistencia().salvar(central, "dados-passageiros.xml");
			} catch (Exception e1) {
				e1.printStackTrace();
			}

			return totalASerPago;
		}
	}

	public void reinvidicarCorrida(Corrida corrida, CentralDeInformacoes central)
			throws MotoTaxistaSemCreditosCreditosException {
		if (!creditos.isEmpty()) {
			creditos.remove(0);
			corridaAtual = corrida;
			corrida.setMototaxista(this);
			corrida.setStatus(Status.REINVINDICADA);
			central.atualizarCentral(corrida);
		} else {
			throw new MotoTaxistaSemCreditosCreditosException();
		}
	}

	public void concluirCorrida(CentralDeInformacoes central) {
		corridaAtual.setStatus(Status.CONCLUIDA);
		central.atualizarCentral(corridaAtual);
		corridaAtual = null;
	}

	public Corrida getCorridaAtual() {
		return corridaAtual;
	}
}
