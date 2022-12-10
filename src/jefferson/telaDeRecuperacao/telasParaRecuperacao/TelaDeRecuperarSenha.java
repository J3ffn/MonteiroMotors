package jefferson.telaDeRecuperacao.telasParaRecuperacao;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import ListaDeAquecimento.Mensageiro;
import clebson.JanelaPadrao;
import jefferson.telaDeRecuperacao.ouvintesTelaRecuperacao.OuvinteCodigoChave;

@SuppressWarnings("serial")
public class TelaDeRecuperarSenha extends JanelaPadrao {
	
	// Referência da tela -> 498, 462
	private JButton botaoEnviar;
	private JFrame tela = this;
	private JTextField emailDigitado;
	
	public TelaDeRecuperarSenha() {
		super("Recuperação senha");
		addTituloDaTela();
		addCampoTextField();
		addBotoesDaTela();
		
		setVisible(true);
	}

	// Botões da tela:
	protected void addBotoesDaTela() {
		botaoEnviar = new JButton("ENVIAR CÓDIGO");

		botaoEnviar.setBounds(170, 270, 125, 40);
		
		botaoEnviar.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if (emailDigitado.getText() != null) {
					botaoEnviar.addActionListener(new OuvinteCodigoChave(tela, emailDigitado, botaoEnviar));
				}
			}
		});
		
		add(botaoEnviar);
	}

	protected void addTituloDaTela() {
		JLabel linhaTitulo = new JLabel("RECUPERAR CONTA");
		linhaTitulo.setBounds(150, 100, 190, 40);
		linhaTitulo.setFont(new Font("", Font.BOLD, 18));
		linhaTitulo.setHorizontalTextPosition((int) CENTER_ALIGNMENT);

		add(linhaTitulo);
	}

	protected void addCampoTextField() {
		// Texto E-MAIL
		JLabel textoEmail = new JLabel("E-MAIL: ");
		textoEmail.setBounds(115, 160, 45, 30);
		textoEmail.setFont(new Font("", Font.BOLD, 12));

		// Campo para digitar o email
		JTextField linhaEmail = new JTextField();
		linhaEmail.setBounds(115, 185, 250, 40);

		add(textoEmail);
		add(linhaEmail);
	}
	
}
