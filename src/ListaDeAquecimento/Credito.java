package ListaDeAquecimento;

public class Credito {
	private float valor;
	
	public Credito(CentralDeInformacoes central) {
		valor = central.recuperarAdministradorDoSistema().getValorDosCreditos();
	}
	public float getValor() {
		return valor;
	}
}
