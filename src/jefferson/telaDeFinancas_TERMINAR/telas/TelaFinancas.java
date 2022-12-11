package jefferson.telaDeFinancas_TERMINAR.telas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import ListaDeAquecimento.CentralDeInformacoes;
import ListaDeAquecimento.Mensageiro;
import ListaDeAquecimento.Persistencia;
import clebson.JanelaPadrao;
import jefferson.telaDeFinancas_TERMINAR.ouvintes.OuvinteDeFinancas;

@SuppressWarnings("serial")
public class TelaFinancas extends JanelaPadrao{

	private String email;
	private CentralDeInformacoes central;
	
	public TelaFinancas(String email) {
		super("Finanças", null);
		this.email = email;
		adicionarCentral();
		
		addTitulo();
		addBotoes();
		
		setVisible(true);
	}
	
	private void adicionarCentral() {
		try {
			central = (CentralDeInformacoes) new Persistencia().recuperar("dados-passageiros.xml");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void addTitulo() {
		JLabel titulo = new JLabel();
		titulo.setFont(new Font("", Font.BOLD, 20));
		titulo.setBounds(00, 100, 483, 30);
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setText("O email será enviado para:");
		
		JLabel tituloEmail = new JLabel(email);
		tituloEmail.setBounds(0, 125, 483, 30);
		tituloEmail.setForeground(Color.red);
		tituloEmail.setHorizontalAlignment(SwingConstants.CENTER);
		tituloEmail.setFont(new Font("", Font.BOLD, 20));
		
		JLabel informacao = new JLabel();
		informacao.setBounds(0, 155, 483, 30);
		informacao.setHorizontalAlignment(SwingConstants.CENTER);
		informacao.setText("Este é um relatório de finanças, será enviado para o email a cima");
		
		add(titulo);
		add(tituloEmail);
		add(informacao);
	}
	
	private void addBotoes() {
		JButton botaoVoltar = new JButton("< voltar");
		botaoVoltar.setBounds(5, 5, 80, 20);
		
		
		JButton botaoEnviar = new JButton("Enviar");
		botaoEnviar.setBounds(180, 280, 120, 40);
		botaoEnviar.addActionListener(new OuvinteDeFinancas(central.recuperarUsuarioPeloEmail(email)));
		
		add(botaoVoltar);
		add(botaoEnviar);
	}
}
