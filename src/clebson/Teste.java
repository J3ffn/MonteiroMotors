package clebson;

import ListaDeAquecimento.Administrador;

public class Teste {
	
	public static void main(String[] args) {

		Administrador admin = new Administrador("Fulano", "MASCULINO", "fulandodetal@gmail.com", "666", null); 
		new JanelaEditarPerfilAdmin(admin);
	}
}
