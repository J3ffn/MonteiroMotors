package clebson;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import ListaDeAquecimento.CentralDeInformacoes;
import ListaDeAquecimento.Passageiro;
import ListaDeAquecimento.Persistencia;
import eduardo.Janelas.JanelaDeCadastroDeCorrida;
import eduardo.Ouvintes.OuvinteBotaoListarCorridas;

@SuppressWarnings("serial")
public class JanelaPassageiro extends JanelaPadraoUsuario{

	
	public JanelaPassageiro(CentralDeInformacoes central, Persistencia persistencia, Passageiro p) {
		super("Passageiro");
		this.setCentral(central);
		this.setPersistencia(persistencia);
		this.setUsuario(p);
		adicionarBotoesPassageiro();
		
		setVisible(true);
	}
	
	private class OuvinteDeBtCadastroCorrida implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			new JanelaDeCadastroDeCorrida(getCentral(), getPersistencia(), getUsuario());
		}
	}
	
	private void adicionarBotoesPassageiro() {
		super.adicionarBotoes();
		
		JButton btCadastroCorrida = new JButton();
		btCadastroCorrida.setBounds(170, 121, 130, 50);
		btCadastroCorrida.setText("Cadastrar Corrida");
		btCadastroCorrida.setFont(new Font("Tahoma",Font.BOLD,10));
		btCadastroCorrida.addActionListener(new OuvinteDeBtCadastroCorrida());
		add (btCadastroCorrida);
		
		JButton btListarCorridas = new JButton();
		btListarCorridas.setBounds(170, 191, 130, 30);
		btListarCorridas.setText("Listar Corridas");
		btListarCorridas.addActionListener(new OuvinteBotaoListarCorridas(getUsuario(), getCentral(), getPersistencia()));
		btListarCorridas.setFont(new Font("Tahoma",Font.BOLD,10));
		add (btListarCorridas);
		
		
	}
	

}
