package eduardo;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JTextField;


import clebson.JanelaPadrao;

public class JanelaDeCadastroDeCorrida extends JanelaPadrao{
	JTextField inputEnderecoPartida;
	JTextField inputEnderecoDestino;
	JFormattedTextField inputDistancia;
	
	public JanelaDeCadastroDeCorrida() {
		super("Cadastrar Solicitação de Corrida");
		this.adicionarBotoes();
		this.adicionarTextos();
		this.setVisible(true);
	}
	public void adicionarBotoes() {
		JButton botaoConfirmar = new JButton("Confirmar");
		botaoConfirmar.setBounds(360, 370, 100, 30);
		
		this.add(botaoConfirmar);
	}
	public void adicionarTextos() {
		JLabel txTitulo = new JLabel("Cadastrar Solicitação de Corrida");
		txTitulo.setBounds(90, 20, 400, 30);
		Font i = new Font ("Arial", Font.BOLD, 20);
		txTitulo.setFont(i);
		
		JLabel txEnderecoPartida = new JLabel("Endereço de Partida:");
		txEnderecoPartida.setBounds(30, 60, 134, 20);
		inputEnderecoPartida = new JTextField();
		inputEnderecoPartida.setBounds(30, 80, 428, 30);
		
		
		JLabel txEnderecoDestino = new JLabel("Endereço de Destino:");
		txEnderecoDestino.setBounds(30, 115, 134, 20);
		inputEnderecoDestino = new JTextField();
		inputEnderecoDestino.setBounds(30, 140, 428, 30);
		
		JLabel txDistancia = new JLabel("Distancia (Km):");
		txDistancia.setBounds(30, 170, 134, 20);
		inputDistancia = new JFormattedTextField();
		inputDistancia.addKeyListener(new OuvinteDoTecladoParaApenasNumerico());
		
		inputDistancia.setBounds(30, 190, 70, 30);
		
		this.add(txTitulo);
		this.add(txDistancia);
		this.add(txEnderecoDestino);
		this.add(txEnderecoPartida);
		this.add(inputDistancia);
		this.add(inputEnderecoDestino);
		this.add(inputEnderecoPartida);
	}
}
