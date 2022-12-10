package eduardo.JanelaCorridasDisponiveis;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ListaDeAquecimento.CentralDeInformacoes;
import ListaDeAquecimento.Corrida;
import ListaDeAquecimento.Mototaxista;
import ListaDeAquecimento.Passageiro;
import ListaDeAquecimento.Persistencia;
import ListaDeAquecimento.Status;

public class PainelListaCorridasPassageiro extends Painel{
	
	public PainelListaCorridasPassageiro(ArrayList < Corrida > corridasTodasAsDisponiveis, CentralDeInformacoes central, Persistencia persistencia, Passageiro usuario) {
		super(corridasTodasAsDisponiveis, central, persistencia, usuario);
	}
	public void preencherPainel() {
		this.setBackground(Color.WHITE);
		this.setLayout(null);
		
		int y = 10;
		if(getCorridasTodasAsDisponiveis() != null) {
			for (Corrida c : getCorridasTodasAsDisponiveis()) {
				JLabel corrida = new JLabel("Corrida: " + c.getId() + "  " + c.getData());
				corrida.setBounds(10, y, 170, 20);
				JButton botao = new JButton("Detalhes");
				botao.setBounds(310, y, 115, 40);
				
				this.add(corrida);
				this.add(botao);
				y += 45;
			}
			if(getCorridasTodasAsDisponiveis().size() > 6) {
				GridLayout layout = new GridLayout(0, 2, 150, 20);
				this.setLayout(layout);
			}
		}
	}
}
