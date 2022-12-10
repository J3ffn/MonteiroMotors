package jefferson.telaDeRecuperacao.telasParaRecuperacao;

import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import jefferson.telaDeRecuperacao.ouvintesTelaRecuperacao.OuvinteVerificacao;

@SuppressWarnings("serial")
public /*final*/ class TelaVerificarCodigo extends TelaDeRecuperarSenha {

	private String codigoEnviado;
	private JButton botao;
	private JTextField infoEmail;
	private JFrame tela = this;
	
	public TelaVerificarCodigo(String codigoChave, JTextField linhaEmail) {
		codigoEnviado = codigoChave;
		infoEmail = linhaEmail;
		
		addBotoesDaTela();
		addCampoTextField();
		
		setVisible(true);
	}
	
	@Override
	public void addBotoesDaTela() {
		botao = new JButton("CONFIRMAR");
		botao.setBounds(184, 270, 111, 40);
		botao.addActionListener(null);
		
		add(botao);
	}
	
	@Override
	public void addCampoTextField() {
		// Subtexto
		JLabel texto = new JLabel("Código: ");
		texto.setBounds(115, 160, 45, 30);
		texto.setFont(new Font("", Font.BOLD, 12));
		
		// Linha para digitar o código
		JTextField linhaValidacao = new JTextField();
		linhaValidacao.setBounds(115, 185, 250, 40);
		linhaValidacao.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				botao.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						botao.addActionListener(new OuvinteVerificacao(tela, linhaValidacao, codigoEnviado, infoEmail.getText()));
					}
				});
				
			}
			@Override
			public void focusGained(FocusEvent e) {}
		});
		
		add(texto);
		add(linhaValidacao);
	}

	
}
