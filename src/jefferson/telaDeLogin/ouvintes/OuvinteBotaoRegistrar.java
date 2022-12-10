package jefferson.telaDeLogin.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import ListaDeAquecimento.CentralDeInformacoes;
import ListaDeAquecimento.Persistencia;
import eduardo.Janelas.JanelaDeRegistro;

public class OuvinteBotaoRegistrar implements ActionListener{

	private JFrame tela;
	
	public OuvinteBotaoRegistrar(JFrame tela) {
		this.tela = tela;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		tela.dispose();
		new JanelaDeRegistro(new CentralDeInformacoes(), new Persistencia());
	}
	
}