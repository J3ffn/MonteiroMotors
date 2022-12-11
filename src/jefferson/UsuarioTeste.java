package jefferson;

import java.time.LocalDate;

import ListaDeAquecimento.TipoDeConta;
import ListaDeAquecimento.Usuario;

public class UsuarioTeste extends Usuario{

	public static String nome = "jefferson";
	public static String email = "jefferson.mangueira@academico.ifpb.edu.br";
	public static String senha = "12345";
	public static TipoDeConta tipo = TipoDeConta.ADMINISTRADOR;
	public static LocalDate dataDeNascimento = LocalDate.of(2003, 2, 12);
	
	public UsuarioTeste() {
		super("Jefferson", "MASCULINO", email, senha, dataDeNascimento);
	}
	
	@Override
	public String recuperarCargo() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
