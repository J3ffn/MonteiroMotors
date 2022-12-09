package eduardo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;

import ListaDeAquecimento.Administrador;
import ListaDeAquecimento.CentralDeInformacoes;
import ListaDeAquecimento.Corrida;
import ListaDeAquecimento.Mototaxista;
import ListaDeAquecimento.Passageiro;
import ListaDeAquecimento.Persistencia;
import clebson.TelaPassageiro;

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
		
		LocalDateTime data = LocalDateTime.now();
		Passageiro n = new Passageiro("Eduardo", "Masculino", "eduardo", "kkk", null);
		Mototaxista n1 = new Mototaxista("Eduardo", "Masculino", "eduardo", "kkk", null);
		Administrador adm =  new Administrador("Eduardo", "Masculino", "edd", "kkk", null);
		Corrida c = new Corrida("Bla", "Bla", 60f, true, data, adm);
		n1.adicionarCreditos(2, central);
		
		//n.adicionarCreditos(2, central);
		//JanelaDeReividicacaoDeCorrida janela2 = new JanelaDeReividicacaoDeCorrida(central, c, n);
		JanelaDeCadastroDeCorrida janela5 = new JanelaDeCadastroDeCorrida(central, per, n);
		//TelaPassageiro janela2 = new TelaPassageiro(central, per, n);
		//JanelaDeDefinicaoDeValorDosCreditos j = new JanelaDeDefinicaoDeValorDosCreditos(adm);
		JanelaDeCorridasDisponiveis j = new JanelaDeCorridasDisponiveis(n1, central, per);
	}
}
