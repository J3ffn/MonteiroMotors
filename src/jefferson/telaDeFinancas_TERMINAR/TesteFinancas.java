package jefferson.telaDeFinancas_TERMINAR;

import ListaDeAquecimento.Administrador;
import ListaDeAquecimento.CentralDeInformacoes;
import ListaDeAquecimento.Persistencia;
import jefferson.UsuarioTeste;
import jefferson.telaDeFinancas_TERMINAR.telas.TelaFinancas;

public class TesteFinancas {

	public static void main(String[] args) {
		
		Administrador usuario = new UsuarioTeste();
		
		try {
			CentralDeInformacoes central = (CentralDeInformacoes) new Persistencia().recuperar("dados-passageiros.xml");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		TelaFinancas tela = new TelaFinancas(usuario);
		
	}
}
