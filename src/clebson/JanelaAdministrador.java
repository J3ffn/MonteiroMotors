package clebson;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import ListaDeAquecimento.Administrador;
import ListaDeAquecimento.CentralDeInformacoes;
import ListaDeAquecimento.Persistencia;
import eduardo.Janelas.JanelaDeDefinicaoDeValorDosCreditos;
import eduardo.Janelas.JanelaDeListagemDeUsuarios;
import eduardo.Ouvintes.OuvinteBotaoListarCorridas;
import jefferson.telaDeFinancas_TERMINAR.telas.TelaFinancas;

@SuppressWarnings("serial")
public class JanelaAdministrador extends JanelaPadraoUsuario {
	
	private String email;
	
	public JanelaAdministrador(Administrador adm) {
		super("Administrador", adm);
		email = adm.getEmail();
		
		adicionarBotoesAdministrador(adm);
		
		setVisible(true);
	}

	private void adicionarBotoesAdministrador(Administrador adm) {
		super.adicionarBotoes();
		
		JButton btListarUsuarios = new JButton();
		btListarUsuarios.setBounds(70, 121, 130, 40);
		btListarUsuarios.setText("Listar Usuarios");
		btListarUsuarios.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new JanelaDeListagemDeUsuarios((Administrador) getUsuario());
			}
			
		});
		btListarUsuarios.setFont(new Font("Tahoma",Font.BOLD,10));
		add (btListarUsuarios);
		
		JButton btListarCorridas = new JButton();
		btListarCorridas.setBounds(280, 121, 130, 40);
		btListarCorridas.setText("Listar Corridas");
		btListarCorridas.addActionListener(new OuvinteBotaoListarCorridas(getUsuario()));
		btListarCorridas.setFont(new Font("Tahoma",Font.BOLD,10));
		add (btListarCorridas);
		
		JButton btFinancas = new JButton();
		btFinancas.setBounds(70, 191, 130, 40);
		btFinancas.setText("Finanças");
		btFinancas.setFont(new Font("Tahoma",Font.BOLD,10));
		btFinancas.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new TelaFinancas(adm);
			}
		});
		add (btFinancas);
		
		JButton btDefinirValor = new JButton();
		btDefinirValor.setBounds(280, 191, 130, 40);
		btDefinirValor.setText("Definir Valor");
		btDefinirValor.addActionListener( new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new JanelaDeDefinicaoDeValorDosCreditos((Administrador) getUsuario());
				try {
					new Persistencia().salvar(getCentral(), "dados-passageiros.xml");
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
			
		});
		btDefinirValor.setFont(new Font("Tahoma",Font.BOLD,10));
		add (btDefinirValor);
		
	
	}
}
