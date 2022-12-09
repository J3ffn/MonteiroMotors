package jefferson.telaDeRecuperacao.ouvintesTelaRecuperacao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JTextField;

import ListaDeAquecimento.CentralDeInformacoes;
import ListaDeAquecimento.Persistencia;
import ListaDeAquecimento.Usuario;
//import ListaDeAquecimento.Usuario;
import jefferson.UsuarioTeste;
import jefferson.telaDeLogin.TelaDeLogin;

public class OuvinteAlteracaoDeSenha implements ActionListener {
	
	private UsuarioTeste usuarioTeste = new UsuarioTeste();
	private Usuario usuario;
	private CentralDeInformacoes central;
	private JFrame tela;
	private JTextField password;
	
	public OuvinteAlteracaoDeSenha(JFrame telaAtual, JTextField senha/*, Usuario usuario*/){
		tela = telaAtual;
		password = senha;
		/*this.usuario = usuario;*/
		
		try {
			central = (CentralDeInformacoes) new Persistencia().recuperar("dados-passageiros.xml");
		} catch (Exception e) {
			System.out.println("Não foi possível recuperar os dados");
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JTextField linhaConfirmarPassword = (JTextField) e.getSource();
		if (linhaConfirmarPassword.getText().equals(password.getText())) {
			
			ArrayList<Usuario> usuarios = central.getTodosOsUsuarios();
			
			
			
			central.setTodosOsUsuarios(usuarios);
			
			tela.dispose();
			new TelaDeLogin();
			
		} else {
			
		}
		
	}

}
