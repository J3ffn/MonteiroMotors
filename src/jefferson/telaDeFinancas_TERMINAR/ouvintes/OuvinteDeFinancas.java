package jefferson.telaDeFinancas_TERMINAR.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ListaDeAquecimento.Mensageiro;
import ListaDeAquecimento.Usuario;

public class OuvinteDeFinancas implements ActionListener {
	
	private String email;
	
	public OuvinteDeFinancas(Usuario usuario){
		email = usuario.getEmail();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Mensageiro mensageiro = new Mensageiro();
		mensageiro.enviarRelatorioFinancas(email);
		
	}

}
