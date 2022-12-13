package ouvintes.botaoVoltar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

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
