package ListaDeAquecimento;

import java.time.LocalDate;

public class MainTesteDatas {

	public static void main(String[] args) {
		CentralDeInformacoes c = new CentralDeInformacoes();
		Usuario passageiro1 = new Passageiro("João", "masculino", "email.teste@testando1.com", "Eduardo123", LocalDate.of(2004, 2, 21));
		Usuario passageiro2 = new Passageiro("Maria", "feminino", "email.teste@testando2.com", "Bolinhas", LocalDate.of(1998, 2, 21));
		Usuario passageiro3 = new Passageiro("José", "masculino", "email.teste@testando3.com", "Tristeza", LocalDate.of(2002, 2, 21));
		
		System.out.println(c.adicionarUsuario(passageiro1));	
		System.out.println(c.adicionarUsuario(passageiro2));	
		System.out.println(c.adicionarUsuario(passageiro3));	
		
		System.out.print(c.listarTodosOsUsuarios());
	}
}
