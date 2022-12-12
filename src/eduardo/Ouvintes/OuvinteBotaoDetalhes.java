package eduardo.Ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;

import ListaDeAquecimento.CentralDeInformacoes;
import ListaDeAquecimento.Corrida;
import ListaDeAquecimento.Usuario;
import eduardo.JanelaCorridasDisponiveis.JanelaDeDetalhesDeUmaCorrida;

public class OuvinteBotaoDetalhes implements ActionListener{
	
	private JFrame telaAtual = new JFrame();
	private Corrida corrida;
	private Usuario usuario;
	
	public OuvinteBotaoDetalhes(ArrayList<Corrida> corridas, int indiceCorrida, Usuario usuario) {
		corrida = corridas.get(indiceCorrida);
		this.usuario = usuario;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		telaAtual.dispose();
		new JanelaDeDetalhesDeUmaCorrida(corrida, usuario, 1);
		
	}

	
}
