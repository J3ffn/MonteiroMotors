package jefferson.telaDeRecuperacao.ouvintesTelaRecuperacao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

import ListaDeAquecimento.Usuario;
import jefferson.telaDeLogin.TelaDeLogin;

public class OuvinteAlteracaoDeSenha implements ActionListener {
	
	private Usuario usuario;
	private JFrame tela;
	private JTextField password;
	
	public OuvinteAlteracaoDeSenha(JFrame tela, JTextField senha, Usuario usuario){
		password = senha;
		this.usuario = usuario;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JTextField linhaConfirmarPassword = (JTextField) e.getSource();
		if (linhaConfirmarPassword.getText().equals(password.getText())) {
			
			
			
			tela.dispose();
			new TelaDeLogin();
		} else {
			
		}
		
	}

}
