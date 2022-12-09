package eduardo;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import ListaDeAquecimento.CentralDeInformacoes;
import ListaDeAquecimento.Mototaxista;
import clebson.JanelaPadrao;
import ListaDeAquecimento.Corrida;

public class JanelaDeCorridasDisponiveis extends JanelaPadrao{
	Mototaxista mototaxista;
	CentralDeInformacoes central;
	ArrayList <Corrida> corridasDisponiveis;
	
	public JanelaDeCorridasDisponiveis(Mototaxista m, CentralDeInformacoes c) {
		super("Janela de Corridas Disponiveis");
		mototaxista = m;
		central = c;
		corridasDisponiveis = central.recuperarCorridasNaoReivindicadas();
		adicionarPainel();
		this.setVisible(true);
	}
	public void adicionarPainel() {
		JButton b = new JButton("< Voltar");
		b.setBounds(5, 5, 80, 20);
		b.addActionListener(new OuvinteBotaoCancelar(this));
		this.add(b);
		
		JLabel texto = new JLabel("Corridas Disponiveis");
		texto.setBounds(20, 40, 440, 20);
		texto.setBackground(Color.GRAY);
		texto.setOpaque(true);
		texto.setHorizontalAlignment(JLabel.CENTER);
		this.add(texto);
		
		JPanel painel1 = new JPanel();
		painel1.setBackground(Color.WHITE);
		int y = 10;
		painel1.setLayout(null);
		
		if(corridasDisponiveis != null) {
			for (Corrida c : corridasDisponiveis) {
				JLabel corrida = new JLabel("Corrida: " + c.getId());
				corrida.setBounds(10, y, 170, 20);
				
				JButton botao = new JButton("Reivindicar");
				botao.setBounds(310, y, 115, 40);
				botao.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						new JanelaDeReividicacaoDeCorrida(central, c, mototaxista);
					}
				});
				painel1.add(corrida);
				painel1.add(botao);
				y += 45;
			}
		}
		if(corridasDisponiveis.size() > 6) {
			GridLayout layout = new GridLayout(0, 2, 150, 20);
			painel1.setLayout(layout);
		}
		JScrollPane painel = new JScrollPane(painel1);
		
		painel.setBounds(20, 60, 440, 340);
		
		this.add(painel);
	}
}
