package jefferson.telaDeLogin_OK.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import eduardo.Janelas.JanelaDeRegistro;

public class OuvinteBotaoRegistrar implements ActionListener{

	private JFrame tela;
	
	public OuvinteBotaoRegistrar(JFrame tela) {
		this.tela = tela;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		tela.dispose();
		new JanelaDeRegistro();
	}
	
	
}