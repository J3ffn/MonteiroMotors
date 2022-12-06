package eduardo;

import java.time.LocalDate;
import java.util.Arrays;

import ListaDeAquecimento.Administrador;
import ListaDeAquecimento.CentralDeInformacoes;
import ListaDeAquecimento.Corrida;
import ListaDeAquecimento.Mototaxista;
import ListaDeAquecimento.Persistencia;

public class Teste2 {

	public static void main(String[] args) {
		Persistencia per = new Persistencia();
		CentralDeInformacoes central = null;
		try {
			central = (CentralDeInformacoes) per.recuperar("dados-passageiros.xml");
			//JanelaDeRegistro janela = new JanelaDeRegistro(central, per);
			per.salvar(central, "dados-passageiros.xml");
		} catch (Exception erro){
			System.out.println("Houve um erro ao salvar os dados!");
		}
		
		System.out.println(central.getTodosOsUsuarios());
		LocalDate data = LocalDate.now();
		Mototaxista n = new Mototaxista("Eduardo", "Masculino", "eduardo", "kkk", null);
		Corrida c = new Corrida("Bla", "Bla", 60f, true, data , new Administrador("Eduardo", "Masculino", "edd", "kkk", null));
		
		n.adicionarCreditos(2, central);
		JanelaDeReividicacaoDeCorrida janela2 = new JanelaDeReividicacaoDeCorrida(central, c, n);
	}
}
