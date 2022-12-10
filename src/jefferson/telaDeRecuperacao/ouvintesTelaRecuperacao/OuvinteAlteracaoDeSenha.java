package jefferson.telaDeRecuperacao.ouvintesTelaRecuperacao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import ListaDeAquecimento.CentralDeInformacoes;
import ListaDeAquecimento.Persistencia;
import ListaDeAquecimento.Usuario;
//import ListaDeAquecimento.Usuario;
import jefferson.UsuarioTeste;
import jefferson.telaDeLogin.telas.TelaDeLogin;

public class OuvinteAlteracaoDeSenha implements ActionListener {
	
	private UsuarioTeste usuarioTeste = new UsuarioTeste();
	private Usuario usuario;
	private CentralDeInformacoes central;
	private JFrame tela;
	private JTextField password;
	
	public OuvinteAlteracaoDeSenha(JFrame telaAtual, JTextField senha, Usuario usuario){
		tela = telaAtual;
		password = senha;
		this.usuario = usuario;
		
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
			
			// TODO VOLTAR, isso é apenas um teste
//			try {
//				ArrayList<Usuario> usuarios = central.getTodosOsUsuarios();
//				
//				for(int i = 0; i < usuarios.size(); i++) {
//					if (usuario.equals(usuarios.get(i))) {
//						usuarios.get(0).alterarSenha(password.getText());
//						break;
//					}
//				}
//				
//				central.setTodosOsUsuarios(usuarios);
//			
//				new Persistencia().salvar(central, "dados-passageiros.xml");
//				
//				tela.dispose();
//				new TelaDeLogin();
//			} catch (Exception e1) {
//				
//				e1.printStackTrace();
//			}
			usuarioTeste.senha = linhaConfirmarPassword.getText();
			System.out.println(usuarioTeste.senha);
			
			tela.dispose();
			new TelaDeLogin();
			
		} else {
			JOptionPane.showMessageDialog(null, "Senhas diferentes");
		}
		
	}

}
