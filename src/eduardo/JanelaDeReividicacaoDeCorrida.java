package eduardo;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


import ListaDeAquecimento.Corrida;

public class JanelaDeReividicacaoDeCorrida extends JFrame{
	JButton btConfirmar;
	JButton btCancelar;
	Corrida corrida;
	
	public JanelaDeReividicacaoDeCorrida(Corrida c) {
		this.setTitle("Reividicar Corrida");
		this.setSize(400, 177);
		setResizable(false);
		setLocationRelativeTo(null);				
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		corrida = c;
		this.adicionarLabels();
		this.adicionarBotoes();
		this.setVisible(true);
	}
	public void adicionarBotoes() {
		btConfirmar = new JButton("Confirmar");
		btConfirmar.setBounds(207, 103, 111, 30);
		this.add(btConfirmar);
		
		btCancelar = new JButton("Cancelar");
		btCancelar.setBounds(91, 103, 111, 30);
		this.add(btCancelar);
	}
	public void adicionarLabels() {
		JLabel txPassageiro = new JLabel("Passageiro: " + corrida.getUsuario().toString());
		txPassageiro.setBounds(100, 10, 200, 30);
		txPassageiro.setFont(new Font("Arial", Font.BOLD, 15));
		txPassageiro.setHorizontalAlignment(JLabel.CENTER);
		this.add(txPassageiro);
		
		JLabel txLocaldePartida = new JLabel(String.format("Local de Partida: %s", corrida.getEnderecoDePartida()));
		txLocaldePartida.setBounds(65, 40, 360, 20);
		this.add(txLocaldePartida);
		
		JLabel txLocaldeDestino = new JLabel(String.format("Local de Destino: %s", corrida.getEnderecoDeDestino()));
		txLocaldeDestino.setBounds(65, 60, 360, 20);
		this.add(txLocaldeDestino);
		
		JLabel txDistancia = new JLabel(String.format("Distancia: %,.2f km", corrida.getDistancia()));
		txDistancia.setBounds(65, 80, 120, 20);
		this.add(txDistancia);
		
		JLabel txData = new JLabel(String.format("Data: %s/%s/%s", corrida.getData().getDayOfMonth(), corrida.getData().getMonthValue(), corrida.getData().getYear()));
		txData.setBounds(240, 80, 120, 20);
		this.add(txData);
	}
}
