package eduardo;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import ListaDeAquecimento.CentralDeInformacoes;
import ListaDeAquecimento.ComparacaoData;
import ListaDeAquecimento.Mototaxista;
import ListaDeAquecimento.Persistencia;
import ListaDeAquecimento.Status;
import clebson.JanelaPadrao;
import ListaDeAquecimento.Corrida;

public class JanelaDeCorridasDisponiveis extends JanelaPadrao{
	Mototaxista mototaxista;
	CentralDeInformacoes central;
	ArrayList <Corrida> corridasTodasAsDisponiveis;
	JScrollPane painel;
	Persistencia persistencia;
	JPanel painel1;
	JComboBox < String > filtro;
	
	public JanelaDeCorridasDisponiveis(Mototaxista m, CentralDeInformacoes c, Persistencia per) {
		super("Janela de Corridas Disponiveis");
		mototaxista = m;
		central = c;
		persistencia = per;
		corridasTodasAsDisponiveis = central.recuperarCorridasPossiveisParaoMototaxista(mototaxista);
		adicionarPainel();
		adicionarBotoes();
		this.setVisible(true);
	}
	public void adicionarBotoes() {
		JButton b = new JButton("< Voltar");
		b.setBounds(5, 5, 80, 20);
		b.addActionListener(new OuvinteBotaoCancelar(this));
		this.add(b);
		
		String[] opcoes = {"Todas", "Mais Recentes"};
		
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
					comparacao = new ComparacaoData();
					corridasTodasAsDisponiveis.sort(comparacao);
					
				} else if(filtro.getSelectedItem().equals("Todas")) {
					corridasTodasAsDisponiveis = central.recuperarCorridasPossiveisParaoMototaxista(mototaxista);
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
		
		JLabel texto = new JLabel("Corridas Disponiveis");
		texto.setBounds(20, 40, 440, 20);
		texto.setBackground(Color.GRAY);
		texto.setOpaque(true);
		texto.setHorizontalAlignment(JLabel.CENTER);
		this.add(texto);
		
		painel1 = new JPanel();
		painel1.setBackground(Color.WHITE);
		int y = 10;
		painel1.setLayout(null);
		
		
		if(corridasTodasAsDisponiveis != null) {
			for (Corrida c : corridasTodasAsDisponiveis) {
				if(c.getStatus() == Status.PENDENTE) {
					JLabel corrida = new JLabel("Corrida: " + c.getId());
					corrida.setBounds(10, y, 170, 20);
					
					JButton botao = new JButton("Reivindicar");
					botao.setBounds(310, y, 115, 40);
					botao.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							new JanelaDeReividicacaoDeCorrida(central, persistencia, c, mototaxista);
						}
					});
					painel1.add(corrida);
					painel1.add(botao);
					y += 45;
				}
			}
		}
		if(corridasTodasAsDisponiveis.size() > 6) {
			GridLayout layout = new GridLayout(0, 2, 150, 20);
			painel1.setLayout(layout);
		}
		painel = new JScrollPane(painel1);
		
		painel.setBounds(20, 60, 440, 340);
		
		this.add(painel);
	}
	public JScrollPane getPainel() {
		return painel;
	}
}
