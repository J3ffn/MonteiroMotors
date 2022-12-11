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
import eduardo.JanelaCorridasDisponiveis.JanelaDeCorridasDisponiveis;
import eduardo.JanelaCorridasDisponiveis.PainelListaCorridasMototaxista;
import eduardo.Ouvintes.OuvinteBotaoListarCorridas;




@SuppressWarnings("serial")
public class JanelaMototaxista extends JanelaPadraoUsuario{
	

	
	public JanelaMototaxista(Mototaxista mtx) {
		super("Mototaxista", mtx);
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
	

	
	public class OuvinteBotaoChamadas implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// Abrir Chamadas
			JanelaDeCorridasDisponiveis janela = new JanelaDeCorridasDisponiveis(getUsuario());
		}
	}
		
		OuvinteBotaoListarCorridas ouvinteCorridas = new OuvinteBotaoListarCorridas(getUsuario(), getCentral(), getPersistencia());
	
	private void adicionarBotoesMototaxista() {
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
		
		
	}
}
