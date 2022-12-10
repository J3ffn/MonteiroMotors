package jefferson.telaDeRecuperacao.ouvintesTelaRecuperacao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

import jefferson.telaDeRecuperacao.telasParaRecuperacao.TelaDeAlteracaoDaSenha;

public final class OuvinteVerificacao implements ActionListener {
	
	private JFrame jtela;
	private JTextField codigoDigitado;
	private String email;
	private String codigoDeVerificacao;
	
	public OuvinteVerificacao(JFrame tela, JTextField linhaCodigo, String codigo, String emailDoUsuario) {
		jtela = tela;
		codigoDigitado = linhaCodigo;
		codigoDeVerificacao = codigo;
		email = emailDoUsuario;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (codigoDeVerificacao.equals(codigoDigitado.getText())) {
			jtela.dispose();
			new TelaDeAlteracaoDaSenha(email);
		}
		
	}

}
