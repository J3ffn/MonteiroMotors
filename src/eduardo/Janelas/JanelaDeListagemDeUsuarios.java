package eduardo.Janelas;

import java.awt.Color;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import ListaDeAquecimento.Administrador;
import ListaDeAquecimento.CentralDeInformacoes;
import ListaDeAquecimento.Corrida;
import ListaDeAquecimento.Persistencia;
import clebson.JanelaPadrao;
import eduardo.JanelaCorridasDisponiveis.Painel;
import eduardo.Ouvintes.OuvinteBotaoCancelar;

public class JanelaDeListagemDeUsuarios extends JanelaPadrao {
	private ArrayList <Corrida> corridasTodasAsDisponiveis;
	private JScrollPane painel;
	private Painel painel1;
	private JComboBox < String > filtro;
	
	public JanelaDeListagemDeUsuarios(Administrador u) {
		super("Janela de Listagem de Usuarios", u);
		adicionarPainel();
		adicionarBotoes();
		this.setVisible(true);
	}
	public void adicionarBotoes() {
		String[] opcoes = {"Todas", "Mototaxistas", "Passageiros"};
		
		JLabel texto = new JLabel("Lista de Usuarios");
		texto.setBounds(20, 40, 440, 20);
		texto.setBackground(Color.GRAY);
		texto.setOpaque(true);
		texto.setHorizontalAlignment(JLabel.CENTER);
		this.add(texto);
		
		JButton b = new JButton("< Voltar");
		b.setBounds(5, 5, 80, 20);
		b.addActionListener(new OuvinteBotaoCancelar(this));
		this.add(b);
		
		
		filtro = new JComboBox < String >(opcoes);
		filtro.setBounds(350, 5, 110, 20);
		this.add(filtro);
		
	}
	public void adicionarPainel() {
		painel1 = new PainelListaUsuarios((Administrador) getUsuario());
		painel = new JScrollPane(painel1);
		
		painel.setBounds(20, 60, 440, 340);
		
		this.add(painel);
	}
	public JScrollPane getPainel() {
		return painel;
	}
}
