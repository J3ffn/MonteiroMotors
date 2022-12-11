package eduardo.Ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ListaDeAquecimento.CentralDeInformacoes;
import ListaDeAquecimento.Persistencia;
import ListaDeAquecimento.Usuario;
import eduardo.JanelaCorridasDisponiveis.JanelaDeCorridasDisponiveis;

public class OuvinteBotaoListarCorridas implements ActionListener{
	private Usuario usuario;
	
	public OuvinteBotaoListarCorridas(Usuario u) {
		usuario = u;
	}
	public void actionPerformed(ActionEvent e) {
		JanelaDeCorridasDisponiveis janela = new JanelaDeCorridasDisponiveis(usuario);
	}
}
