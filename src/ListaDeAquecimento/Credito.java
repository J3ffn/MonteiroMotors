package ListaDeAquecimento;

import java.time.LocalDate;

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
