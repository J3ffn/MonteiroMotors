package eduardo;

import ListaDeAquecimento.CentralDeInformacoes;
import ListaDeAquecimento.Persistencia;
import eduardo.Janelas.JanelaDeRegistro;
import jefferson.telaDeLogin_OK.telas.TelaDeLogin;

public class Programa {
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Persistencia per = new Persistencia();
		CentralDeInformacoes central;
		try {
			central = (CentralDeInformacoes) per.recuperar("dados-passageiros.xml");
			if(central.getTodosOsUsuarios().isEmpty()) {
				new JanelaDeRegistro();
			} else {
				TelaDeLogin tela1 = new TelaDeLogin(central, per);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
