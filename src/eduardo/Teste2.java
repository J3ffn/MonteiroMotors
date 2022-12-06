package eduardo;

import java.time.LocalDate;
import java.util.Arrays;

import ListaDeAquecimento.Administrador;
import ListaDeAquecimento.CentralDeInformacoes;
import ListaDeAquecimento.Corrida;
import ListaDeAquecimento.Persistencia;

public class Teste2 {

	public static void main(String[] args) {
		Persistencia per = new Persistencia();
		CentralDeInformacoes central = null;
		try {
			central = (CentralDeInformacoes) per.recuperar("dados-passageiros.xml");
			JanelaDeRegistro janela = new JanelaDeRegistro(central, per);
			per.salvar(central, "dados-passageiros.xml");
		} catch (Exception erro){
			System.out.println("Houve um erro ao salvar os dados!");
		}
		
		System.out.println(central.getTodosOsUsuarios());
		LocalDate data = LocalDate.now();
		//JanelaDeReividicacaoDeCorrida janela2 = new JanelaDeReividicacaoDeCorrida(new Corrida("Bla", "Bla", 60f, true, data , new Administrador("Eduardo", "Masculino", "edd", "kkk", null)));
	}
}
