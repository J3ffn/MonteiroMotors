package ListaDeAquecimento;

import java.time.LocalDate;
import java.util.ArrayList;

public class Mototaxista extends Usuario{
	private ArrayList < Avaliacao > avaliacoes = new ArrayList < Avaliacao >();
	
	public Mototaxista(String nome, String sexo, String email, String senha, LocalDate i) {
		super(nome, sexo, email, senha, i);
	}
	
	public void addAvaliacao(Avaliacao a) {
		avaliacoes.add(a);
	}
}
