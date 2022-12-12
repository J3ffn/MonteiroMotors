package clebson;

import ListaDeAquecimento.Administrador;
import ListaDeAquecimento.TipoDeConta;

public class Teste {
	
	public static void main(String[] args) {

		Administrador admin = new Administrador("Admin", "Masculino", "admin@admin.admin", "adminnimda", null);
		admin.setTipoDeConta(TipoDeConta.ADMINISTRADOR);
		new JanelaEditarPerfil(admin);
	}
}
