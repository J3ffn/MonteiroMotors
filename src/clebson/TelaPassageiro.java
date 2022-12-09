package clebson;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import ListaDeAquecimento.CentralDeInformacoes;
import ListaDeAquecimento.Passageiro;
import ListaDeAquecimento.Persistencia;
import clebsonOuvintesExternos.OuvinteBotaoDeslogar;
import eduardo.Janelas.JanelaDeCadastroDeCorrida;

public class TelaPassageiro extends JanelaPadrao{
	private CentralDeInformacoes central;
	private Persistencia persistencia;
	private Passageiro p;
	private JButton btDeslogar;
	private JButton btEditarPerfil;
	
	
	
	public TelaPassageiro(CentralDeInformacoes central, Persistencia persistencia, Passageiro p) {
		super("Passageiro");
		this.central = central;
		this.persistencia = persistencia;
		this.p = p;
		adicionarBotoes();
		
		setVisible(true);
	}
	
	private class OuvinteDeBtCadastroCorrida implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			new JanelaDeCadastroDeCorrida(central, persistencia, p);
		}
	}
	
	private void adicionarBotoes() {
		JButton btCadastroCorrida = new JButton();
		btCadastroCorrida.setBounds(170, 121, 130, 50);
		btCadastroCorrida.setText("Cadastrar Corrida");
		btCadastroCorrida.setFont(new Font("Tahoma",Font.BOLD,10));
		btCadastroCorrida.addActionListener(new OuvinteDeBtCadastroCorrida());
		add (btCadastroCorrida);
		
		JButton btListarCorridas = new JButton();
		btListarCorridas.setBounds(170, 191, 130, 30);
		btListarCorridas.setText("Listar Corridas");
		btListarCorridas.setFont(new Font("Tahoma",Font.BOLD,10));
		add (btListarCorridas);
		
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
