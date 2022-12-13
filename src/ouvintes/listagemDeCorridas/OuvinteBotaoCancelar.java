package ouvintes.listagemDeCorridas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import janelas.janelasCentrais.JanelaAdministrador;
import janelas.janelasCentrais.JanelaMototaxista;
import janelas.janelasCentrais.JanelaPassageiro;
import sistemas.Usuários.Administrador;
import sistemas.Usuários.Mototaxista;
import sistemas.Usuários.Passageiro;
import sistemas.Usuários.Usuario;

public class OuvinteBotaoCancelar implements ActionListener {
	private JFrame telaAnterior;
	private JFrame telaAtual;

	public OuvinteBotaoCancelar(JFrame telaAnterior, JFrame telaAtual) {
		this.telaAnterior = telaAnterior;
		this.telaAtual = telaAtual;
	}

	public void actionPerformed(ActionEvent e) {
		telaAtual.dispose();
		telaAnterior.setVisible(true);
	}
}
