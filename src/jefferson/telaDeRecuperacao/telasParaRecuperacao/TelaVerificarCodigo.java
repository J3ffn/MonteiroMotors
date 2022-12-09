package jefferson.telaDeRecuperacao.telasParaRecuperacao;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import jefferson.telaDeRecuperacao.OuvinteGestorDeInformacoes;

@SuppressWarnings("serial")
public final class TelaVerificarCodigo extends TelaDeRecuperarSenha implements OuvinteGestorDeInformacoes{

	private String codigoEnviado;
	private JButton botao;
	private JTextField infoEmail;
	
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
				botao.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						JTextField infoLinha = (JTextField) e.getSource();
						String codigoDigitado = infoLinha.getText();
						if (codigoDigitado.equals(codigoEnviado)) {
							dispose();
							new TelaDeAlteracaoDaSenha(infoEmail.getText());
						} else 
							JOptionPane.showMessageDialog(null, "Código incorreto!");
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
