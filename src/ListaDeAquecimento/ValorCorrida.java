package ListaDeAquecimento;

import java.time.LocalDateTime;

public class ValorCorrida {

	private int valor;
	private LocalDateTime data;
	
	public ValorCorrida(int valor, LocalDateTime data){
		this.valor = valor;
		this.data = data;
	}

	public int getValor() {
		return valor;
	}

	public LocalDateTime getData() {
		return data;
	}
	
	@Override
	public String toString() {
		return String.format("%d - %s", valor, data);
	}
	
}
