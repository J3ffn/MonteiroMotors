package jefferson.telaDeLogin_OK.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import ListaDeAquecimento.Administrador;
import ListaDeAquecimento.CentralDeInformacoes;
import ListaDeAquecimento.Mototaxista;
import ListaDeAquecimento.Passageiro;
import ListaDeAquecimento.PerfilDesativadoException;
import ListaDeAquecimento.Persistencia;
import ListaDeAquecimento.SenhaIncorretaException;
import ListaDeAquecimento.Usuario;
import ListaDeAquecimento.UsuarioNaoCadastradoException;
import clebson.JanelaAdministrador;
import clebson.JanelaMototaxista;
import clebson.JanelaPassageiro;

public class OuvinteBotaoLogin implements ActionListener{

	private JTextField campoLogin;
	private JPasswordField campoSenha;
	private CentralDeInformacoes central;
//	private Usuario usuario;
	private JFrame tela;
	
	public OuvinteBotaoLogin(JTextField campoLogin, JPasswordField campoSenha, JFrame tela) {
		this.campoLogin = campoLogin;
		this.campoSenha = campoSenha;
		this.tela = tela;
		
		try {
			central = (CentralDeInformacoes) new Persistencia().recuperar("dados-passageiros.xml");
			
		} catch (Exception e) {
			System.out.println("Não foi possível recuperar");
			e.printStackTrace();
		}
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			String senha = new String(campoSenha.getPassword());
			Usuario usuario = central.fazerLogin(campoLogin.getText(), senha);
//			Mototaxista usuarioTeste = new UsuarioTeste();
			
			if (usuario.getEmail().equals(campoLogin.getText()) && usuario.getSenha().equals(senha)) {
				JOptionPane.showMessageDialog(null, "Está dentro");
				tela.dispose();
				
				// TODO alterar o switch.
				switch(usuario.getTipoDeConta()) {
				case ADMINISTRADOR:
					new JanelaAdministrador((Administrador) usuario);
					break;
				case PASSAGEIRO:
					new JanelaPassageiro((Passageiro) usuario);
					break;
				case MOTOTAXISTA:
					new JanelaMototaxista((Mototaxista) usuario);
					break;
				}
			}
		} catch (SenhaIncorretaException erro) {
			JOptionPane.showMessageDialog(null, "Senha Incorreta!");
		} catch (PerfilDesativadoException erro) {
			JOptionPane.showMessageDialog(null, "Perfil Desativado!");
		} catch (UsuarioNaoCadastradoException e1) {
			JOptionPane.showMessageDialog(null, "Usuario Não Cadastrado no Sistema!");
		}
			
	}
	
}