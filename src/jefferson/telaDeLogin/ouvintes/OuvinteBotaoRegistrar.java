package jefferson.telaDeLogin.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import ListaDeAquecimento.CentralDeInformacoes;
import ListaDeAquecimento.Persistencia;
import eduardo.Janelas.JanelaDeRegistro;

public class OuvinteBotaoRegistrar implements ActionListener{

	private JFrame tela;
	private CentralDeInformacoes central;
	private Persistencia persistencia;
	
	public OuvinteBotaoRegistrar(JFrame tela, CentralDeInformacoes c, Persistencia p) {
		this.tela = tela;
		this.central = c;
		this.persistencia = p;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		tela.dispose();
		new JanelaDeRegistro();
	}
	
}