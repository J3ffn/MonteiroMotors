package ouvintes.listagemDeCorridas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import janelas.janelasDeCorridas.JanelaDeCorridasDisponiveis;
import sistemas.Usuários.Usuario;

public class OuvinteBotaoListarCorridas implements ActionListener {
	private Usuario usuario;
	private JFrame telaAtual;
	
	public OuvinteBotaoListarCorridas(Usuario u, JFrame tela) {
		usuario = u;
		telaAtual = tela;
	}

	public void actionPerformed(ActionEvent e) {
		telaAtual.dispose();
		new JanelaDeCorridasDisponiveis(usuario);
	}
}
