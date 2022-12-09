package eduardo.Janelas;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import ListaDeAquecimento.Administrador;
import ListaDeAquecimento.CentralDeInformacoes;
import ListaDeAquecimento.ComparacaoData;
import ListaDeAquecimento.Mototaxista;
import ListaDeAquecimento.Passageiro;
import ListaDeAquecimento.Persistencia;
import ListaDeAquecimento.Usuario;
import clebson.JanelaPadrao;
import eduardo.Ouvintes.OuvinteBotaoCancelar;
import ListaDeAquecimento.Corrida;

public class JanelaDeCorridasDisponiveis extends JanelaPadrao{
	Usuario usuario;
	CentralDeInformacoes central;
	ArrayList <Corrida> corridasTodasAsDisponiveis;
	JScrollPane painel;
	Painel painel1;
	Persistencia persistencia;
	JComboBox < String > filtro;
	
	public JanelaDeCorridasDisponiveis(Usuario u, CentralDeInformacoes c, Persistencia per) {
		super("Janela de Corridas Disponiveis");
		usuario = u;
		central = c;
		persistencia = per;
		adicionarPainel();
		adicionarBotoes();
		this.setVisible(true);
	}
	public void adicionarBotoes() {
		String[] opcoes = {"Todas", "Mais Recentes", "Mais Antigas"};
		
		JLabel texto = new JLabel("Corridas Disponiveis");
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
		
		JButton btAtualizar = new JButton("Atualizar");
		btAtualizar.setBounds(90, 5, 100, 20);
		btAtualizar.addMouseListener(new OuvinteDoAtualizar(this));
		this.add(btAtualizar);
	}
	private class OuvinteDoAtualizar implements MouseListener{
		JanelaDeCorridasDisponiveis janela;
		private ComparacaoData comparacao;
		
		public OuvinteDoAtualizar(JanelaDeCorridasDisponiveis j) {
			janela = j;
		}
			@Override
			public void mouseClicked(MouseEvent e) {
				if(filtro.getSelectedItem().equals("Mais Recentes")) {
					corridasTodasAsDisponiveis = painel1.getCorridasOrganizadasMaisRecentes();
				} else if(filtro.getSelectedItem().equals("Todas")) {
					if(usuario instanceof Mototaxista) {
						corridasTodasAsDisponiveis = central.recuperarCorridasPossiveisParaoMototaxista((Mototaxista)usuario);
					} else if (usuario instanceof Administrador) {
						corridasTodasAsDisponiveis = central.getCorridas();
					}
				}
				JButton botao = (JButton) e.getSource();
				botao.transferFocus();
				janela.remove(painel);
				adicionarPainel();
				janela.repaint();
			}
			@Override
			public void mousePressed(MouseEvent e) {}
			@Override
			public void mouseReleased(MouseEvent e) {}
			@Override
			public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseExited(MouseEvent e) {}
	}
	public void adicionarPainel() {
		if(usuario instanceof Mototaxista) {
			painel1 = new PainelListaCorridasMototaxista(corridasTodasAsDisponiveis, central, persistencia, (Mototaxista) usuario);
		} else if (usuario instanceof Administrador) {
			painel1 = new PainelListaCorridasAdministrador(corridasTodasAsDisponiveis, central, persistencia, (Administrador) usuario);
		} else if(usuario instanceof Passageiro) {
			painel1 = new PainelListaCorridasPassageiro(corridasTodasAsDisponiveis, central, persistencia, (Passageiro) usuario);
		}
		painel = new JScrollPane(painel1);
		
		painel.setBounds(20, 60, 440, 340);
		
		this.add(painel);
	}
	public JScrollPane getPainel() {
		return painel;
	}
}
