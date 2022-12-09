package jefferson.telasDeRecuperacao;

import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import clebson.JanelaPadrao;

@SuppressWarnings("serial")
public class TelaVerificarCodigo extends TelaDeRecuperarSenha {

	@SuppressWarnings("unused")
	private String codigo;
	
	public TelaVerificarCodigo(String codigoChave) {
		codigo = codigoChave;
		
		this.addTituloDaTela();
		this.addBotoesDaTela();
		this.addLinhaDeVerificacao();
		
		setVisible(true);
	}
	
	@Override
	public void addBotoesDaTela() {
		JButton botao = new JButton("CONFIRMAR");
		botao.setBounds(184, 270, 111, 40);
		
		add(botao);
	}
	
	public void addLinhaDeVerificacao() {
		JLabel texto = new JLabel("Código");
		texto.setBounds(115, 160, 45, 30);
		texto.setFont(new Font("", Font.BOLD, 12));
		
		JTextField linhaValidacao = new JTextField();
		linhaValidacao.setBounds(115, 185, 250, 40);
		
		
		add(texto);
		add(linhaValidacao);
	}
	
}
