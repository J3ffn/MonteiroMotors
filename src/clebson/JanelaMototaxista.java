package clebson;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import ListaDeAquecimento.CentralDeInformacoes;
import ListaDeAquecimento.Mototaxista;
import ListaDeAquecimento.Persistencia;
import ListaDeAquecimento.Usuario;
import eduardo.JanelaCorridasDisponiveis.JanelaDeChamadasDeCorridas;
import eduardo.JanelaCorridasDisponiveis.JanelaDeCorridasDisponiveis;
import eduardo.JanelaCorridasDisponiveis.PainelListaCorridasMototaxista;
import eduardo.Ouvintes.OuvinteBotaoListarCorridas;
import jefferson.telaDeAdicionarCreditos.telasParaAdicionar.TelaDeAdicionarCreditos;




@SuppressWarnings("serial")
public class JanelaMototaxista extends JanelaPadraoUsuario{
	
	private int qtddDeCretidos;
	private Mototaxista mototaxista;
	
	public JanelaMototaxista(Mototaxista mtx) {
		super("Mototaxista", mtx);
		qtddDeCretidos = mtx.getCreditos().size();
		
		adicionarTextosDeCredito();
		adicionarBotoesMototaxista(mtx);
//		adicionarCampoCreditos();
		
		setVisible(true);
	}
	
	private void adicionarTextosDeCredito() {
		JLabel lbCreditos = new JLabel("Créditos: ");		
		lbCreditos.setBounds(340, 10, 60, 20);
		lbCreditos.setFont(new Font("Arial",Font.BOLD,12));
		add(lbCreditos);
		
		ImageIcon moeda = new ImageIcon("icones/Coin (1).png");
		JLabel lbMoeda = new JLabel(qtddDeCretidos + "", moeda, JLabel.CENTER);
		lbMoeda.setBounds(370, 10, 100, 20);
		lbMoeda.setFont(new Font("Arial",Font.BOLD,12));
		add(lbMoeda);
		
	}
	
	
	private class OuvinteBotaoChamadas implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// Abrir Chamadas
			new JanelaDeChamadasDeCorridas(getUsuario());
		}
	}
		
		OuvinteBotaoListarCorridas ouvinteCorridas = new OuvinteBotaoListarCorridas(getUsuario());
	
	private void adicionarBotoesMototaxista(Mototaxista mtx) {
		super.adicionarBotoes();
		
		JButton btListarCorridas = new JButton();
		btListarCorridas.setBounds(170, 121, 130, 40);
		btListarCorridas.setText("Listar Corridas");
		btListarCorridas.setFont(new Font("Tahoma",Font.BOLD,10));
		btListarCorridas.addActionListener(ouvinteCorridas);
		add (btListarCorridas);
		
		
		JButton btChamadas = new JButton();
		btChamadas.setBounds(170, 181, 130, 60);
		btChamadas.setText("Chamadas para corridas");
		btChamadas.addActionListener(new OuvinteBotaoChamadas());
		btChamadas.setFont(new Font("Tahoma",Font.BOLD,8));
		add (btChamadas);
		
		
		ImageIcon icone = new ImageIcon("icones/+.png");
		JButton adicionarCredito = new JButton(icone);
		adicionarCredito.setFont(new Font("ARIAL", Font.BOLD, 12));
		adicionarCredito.setFocusable(false);
		adicionarCredito.setOpaque(true);
		adicionarCredito.setBorderPainted(false);
		adicionarCredito.setBounds(450, 10, 25, 20);
		
		adicionarCredito.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new TelaDeAdicionarCreditos(mtx, getCentral());
			}
		});
		
		add (adicionarCredito);
	}
	
}
