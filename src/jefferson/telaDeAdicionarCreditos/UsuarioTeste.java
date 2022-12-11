package jefferson.telaDeAdicionarCreditos;

import java.time.LocalDate;

import ListaDeAquecimento.CentralDeInformacoes;
import ListaDeAquecimento.Mototaxista;
import ListaDeAquecimento.Persistencia;
import ListaDeAquecimento.TipoDeConta;

public class UsuarioTeste extends Mototaxista{

	public static String nome = "jefferson";
	public static String email = "jefferson.mangueira@academico.ifpb.edu.br";
	public static String senha = "12345";
	public static TipoDeConta tipo = TipoDeConta.MOTOTAXISTA;
	public static LocalDate dataDeNascimento = LocalDate.of(2003, 2, 12);
	
	public UsuarioTeste() {
		super("Jefferson", "MASCULINO", email, senha, dataDeNascimento);
		CentralDeInformacoes central;
		try {
			central = (CentralDeInformacoes) new Persistencia().recuperar("dados-passageiros.xml");
			super.adicionarCreditos(500, central);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
