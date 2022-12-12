package exceções;

public class MotoTaxistaSemCreditosCreditosException extends Exception {
	public String getMessage() {
		return "O mototaxista não tem créditos de reividicação!";
	}
}
