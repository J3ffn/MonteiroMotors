package jefferson.telaDeLogin_OK.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import jefferson.telaDeRecuperacao_OK.telasParaRecuperacao.TelaDeRecuperarSenha;

public class OuvinteBotaoEsqueceuSenha  implements ActionListener{
	
	private JFrame tela;
	
	public OuvinteBotaoEsqueceuSenha(JFrame tela) {
		this.tela = tela;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		tela.dispose();
		new TelaDeRecuperarSenha();
	}
	
}
