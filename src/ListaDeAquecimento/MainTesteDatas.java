package ListaDeAquecimento;

import java.time.LocalDate;

public class MainTesteDatas {

	public static void main(String[] args) {
		CentralDeInformacoes c = new CentralDeInformacoes();
		Passageiro passageiro1 = new Passageiro("João", "masculino", LocalDate.of(2004, 2, 21) , "email.teste@testando1.com");
		Passageiro passageiro2 = new Passageiro("Maria", "feminino", LocalDate.of(1998, 2, 21) , "email.teste@testando2.com");
		Passageiro passageiro3 = new Passageiro("José", "masculino", LocalDate.of(2002, 2, 21) , "email.teste@testando3.com");
		
		System.out.println(c.adicionarPassageiro(passageiro1));	
		System.out.println(c.adicionarPassageiro(passageiro2));	
		System.out.println(c.adicionarPassageiro(passageiro3));	
		
		System.out.print(c.listarTodosOsPassageiros());
	}
}
