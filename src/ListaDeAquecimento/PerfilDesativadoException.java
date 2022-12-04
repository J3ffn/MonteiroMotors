package ListaDeAquecimento;

public class PerfilDesativadoException extends Exception {
	public String getMessage() {
		return "O perfil foi desativado!";
	}
}
