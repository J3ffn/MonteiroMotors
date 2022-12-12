package jefferson.telaDeLogin_OK.telas;

import ListaDeAquecimento.CentralDeInformacoes;
import ListaDeAquecimento.Persistencia;

public class TesteLogin {
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Persistencia per = new Persistencia();
		CentralDeInformacoes central;
		try {
			central = (CentralDeInformacoes) per.recuperar("dados-passageiros.xml");
			TelaDeLogin tela1 = new TelaDeLogin();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
