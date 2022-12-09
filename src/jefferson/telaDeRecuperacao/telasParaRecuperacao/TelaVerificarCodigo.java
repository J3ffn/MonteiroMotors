package jefferson.telaDeRecuperacao.telasParaRecuperacao;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import jefferson.telaDeRecuperacao.OuvinteGestorDeInformacoes;
import jefferson.telaDeRecuperacao.ouvintesTelaRecuperacao.OuvinteCodigoChave;

@SuppressWarnings("serial")
public class TelaVerificarCodigo extends TelaDeRecuperarSenha implements OuvinteGestorDeInformacoes{

	@SuppressWarnings("unused")
	private String codigo;
	private JButton botao;
	private JFrame tela = this;
	private JTextField infoLinha;
	
	public TelaVerificarCodigo(String codigoChave) {
		codigo = codigoChave;
		
		addBotoesDaTela();
		addCampoEmail();
		
		setVisible(true);
	}
	
	@Override
	public void addBotoesDaTela() {
		botao = new JButton("CONFIRMAR");
		botao.setBounds(184, 270, 111, 40);
		
		add(botao);
	}
	
	@Override
	public void addCampoEmail() {
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
				botao.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						infoLinha = (JTextField) e.getSource();
						gestor(infoLinha.getText(), tela, infoLinha);
					}
					
				});
			}
			
			@Override
			public void focusGained(FocusEvent e) {}
		});
		
		add(texto);
		add(linhaValidacao);
	}

	@Override
	public void gestor(String texto, JFrame tela, JTextField campoEmail) {
		if (new OuvinteCodigoChave(tela, campoEmail).ValidarCodigo()) {
			
		} 
		
	}
	
	
	
}
