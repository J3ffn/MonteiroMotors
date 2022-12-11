package jefferson.telaDeFinancas_TERMINAR;

import ListaDeAquecimento.Administrador;
import jefferson.UsuarioTeste;
import jefferson.telaDeFinancas_TERMINAR.telas.TelaFinancas;

public class TesteFinancas {

	public static void main(String[] args) {
		
		Administrador usuario = new UsuarioTeste();
		
		TelaFinancas tela = new TelaFinancas(usuario);
		
	}
}
