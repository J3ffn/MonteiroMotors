package jefferson.telaDeFinancas_TERMINAR;

import jefferson.UsuarioTeste;
import jefferson.telaDeFinancas_TERMINAR.telas.TelaFinancas;

public class TesteFinancas {

	public static void main(String[] args) {
		
		TelaFinancas tela = new TelaFinancas(new UsuarioTeste().getEmail());
		
	}
}
