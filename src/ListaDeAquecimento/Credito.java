package ListaDeAquecimento;

public class Credito {
	private float valor;
	
	public Credito(Administrador adm) {
		valor = adm.getValorDosCreditos();
	}
	public float getValor() {
		return valor;
	}
}
