package janelas.janelasDeRecuperacao;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import sistemas.janela.JanelaPadrao;

@SuppressWarnings("serial")
public final class JanelaVerificarCodigo extends JanelaPadrao {

	private String codigoEnviado;
	private String emailDigitado;
	private JTextField linhaValidacao;
	private JFrame tela = this;

	public JanelaVerificarCodigo(String codigoChave, String email) {
		super("Recuperação senha", null);
		codigoEnviado = codigoChave;
		emailDigitado = email;

		addTituloDaTela();
		addCampoTextField();
		addBotoesDaTela();

		setVisible(true);
	}

	private void addTituloDaTela() {
		JLabel linhaTitulo = new JLabel("RECUPERAR CONTA");
		linhaTitulo.setBounds(150, 100, 190, 40);
		linhaTitulo.setFont(new Font("", Font.BOLD, 18));
		linhaTitulo.setHorizontalTextPosition((int) CENTER_ALIGNMENT);

		add(linhaTitulo);
	}

	private void addBotoesDaTela() {
		JButton botaoConfirmar = new JButton("CONFIRMAR");
		botaoConfirmar.setBounds(184, 270, 111, 40);

		botaoConfirmar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String codigoDigitado = linhaValidacao.getText();

				if (codigoEnviado.equals(codigoDigitado)) {
					tela.dispose();
					new JanelaDeAlteracaoDaSenha(emailDigitado);

				} else {
					JOptionPane.showMessageDialog(null, "Código inválido");
				}
			}
		});

		add(botaoConfirmar);
	}

	private void addCampoTextField() {
		// Subtexto
		JLabel texto = new JLabel("Código: ");
		texto.setBounds(115, 160, 45, 30);
		texto.setFont(new Font("", Font.BOLD, 12));

		// Linha para digitar o código
		linhaValidacao = new JTextField();
		linhaValidacao.setBounds(115, 185, 250, 40);

		add(texto);
		add(linhaValidacao);
	}

}
