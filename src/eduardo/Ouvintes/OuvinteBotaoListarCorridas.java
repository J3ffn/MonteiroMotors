package eduardo.Ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ListaDeAquecimento.CentralDeInformacoes;
import ListaDeAquecimento.Persistencia;
import ListaDeAquecimento.Usuario;
import eduardo.JanelaCorridasDisponiveis.JanelaDeCorridasDisponiveis;

public class OuvinteBotaoListarCorridas implements ActionListener{
	private Usuario usuario;
	private CentralDeInformacoes central;
	private Persistencia persistencia;
	
	public OuvinteBotaoListarCorridas(Usuario u, CentralDeInformacoes c, Persistencia p) {
		usuario = u;
		central = c;
		persistencia = p;
	}
	public void actionPerformed(ActionEvent e) {
		JanelaDeCorridasDisponiveis janela = new JanelaDeCorridasDisponiveis(usuario);
	}
}
