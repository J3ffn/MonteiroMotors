package eduardo.JanelaCorridasDisponiveis;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;

import ListaDeAquecimento.Corrida;
import ListaDeAquecimento.Mototaxista;
import ListaDeAquecimento.Passageiro;
import ListaDeAquecimento.Status;
import ListaDeAquecimento.Usuario;
import eduardo.Janelas.JanelaDeReividicacaoDeCorrida;

public class PainelReinvindicacao extends Painel {
	
	public PainelReinvindicacao(ArrayList<Corrida> corridasTodasAsDisponiveis, Usuario usuario) {
		super(corridasTodasAsDisponiveis, usuario);
	}

	public void preencherPainel() {
		this.setBackground(Color.WHITE);
		int y = 10;
		this.setLayout(null);
		this.repaint();
		
		
		if(getCorridasTodasAsDisponiveis() != null) {
			for (Corrida c : getCorridasTodasAsDisponiveis()) {
				Passageiro p = (Passageiro) c.getUsuario();
				if(c.getStatus() == Status.PENDENTE && !p.verificarSeEBloqueado((Mototaxista) this.getUsuario())) {
					JLabel corrida = new JLabel("Corrida: " + c.getId());
					corrida.setBounds(10, y, 170, 20);
					
					JButton botao = new JButton("Reivindicar");
					botao.setBounds(310, y, 115, 40);
					botao.addActionListener((ActionListener) new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							new JanelaDeReividicacaoDeCorrida(c, (Mototaxista) getUsuario());
						}
					});
					this.add(corrida);
					this.add(botao);
					y += 45;
				}
			}
			if(getCorridasTodasAsDisponiveis().size() > 6) {
				GridLayout layout = new GridLayout(0, 2, 150, 20);
				this.setLayout(layout);
			}
		}
	}
}
