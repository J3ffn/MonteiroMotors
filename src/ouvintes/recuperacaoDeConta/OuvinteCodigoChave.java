package ouvintes.recuperacaoDeConta;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.UUID;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import janelas.janelasDeRecuperacao.JanelaVerificarCodigo;
import sistemas.GestãoDeInformacoes.CentralDeInformacoes;
import sistemas.GestãoDeInformacoes.Persistencia;
import sistemas.Manipuladores.Mensageiro;

public class OuvinteCodigoChave implements ActionListener {

	private JFrame tela;
	private JTextField emailDigitado;
	private CentralDeInformacoes central;

	public OuvinteCodigoChave(JFrame tela, JTextField emailDigitado) {
		this.tela = tela;
		this.emailDigitado = emailDigitado;
	}

	private String gerarCodigo() {
		UUID geradorID = UUID.randomUUID();
		String codigoChave = String.valueOf(geradorID).substring(0, 7);
		return codigoChave;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			central = (CentralDeInformacoes) new Persistencia().recuperar("dados-passageiros.xml");

			String emailDestinatario = emailDigitado.getText();
			Mensageiro mensageiro = new Mensageiro();
			String codigoChave = gerarCodigo();

			if (central.recuperarUsuarioPeloEmail(emailDestinatario) != null) {

				if (mensageiro.verificarEmail(emailDestinatario)) {

					mensageiro.enviarCodigoDeRecuperacao(emailDestinatario, codigoChave, "Chave de recuperação");

					tela.dispose();
					new JanelaVerificarCodigo(codigoChave, emailDigitado.getText());

				} else {
					JOptionPane.showMessageDialog(null, "Email inválido");
				}
			}

			else {
				JOptionPane.showMessageDialog(null, "Usuário não encontrado");
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}

	}

}
