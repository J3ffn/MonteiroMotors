package sistemas.Usuários;

import java.time.LocalDate;

import sistemas.GestãoDeInformacoes.CentralDeInformacoes;

public class Credito {
	private float valor;
	private LocalDate data;

	public Credito(CentralDeInformacoes central, LocalDate data) {
		valor = central.recuperarAdministradorDoSistema().getValorDosCreditos();
	}

	public float getValor() {
		return valor;
	}

	public LocalDate getData() {
		return data;
	}
}
