package jefferson.telaDeAdicionarCreditos;

import java.time.LocalDate;

import ListaDeAquecimento.Mototaxista;
import ListaDeAquecimento.TipoDeConta;

public class UsuarioTeste extends Mototaxista{

	public static String nome = "jefferson";
	public static String email = "jefferson.mangueira@academico.ifpb.edu.br";
	public static String senha = "12345";
	public static TipoDeConta tipo = TipoDeConta.MOTOTAXISTA;
	public static LocalDate dataDeNascimento = LocalDate.of(2003, 2, 12);
	
	public UsuarioTeste() {
		super("Jefferson", "MASCULINO", email, senha, dataDeNascimento);
	}
	
}
