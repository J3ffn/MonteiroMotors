package sistemas.Usuários;

import java.time.LocalDateTime;

import sistemas.GestãoDeInformacoes.CentralDeInformacoes;

public class Credito {
	private float valor;
	private LocalDateTime data;

	public Credito(CentralDeInformacoes central, LocalDateTime data) {
		valor = central.recuperarAdministradorDoSistema().getValorDosCreditos();
		this.data = data.now();
	}

	public float getValor() {
		return valor;
	}

	public LocalDateTime getData() {
		return data;
	}
}
