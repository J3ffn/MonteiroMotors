package ouvintes.listagemDeCorridas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;

import janelas.janelasDeCorridas.JanelaDeDetalhesDeUmaCorrida;
import sistemas.Corridas.Corrida;
import sistemas.Usuários.Usuario;

public class OuvinteBotaoDetalhes implements ActionListener {

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
