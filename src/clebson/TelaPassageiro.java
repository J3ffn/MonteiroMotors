package clebson;

import java.awt.Font;

import javax.swing.JButton;

public class TelaPassageiro extends JanelaPadrao{
	
	
	public TelaPassageiro() {
		super("Passageiro");
		adicionarBotoes();
		
		setVisible(true);
	}
	
	private void adicionarBotoes() {
		JButton btCadastroCorrida = new JButton();
		btCadastroCorrida.setBounds(170, 121, 130, 50);
		btCadastroCorrida.setText("Cadastrar Corrida");
		btCadastroCorrida.setFont(new Font("Arial",Font.BOLD,10));
		add (btCadastroCorrida);
		
		JButton btListarCorridas = new JButton();
		btListarCorridas.setBounds(170, 191, 130, 30);
		btListarCorridas.setText("Listar Corridas");
		btListarCorridas.setFont(new Font("Arial",Font.BOLD,10));
		add (btListarCorridas);
		
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
