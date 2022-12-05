package eduardo;

import java.time.LocalDate;

import ListaDeAquecimento.Administrador;
import ListaDeAquecimento.Corrida;

public class Teste2 {

	public static void main(String[] args) {
		//JanelaDeRegistro janela = new JanelaDeRegistro();
		LocalDate data = LocalDate.now();
		JanelaDeReividicacaoDeCorrida janela2 = new JanelaDeReividicacaoDeCorrida(new Corrida("Bla", "Bla", 60f, true, data , new Administrador("Eduardo", "Masculino", "edd", "kkk", null)));
	}
}
