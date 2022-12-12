package exceções;

public class SenhaIncorretaException extends Exception {
	public String getMesaage() {
		return "Senha Incorreta!";
	}
}
