package jefferson.telaDeLogin_OK.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import ListaDeAquecimento.*;
import clebson.*;

public class OuvinteBotaoLogin implements ActionListener{

	private JTextField campoLogin;
	private JPasswordField campoSenha;
	private CentralDeInformacoes central;
	private JFrame tela;
	
	public OuvinteBotaoLogin(JTextField campoLogin, JPasswordField campoSenha, JFrame tela) {
		this.campoLogin = campoLogin;
		this.campoSenha = campoSenha;
		this.tela = tela;
		
		try {
			central = (CentralDeInformacoes) new Persistencia().recuperar("dados-passageiros.xml");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			String senha = new String(campoSenha.getPassword());
			Usuario usuario = central.fazerLogin(campoLogin.getText(), senha);
			
			if (usuario.getEmail().equals(campoLogin.getText()) && usuario.getSenha().equals(senha)) {
				JOptionPane.showMessageDialog(null, "Está dentro");
				tela.dispose();
				
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