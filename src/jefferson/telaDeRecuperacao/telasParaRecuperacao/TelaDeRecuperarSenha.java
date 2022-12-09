package jefferson.telaDeRecuperacao.telasParaRecuperacao;

import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import ListaDeAquecimento.Mensageiro;
import clebson.JanelaPadrao;
import jefferson.telaDeRecuperacao.OuvinteGestorDeInformacoes;
import jefferson.telaDeRecuperacao.ouvintesTelaRecuperacao.*;

@SuppressWarnings("serial")
public class TelaDeRecuperarSenha extends JanelaPadrao implements OuvinteGestorDeInformacoes{
	
	// Referência da tela -> 498, 462
	private JButton botaoEnviar;
	private JFrame telaEmail = this;
	private JTextField emailDigitado;
	
	public TelaDeRecuperarSenha() {
		super("Recuperação senha");
		addTituloDaTela();
		addCampoEmail();
		addBotoesDaTela();
		
		setVisible(true);
	}

	// Botões da tela:
	protected void addBotoesDaTela() {
		botaoEnviar = new JButton("ENVIAR CÓDIGO");

		/*
		 * TODO Adicionar um Ouvinte para animar o botão. -> enviar.addMouseListener(new
		 * OuvinteMouse());
		 */

		botaoEnviar.setBounds(184, 270, 111, 40);
		
		add(botaoEnviar);
	}

	protected void addTituloDaTela() {
		JLabel titulo = new JLabel("RECUPERAR CONTA");
		titulo.setBounds(150, 100, 190, 40);
		titulo.setFont(new Font("", Font.BOLD, 18));
		titulo.setHorizontalTextPosition((int) CENTER_ALIGNMENT);

		add(titulo);
	}

	protected void addCampoEmail() {
		// Texto E-MAIL
		JLabel textoEmail = new JLabel("E-MAIL: ");
		textoEmail.setBounds(115, 160, 45, 30);
		textoEmail.setFont(new Font("", Font.BOLD, 12));

		// Campo para digitar o email
		JTextField linhaEmail = new JTextField();
		linhaEmail.setBounds(115, 185, 250, 40);

		linhaEmail.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				emailDigitado = (JTextField) e.getSource();
				
				gestor(emailDigitado.getText(), telaEmail, emailDigitado);
			}
			
			@Override
			public void focusGained(FocusEvent e) {

			}
		});

		add(textoEmail);
		add(linhaEmail);
	}
	
	@Override
	public void gestor(String texto, JFrame tela, JTextField campoEmail) {
		if (new Mensageiro().verificarEmail(texto)) {
			botaoEnviar.addMouseListener(new OuvinteBotao(botaoEnviar, telaEmail, campoEmail));
		}
		
	}

}
