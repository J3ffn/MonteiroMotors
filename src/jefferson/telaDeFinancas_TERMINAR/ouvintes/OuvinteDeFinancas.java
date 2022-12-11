package jefferson.telaDeFinancas_TERMINAR.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;

import ListaDeAquecimento.Corrida;
import ListaDeAquecimento.Mensageiro;
import ListaDeAquecimento.Usuario;

public class OuvinteDeFinancas implements ActionListener {
	
	private String email;
	private ArrayList< Corrida > corridas;
	private LocalDate dataFiltro;
	private String filtroEscolhido;
	
	public OuvinteDeFinancas(Usuario usuario, ArrayList<Corrida> listaCorridas, LocalDate data, String opcao){
		email = usuario.getEmail();
		corridas = listaCorridas;
		dataFiltro = data;
		opcao = filtroEscolhido;
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Mensageiro mensageiro = new Mensageiro();
		mensageiro.enviarRelatorioFinancas(email);
		
		for(Corrida c: corridas) {
			switch(filtroEscolhido) {
			case "Recentes":
				
				break;
			case "Antigas":
				if (c.getData().isBefore(c.getData())) {
					
				}
			}
		}
		
	}

}
