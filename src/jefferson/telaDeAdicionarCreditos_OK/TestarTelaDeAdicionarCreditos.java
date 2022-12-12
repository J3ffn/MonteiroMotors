package jefferson.telaDeAdicionarCreditos_OK;

import ListaDeAquecimento.CentralDeInformacoes;
import ListaDeAquecimento.Persistencia;
import jefferson.telaDeAdicionarCreditos_OK.telasParaAdicionar.TelaDeAdicionarCreditos;

public class TestarTelaDeAdicionarCreditos {

	public static void main(String[] args) {
		
		CentralDeInformacoes central = null;
		try {
			central = (CentralDeInformacoes) new Persistencia().recuperar("dados-passageiros.xml");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		TelaDeAdicionarCreditos tela = new TelaDeAdicionarCreditos(new UsuarioTeste(), central);
		
	}
}
