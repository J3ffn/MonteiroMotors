package PROGRAMA;

import ListaDeAquecimento.CentralDeInformacoes;
import ListaDeAquecimento.Persistencia;
import jefferson.telaDeLogin_OK.telas.TelaDeLogin;

public class ProgramaPrincipal {

	public static void main(String[] args) {
		
		TelaDeLogin tela = new TelaDeLogin(new CentralDeInformacoes(), new Persistencia());
		
	}
}
