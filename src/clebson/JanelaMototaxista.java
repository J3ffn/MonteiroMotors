package clebson;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import clebsonOuvintesExternos.OuvinteBotaoDeslogar;
import eduardo.Janelas.PainelListaCorridasMototaxista;



@SuppressWarnings("serial")
public class JanelaMototaxista extends JanelaPadrao{
	
	private JButton btDeslogar;
	private JButton btEditarPerfil;
	
	public JanelaMototaxista() {
		super("Mototaxista");
		adicionarTextos();
		adicionarBotoes();
		
		setVisible(true);
	}
	
	private void adicionarTextos() {
		JLabel lbCreditos = new JLabel("Créditos: ");		
		lbCreditos.setBounds(390, 10, 60, 20);
		lbCreditos.setFont(new Font("Arial",Font.BOLD,12));
		add(lbCreditos);
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
	
	private void adicionarBotoes() {
		JButton btListarCorridas = new JButton();
		btListarCorridas.setBounds(170, 121, 130, 40);
		btListarCorridas.setText("Listar Corridas");
		btListarCorridas.setFont(new Font("Tahoma",Font.BOLD,10));
		add (btListarCorridas);
		OuvinteBotaoListarCorridas ouvinteCorridas = new OuvinteBotaoListarCorridas();
		btListarCorridas.addActionListener(ouvinteCorridas);
		
		JButton btChamadas = new JButton();
		btChamadas.setBounds(170, 181, 130, 60);
		btChamadas.setText("Chamadas para corridas");
		btChamadas.setFont(new Font("Tahoma",Font.BOLD,8));
		add (btChamadas);
		
		btEditarPerfil  = new JButton();
		btEditarPerfil.setBounds(340, 320, 130, 35);
		btEditarPerfil.setText("Editar Perfil");
		btEditarPerfil.setFont(new Font("Tahoma",Font.BOLD,10));
		add (btEditarPerfil);		
		
		
		btDeslogar = new JButton();
		btDeslogar.setBounds(340, 370, 130, 35);
		btDeslogar.setText("Deslogar");
		btDeslogar.setFont(new Font("Tahoma",Font.BOLD,10));
		add (btDeslogar);
		OuvinteBotaoDeslogar ouvinteDeslogar = new OuvinteBotaoDeslogar(this);
		btDeslogar.addActionListener(ouvinteDeslogar);
		
		
		
		
	}
}
