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


@SuppressWarnings("serial")
public /*final*/ class TelaVerificarCodigo extends TelaDeRecuperarSenha {

	private String codigoEnviado;
	private JTextField emailDigitado;
	private JTextField linhaValidacao;
	private JFrame tela = this;
	
	public TelaVerificarCodigo(String codigoChave, JTextField email) {
		codigoEnviado = codigoChave;
		emailDigitado = email;
		
		addCampoTextField();
		addBotoesDaTela();
		
		setVisible(true);
	}
	
	@Override
	public void addBotoesDaTela() {
		JButton botao = new JButton("CONFIRMAR");
		botao.setBounds(184, 270, 111, 40);
		
		botao.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String codigoDigitado = linhaValidacao.getText();
				
				System.out.println("Codigo digitado: " + codigoDigitado);
				System.out.println("Codido enviado: " + codigoEnviado);
				
				if (codigoEnviado.equals(codigoDigitado)) {
					tela.dispose();
					new TelaDeAlteracaoDaSenha(emailDigitado.getText());
					
				} else {
					JOptionPane.showMessageDialog(null, "Código inválido");
				}
				
			}
		});
		
		add(botao);
	}
	
	@Override
	public void addCampoTextField() {
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
