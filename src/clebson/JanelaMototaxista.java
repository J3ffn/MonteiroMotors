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
import eduardo.Janelas.PainelListaCorridasMototaxista;

import eduardo.Ouvintes.OuvinteBotaoListarCorridas;




@SuppressWarnings("serial")
public class JanelaMototaxista extends JanelaPadraoUsuario{
	

	
	public JanelaMototaxista(CentralDeInformacoes central, Persistencia per, Mototaxista mototaxista) {
		super("Mototaxista");
		this.central = central;
		this.persistencia = per;
		this.usuario = mototaxista;
		adicionarTextos();
		adicionarBotoesMototaxista();
		
		setVisible(true);
	}
	
	private void adicionarTextos() {
		JLabel lbCreditos = new JLabel("Créditos: ");		
		lbCreditos.setBounds(390, 10, 60, 20);
		lbCreditos.setFont(new Font("Arial",Font.BOLD,12));
		add(lbCreditos);
		
		ImageIcon moeda = new ImageIcon("icones/Coin (1).png");
		JLabel lbMoeda = new JLabel("XXXXXX", moeda, JLabel.CENTER);
		lbMoeda.setBounds(370, 50, 100, 20);
		lbMoeda.setFont(new Font("Arial",Font.BOLD,12));
		add(lbMoeda);
		
	}
	
	public class OuvinteBotaoListarCorridas implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			//Abrir Lista de Corridas
		}
	}
	
	public class OuvinteBotaoChamadas implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// Abrir Chamadas
			
		}
	}
	
	private void adicionarBotoesMototaxista() {
		super.adicionarBotoes();
		
		JButton btListarCorridas = new JButton();
		btListarCorridas.setBounds(170, 121, 130, 40);
		btListarCorridas.setText("Listar Corridas");
		btListarCorridas.addActionListener(new OuvinteBotaoListarCorridas());
		btListarCorridas.setFont(new Font("Tahoma",Font.BOLD,10));
		add (btListarCorridas);
		OuvinteBotaoListarCorridas ouvinteCorridas = new OuvinteBotaoListarCorridas();
		btListarCorridas.addActionListener(ouvinteCorridas);
		
		JButton btChamadas = new JButton();
		btChamadas.setBounds(170, 181, 130, 60);
		btChamadas.setText("Chamadas para corridas");
		btChamadas.setFont(new Font("Tahoma",Font.BOLD,8));
		add (btChamadas);
		
		
	}
}
