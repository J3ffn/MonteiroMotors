package jefferson;

import java.time.LocalDate;

import ListaDeAquecimento.Administrador;
import ListaDeAquecimento.TipoDeConta;

public class UsuarioTeste extends Administrador{

	public static String nome = "jefferson";
	public static String email = "jefferson.mangueira@academico.ifpb.edu.br";
	public static String senha = "12345";
	public static TipoDeConta tipo = TipoDeConta.ADMINISTRADOR;
	public static LocalDate dataDeNascimento = LocalDate.of(2003, 2, 12);
	
	public UsuarioTeste() {
		super("Jefferson", "MASCULINO", "jefferson.mangueira@academico.ifpb.edu.br", senha, dataDeNascimento);
	}
	
	
}
