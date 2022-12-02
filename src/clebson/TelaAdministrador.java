package clebson;

import java.awt.Font;

import javax.swing.JButton;

public class TelaAdministrador extends JanelaPadrao {
	
	public TelaAdministrador() {
		super("Administrador");
		adicionarBotoes();
		
		setVisible(true);
	}

	private void adicionarBotoes() {
		JButton btListarUsuarios = new JButton();
		btListarUsuarios.setBounds(70, 121, 130, 40);
		btListarUsuarios.setText("Listar Usuarios");
		btListarUsuarios.setFont(new Font("Arial",Font.BOLD,10));
		add (btListarUsuarios);
		
		JButton btListarCorridas = new JButton();
		btListarCorridas.setBounds(280, 121, 130, 40);
		btListarCorridas.setText("Listar Corridas");
		btListarCorridas.setFont(new Font("Arial",Font.BOLD,10));
		add (btListarCorridas);
		
		JButton btFinancas = new JButton();
		btFinancas.setBounds(70, 191, 130, 40);
		btFinancas.setText("Finanças");
		btFinancas.setFont(new Font("Arial",Font.BOLD,10));
		add (btFinancas);
		
		JButton btDefinirValor = new JButton();
		btDefinirValor.setBounds(280, 191, 130, 40);
		btDefinirValor.setText("Definir Valor");
		btDefinirValor.setFont(new Font("Arial",Font.BOLD,10));
		add (btDefinirValor);
		
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
