package clebson;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import ListaDeAquecimento.Administrador;
import ListaDeAquecimento.CentralDeInformacoes;
import ListaDeAquecimento.Persistencia;
import clebsonOuvintesExternos.OuvinteBotaoDeslogar;
import clebsonOuvintesExternos.OuvinteBotaoEditarPerfil;
import eduardo.Janelas.JanelaDeDefinicaoDeValorDosCreditos;
import eduardo.Janelas.JanelaDeListagemDeUsuarios;
import eduardo.Ouvintes.OuvinteBotaoListarCorridas;

@SuppressWarnings("serial")
public class TelaAdministrador extends JanelaPadrao {
	
	private JButton btDeslogar;
	private JButton btEditarPerfil;
	
	public TelaAdministrador(CentralDeInformacoes central, Persistencia per, Administrador administrador) {
		super("Administrador");
		this.central = central;
		this.persistencia = per;
		this.usuario = administrador;
		adicionarBotoes();
		
		setVisible(true);
	}

	private void adicionarBotoes() {
		JButton btListarUsuarios = new JButton();
		btListarUsuarios.setBounds(70, 121, 130, 40);
		btListarUsuarios.setText("Listar Usuarios");
		btListarUsuarios.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new JanelaDeListagemDeUsuarios((Administrador) usuario, central, persistencia);
			}
			
		});
		btListarUsuarios.setFont(new Font("Tahoma",Font.BOLD,10));
		add (btListarUsuarios);
		
		JButton btListarCorridas = new JButton();
		btListarCorridas.setBounds(280, 121, 130, 40);
		btListarCorridas.setText("Listar Corridas");
		btListarCorridas.addActionListener(new OuvinteBotaoListarCorridas(usuario, central, persistencia));
		btListarCorridas.setFont(new Font("Tahoma",Font.BOLD,10));
		add (btListarCorridas);
		
		JButton btFinancas = new JButton();
		btFinancas.setBounds(70, 191, 130, 40);
		btFinancas.setText("Finanças");
		btFinancas.setFont(new Font("Tahoma",Font.BOLD,10));
		add (btFinancas);
		
		JButton btDefinirValor = new JButton();
		btDefinirValor.setBounds(280, 191, 130, 40);
		btDefinirValor.setText("Definir Valor");
		btDefinirValor.addActionListener( new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new JanelaDeDefinicaoDeValorDosCreditos((Administrador) usuario);
			}
			
		});
		btDefinirValor.setFont(new Font("Tahoma",Font.BOLD,10));
		add (btDefinirValor);
		
		btEditarPerfil  = new JButton();
		btEditarPerfil.setBounds(340, 320, 130, 35);
		btEditarPerfil.setText("Editar Perfil");
		btEditarPerfil.setFont(new Font("Tahoma",Font.BOLD,10));
		add (btEditarPerfil);
		OuvinteBotaoEditarPerfil ouvinteEditarPerfil = new OuvinteBotaoEditarPerfil(this);
		btEditarPerfil.addActionListener(ouvinteEditarPerfil);
		
		
		btDeslogar = new JButton();
		btDeslogar.setBounds(340, 370, 130, 35);
		btDeslogar.setText("Deslogar");
		btDeslogar.setFont(new Font("Tahoma",Font.BOLD,10));
		add (btDeslogar);
		OuvinteBotaoDeslogar ouvinteDeslogar = new OuvinteBotaoDeslogar(this);
		btDeslogar.addActionListener(ouvinteDeslogar);
	
	}
}
