package jefferson.telaDeFinancas.telas;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import ListaDeAquecimento.Usuario;
import clebson.JanelaPadrao;

@SuppressWarnings("serial")
public class TelaFinancas extends JanelaPadrao{

	private Usuario usuario;
	
	public TelaFinancas(Usuario usuario) {
		super("Finanças", null);
		
		this.usuario = usuario;
		
		addTitulo();
		addBotoes();
		
		setVisible(true);
	}
	
	private void addTitulo() {
		JLabel titulo = new JLabel();
		titulo.setFont(new Font("", Font.BOLD, 20));
		titulo.setBounds(00, 100, 483, 30);
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setText("O email será enviado para:");
		
		JLabel tituloEmail = new JLabel(usuario.getEmail());
		tituloEmail.setBounds(0, 125, 483, 30);
		tituloEmail.setForeground(Color.red);
		tituloEmail.setHorizontalAlignment(SwingConstants.CENTER);
		tituloEmail.setFont(new Font("", Font.BOLD, 20));
		
		
		add(titulo);
		add(tituloEmail);
	}
	

	private void addBotoes() {
		JButton botao = new JButton("Enviar");
		botao.setBounds(185, 280, 100, 40);
		
		
		add(botao);
	}
}
