package ListaDeAquecimento;

import java.time.LocalDate;

public class ValorCorrida {

	private int valor;
	private LocalDate data;
	
	public ValorCorrida(int valor, LocalDate data){
		this.valor = valor;
		this.data = data;
	}

	public int getValor() {
		return valor;
	}

	public LocalDate getData() {
		return data;
	}
	
}
