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
import clebson.JanelaEditarPerfil;
import clebson.JanelaEditarPerfilAdmin;
import eduardo.JanelaCorridasDisponiveis.Painel;

public class PainelListaUsuarios extends Painel{
	ArrayList <Usuario> usuarios = getCentral().getTodosOsUsuarios();
	
	public PainelListaUsuarios(CentralDeInformacoes central,
			Persistencia persistencia, Administrador usuario) {
		super(null, central, persistencia, usuario);
		preencherPainel();
	}
	public void preencherPainel() {
		
		this.setBackground(Color.WHITE);
		int y = 10;
		this.setLayout(null);
		
		
		if(usuarios != null) {
			for (Usuario c : usuarios) {
					JLabel corrida = new JLabel("Usuario: " + c.getNome());
					corrida.setBounds(10, y, 170, 20);
					
					JButton botao = new JButton("Detalhes");
					botao.setBounds(310, y, 115, 40);
					botao.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							new JanelaEditarPerfilAdmin();
						}
					});
					this.add(corrida);
					this.add(botao);
					y += 45;
			}
			if(usuarios.size() > 6) {
				GridLayout layout = new GridLayout(0, 2, 150, 20);
				this.setLayout(layout);
			}
		}
	}
}
