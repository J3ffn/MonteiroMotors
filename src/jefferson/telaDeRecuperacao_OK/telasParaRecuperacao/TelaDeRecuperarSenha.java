package jefferson.telaDeRecuperacao_OK.telasParaRecuperacao;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import clebson.JanelaPadrao;
import jefferson.telaDeLogin_OK.telas.TelaDeLogin;
import jefferson.telaDeRecuperacao_OK.ouvintes.OuvinteCodigoChave;

@SuppressWarnings("serial")
public class TelaDeRecuperarSenha extends JanelaPadrao {

	// Referência da tela -> 498, 462
	private JTextField emailDigitado;
	private TelaDeRecuperarSenha tela = this;

	public TelaDeRecuperarSenha() {
		super("Recuperação senha", null);

		addTituloDaTela();
		addCampoTextField();
		addBotoesDaTela();

		setVisible(true);
	}

	// Botões da tela:
	protected void addBotoesDaTela() {
		JButton botaoVoltar = new JButton("< voltar");
		botaoVoltar.setBounds(5, 5, 80, 20);
		botaoVoltar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new TelaDeLogin();
			}
		});

		JButton botaoEnviar = new JButton("ENVIAR CÓDIGO");
		botaoEnviar.setBounds(170, 270, 125, 40);
		botaoEnviar.addActionListener(new OuvinteCodigoChave(tela, emailDigitado));

		/*-----------------------------------------*/

		add(botaoVoltar);
		add(botaoEnviar);
	}

	protected void addTituloDaTela() {
		JLabel linhaTitulo = new JLabel("RECUPERAR CONTA");
		linhaTitulo.setBounds(150, 100, 190, 40);
		linhaTitulo.setFont(new Font("", Font.BOLD, 18));

		add(linhaTitulo);
	}

	protected void addCampoTextField() {
		// Texto E-MAIL
		JLabel textoEmail = new JLabel("E-MAIL: ");
		textoEmail.setBounds(115, 160, 45, 30);
		textoEmail.setFont(new Font("", Font.BOLD, 12));

		// Campo para digitar o email
		emailDigitado = new JTextField();
		emailDigitado.setBounds(115, 185, 250, 40);

		add(textoEmail);
		add(emailDigitado);
	}

}
