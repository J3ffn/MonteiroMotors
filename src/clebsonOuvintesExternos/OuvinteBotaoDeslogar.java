package clebsonOuvintesExternos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import ListaDeAquecimento.CentralDeInformacoes;
import ListaDeAquecimento.Persistencia;
import jefferson.telaDeLogin_OK.telas.TelaDeLogin;

public class OuvinteBotaoDeslogar implements ActionListener{

	JFrame janela;
	CentralDeInformacoes central;
	
	public OuvinteBotaoDeslogar(JFrame j, CentralDeInformacoes c) {
		janela = j;
		central = c;
	}
	public void actionPerformed(ActionEvent e) {
		janela.dispose();
		new TelaDeLogin();
	}
}
