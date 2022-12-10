package eduardo.JanelaCorridasDisponiveis;

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
	private ArrayList <Corrida> corridasTodasAsDisponiveis;
	private JScrollPane painel;
	private Painel painel1;
	private JComboBox < String > cbFiltro;
	private Filtro filtro;
	
	public JanelaDeCorridasDisponiveis(Usuario u, CentralDeInformacoes c, Persistencia per) {
		super("Janela de Corridas Disponiveis");
		setUsuario(u);
		setCentral(c);
		setPersistencia(per);
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
		
		
		cbFiltro = new JComboBox < String >(opcoes);
		cbFiltro.setBounds(350, 5, 110, 20);
		this.add(cbFiltro);
		
		JButton btAtualizar = new JButton("Atualizar");
		btAtualizar.setBounds(90, 5, 100, 20);
		btAtualizar.addMouseListener(new OuvinteDoAtualizar(this));
		this.add(btAtualizar);
	}
	
	private class OuvinteDoAtualizar implements MouseListener{
		JanelaDeCorridasDisponiveis janela;
		
		public OuvinteDoAtualizar(JanelaDeCorridasDisponiveis j) {
			janela = j;
		}
		public void mouseClicked(MouseEvent e) {
			String sel = cbFiltro.getSelectedItem().toString().toUpperCase();
			String sel2 = sel.replace(' ', '_');
			filtro = Filtro.valueOf(sel2);
			
				if(getUsuario() instanceof Mototaxista) {
					corridasTodasAsDisponiveis = getCentral().recuperarCorridasPossiveisParaoMototaxista((Mototaxista)getUsuario());
				} else if (getUsuario() instanceof Administrador) {
					corridasTodasAsDisponiveis = getCentral().getCorridas();
				} else if (getUsuario() instanceof Passageiro) {
					corridasTodasAsDisponiveis = getCentral().recuperarCorridasDeUmPassageiro(getUsuario().getEmail());
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
		if(getUsuario() instanceof Mototaxista) {
			painel1 = new PainelListaCorridasMototaxista(corridasTodasAsDisponiveis, filtro, getCentral(), getPersistencia(), (Mototaxista) getUsuario());
		} else if (getUsuario() instanceof Administrador) {
			painel1 = new PainelListaCorridasAdministrador(corridasTodasAsDisponiveis, filtro, getCentral(), getPersistencia(), (Administrador) getUsuario());
		} else if(getUsuario() instanceof Passageiro) {
			painel1 = new PainelListaCorridasPassageiro(corridasTodasAsDisponiveis, getCentral(), getPersistencia(), (Passageiro) getUsuario());
		}
		painel = new JScrollPane(painel1);
		
		painel.setBounds(20, 60, 440, 340);
		
		this.add(painel);
	}
	public JScrollPane getPainel() {
		return painel;
	}
}
