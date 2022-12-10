package clebson;

import java.awt.Font;

import javax.swing.JButton;

import clebsonOuvintesExternos.OuvinteBotaoDeslogar;
import clebsonOuvintesExternos.OuvinteBotaoEditarPerfil;

@SuppressWarnings("serial")
public class JanelaPadraoUsuario extends JanelaPadrao{
	private JButton btDeslogar;
	private JButton btEditarPerfil;

	public JanelaPadraoUsuario(String nome) {
		super(nome);
		adicionarBotoes();
	}
	

	public void adicionarBotoes() {
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
