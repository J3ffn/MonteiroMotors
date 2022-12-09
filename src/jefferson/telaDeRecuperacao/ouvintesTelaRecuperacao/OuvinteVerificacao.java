package jefferson.telaDeRecuperacao.ouvintesTelaRecuperacao;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JTextField;

import jefferson.telaDeRecuperacao.telasParaRecuperacao.TelaDeAlteracaoDaSenha;

public class OuvinteVerificacao extends MouseAdapter {
	
	private String email;
	private JFrame jtela;
	
	public OuvinteVerificacao(JFrame tela, JTextField textField) {
		jtela = tela;
		email = textField.getText();
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		jtela.dispose();
		new TelaDeAlteracaoDaSenha(email);
	};
		
}
