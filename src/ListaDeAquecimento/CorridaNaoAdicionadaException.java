package ListaDeAquecimento;

public class CorridaNaoAdicionadaException extends Exception {
	public String getMessage() {
		return "Corrida não adicionada! Esta corrida já foi solicitada!";
	}
}
