package ListaDeAquecimento;

import java.time.LocalDate;

public class Administrador extends Usuario{
	
	public Administrador(String nome, String sexo, String email, String senha, LocalDate i) {
		super(nome, sexo, email, senha, i);
	}
}
