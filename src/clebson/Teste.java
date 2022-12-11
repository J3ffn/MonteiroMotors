package clebson;

import ListaDeAquecimento.Administrador;
import ListaDeAquecimento.TipoDeConta;

public class Teste {
	
	public static void main(String[] args) {

		Administrador admin = new Administrador("Fulano", "MASCULINO", "fulandodetal@gmail.com", "666", null); 
		admin.setTipoDeConta(TipoDeConta.PASSAGEIRO);
		new JanelaEditarPerfil(admin);
	}
}
