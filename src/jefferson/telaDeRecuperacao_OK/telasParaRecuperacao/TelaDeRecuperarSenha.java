package jefferson.telaDeRecuperacao_OK.telasParaRecuperacao;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.UUID;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import ListaDeAquecimento.Mensageiro;
import clebson.JanelaPadrao;

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
		JButton botaoEnviar = new JButton("ENVIAR CÓDIGO");
		botaoEnviar.setBounds(170, 270, 125, 40);
		botaoEnviar.addActionListener(new ActionListener() {
			
			private String gerarCodigo() {
				UUID geradorID = UUID.randomUUID();
				String codigoChave = String.valueOf(geradorID).substring(0, 7);
				return codigoChave;
			}
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String emailDestinatario = emailDigitado.getText();
				Mensageiro mensageiro = new Mensageiro();
				String codigoChave = gerarCodigo();
				
				// TODO Descomentar essas verificações.
//				if (new CentralDeInformacoes().recuperarUsuarioPeloEmail(emailDestinatario) != null) {
				
					System.out.println(emailDestinatario);
					if (mensageiro.verificarEmail(emailDestinatario)) {
						
						System.out.println(codigoChave);
						mensageiro.enviarCodigoDeRecuperacao(emailDestinatario, codigoChave, "Chave de recuperação");
						
						tela.dispose();
						new TelaVerificarCodigo(codigoChave, emailDigitado.getText());
						
					} else {JOptionPane.showMessageDialog(null, "Email inválido");}
				}
			
//				else {JOptionPane.showMessageDialog(null, "Usuário não encontrado");}
		});
		
		/*-----------------------------------------*/
		
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
		emailDigitado = new JTextField();
		emailDigitado.setBounds(115, 185, 250, 40);
		
		add(textoEmail);
		add(emailDigitado);
	}
	
}
