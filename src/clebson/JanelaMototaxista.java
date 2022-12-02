package clebson;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;



public class JanelaMototaxista extends JanelaPadrao{
	
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
		
//		ImageIcon icone = new ImageIcon("download.png");
//		JLabel lbquantidadeCreditos = new JLabel(x, icone, null);
//		lbquantidadeCreditos.setBounds(390, 30, 60, 20);
//		lbquantidadeCreditos.setFont(new Font("Arial",Font.BOLD,12));
		
	}
	
	private void adicionarBotoes() {
		JButton btListarCorridas = new JButton();
		btListarCorridas.setBounds(170, 121, 130, 40);
		btListarCorridas.setText("Listar Corridas");
		btListarCorridas.setFont(new Font("Arial",Font.BOLD,12));
		add (btListarCorridas);
		
		JButton btChamadas = new JButton();
		btChamadas.setBounds(170, 181, 130, 60);
		btChamadas.setText("Chamadas para corridas");
		btChamadas.setFont(new Font("Arial",Font.BOLD,12));
		add (btChamadas);
		
		JButton btEditarPerfil = new JButton();
		btEditarPerfil.setBounds(340, 320, 130, 35);
		btEditarPerfil.setText("Editar Perfil");
		btEditarPerfil.setFont(new Font("Arial",Font.BOLD,10));
		add (btEditarPerfil);
		
		JButton btDeslogar = new JButton();
		btDeslogar.setBounds(340, 370, 130, 35);
		btDeslogar.setText("Deslogar");
		btDeslogar.setFont(new Font("Arial",Font.BOLD,10));
		add (btDeslogar);
		
		
		
		
	}
}
