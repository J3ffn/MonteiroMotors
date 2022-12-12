package janelas.janelasDeRecuperacao;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import ouvintes.recuperacaoDeConta.OuvinteBotaoConfirmar;
import sistemas.GestãoDeInformacoes.CentralDeInformacoes;
import sistemas.GestãoDeInformacoes.Persistencia;
import sistemas.Usuários.Usuario;
import sistemas.janela.JanelaPadrao;

@SuppressWarnings("serial")
public final class JanelaDeAlteracaoDaSenha extends JanelaPadrao {

	private Usuario usuarioParaAlteracao;
	private CentralDeInformacoes central;
	private JFrame tela = this;
	private JPasswordField linhaPassword;
	private JPasswordField linhaConfirmarPassword;

	public JanelaDeAlteracaoDaSenha(String email) {
		super("Recuperar senha", null);
		recuperarCentral();
		usuarioParaAlteracao = central.recuperarUsuarioPeloEmail(email);

		addTituloDaTela();
		addCampoTextField();
		addBotoesDaTela();
		setVisible(true);
	}

	private void recuperarCentral() {
		try {
			central = (CentralDeInformacoes) new Persistencia().recuperar("src/arquivos/dados-passageiros.xml");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro na recuperação");
		}
	}

	private void addTituloDaTela() {
		JLabel linhaTitulo = new JLabel("ALTERE SUA SENHA");
		linhaTitulo.setFont(new Font("", Font.BOLD, 18));
		linhaTitulo.setBounds(150, 100, 190, 40);

		add(linhaTitulo);
	}

	private void addCampoTextField() {
		// Campo password
		JLabel subTextoSenha = new JLabel("Password: ");
		subTextoSenha.setBounds(115, 140, 80, 30);
		subTextoSenha.setFont(new Font("", Font.BOLD, 12));

		linhaPassword = new JPasswordField();
		linhaPassword.setBounds(115, 165, 250, 40);

		// Campo confirmar password
		JLabel subTextoConfirmarSenha = new JLabel("Confirmar password: ");
		subTextoConfirmarSenha.setBounds(115, 201, 130, 30);
		subTextoConfirmarSenha.setFont(new Font("", Font.BOLD, 12));

		linhaConfirmarPassword = new JPasswordField();
		linhaConfirmarPassword.setBounds(115, 225, 250, 40);

		add(subTextoSenha);
		add(linhaPassword);

		add(subTextoConfirmarSenha);
		add(linhaConfirmarPassword);
	}

	private void addBotoesDaTela() {
		JButton botaoConfirmar = new JButton("Alterar senha");
		botaoConfirmar.setBounds(170, 270, 125, 40);

		botaoConfirmar.addActionListener(
				new OuvinteBotaoConfirmar(this, linhaPassword, linhaConfirmarPassword, central, usuarioParaAlteracao));

		add(botaoConfirmar);
	}

}
