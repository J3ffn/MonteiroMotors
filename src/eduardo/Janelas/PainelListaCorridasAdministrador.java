package eduardo.Janelas;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ListaDeAquecimento.Administrador;
import ListaDeAquecimento.CentralDeInformacoes;
import ListaDeAquecimento.Corrida;
import ListaDeAquecimento.Mototaxista;
import ListaDeAquecimento.Persistencia;
import ListaDeAquecimento.Status;
import ListaDeAquecimento.Usuario;

public class PainelListaCorridasAdministrador extends Painel{

	public PainelListaCorridasAdministrador(ArrayList<Corrida> corridasTodasAsDisponiveis, CentralDeInformacoes central,
			Persistencia persistencia, Administrador usuario) {
		super(corridasTodasAsDisponiveis, central, persistencia, usuario);
	}
	public void preencherPainel() {
		corridasTodasAsDisponiveis = central.getCorridas();
		
		this.setBackground(Color.WHITE);
		int y = 10;
		this.setLayout(null);
		
		
		if(corridasTodasAsDisponiveis != null) {
			for (Corrida c : corridasTodasAsDisponiveis) {
					JLabel corrida = new JLabel("Corrida: " + c.getId());
					corrida.setBounds(10, y, 170, 20);
					
					JButton botao = new JButton("Detalhes");
					botao.setBounds(310, y, 115, 40);
					this.add(corrida);
					this.add(botao);
					y += 45;
			}
			if(corridasTodasAsDisponiveis.size() > 6) {
				GridLayout layout = new GridLayout(0, 2, 150, 20);
				this.setLayout(layout);
			}
		}
	}
}