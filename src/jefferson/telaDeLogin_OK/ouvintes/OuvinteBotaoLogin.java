package jefferson.telaDeLogin_OK.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import ListaDeAquecimento.*;
import clebson.JanelaMototaxista;
import clebson.JanelaAdministrador;
import clebson.JanelaPassageiro;
import jefferson.telaDeAdicionarCreditos.UsuarioTeste;

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
//		try {
			String senha = new String(campoSenha.getPassword());
//			Usuario usuario = central.fazerLogin(campoLogin.getText(), senha);
			Mototaxista usuarioTeste = new UsuarioTeste();
			//if (UsuarioTeste.email.equals(campoLogin.getText()) && UsuarioTeste.senha.equals(senha)) {
			JOptionPane.showMessageDialog(null, "Está dentro");
			tela.dispose();
			
			// TODO alterar o switch.
			switch(TipoDeConta.MOTOTAXISTA) {
			case ADMINISTRADOR:
//				Administrador adm = new Administrador(usuarioTeste.nome, usuarioTeste.getSexo()+"", usuarioTeste.email, usuarioTeste.senha, usuarioTeste.getDataDeNascimento());
//				new JanelaAdministrador(adm);
				break;
			case PASSAGEIRO:
//				Passageiro pass = new Passageiro(usuarioTeste.nome, usuarioTeste.getSexo()+"", usuarioTeste.email, usuarioTeste.senha, usuarioTeste.getDataDeNascimento());;
//				new JanelaPassageiro(pass);
				break;
			case MOTOTAXISTA:
//				Mototaxista mtx = new Mototaxista(usuarioTeste.nome, usuarioTeste.getSexo()+"", usuarioTeste.email, usuarioTeste.senha, usuarioTeste.getDataDeNascimento());;
				Mototaxista mtx = usuarioTeste;
				new JanelaMototaxista(mtx);
				break;
			}
//		} catch (SenhaIncorretaException erro) {
//			JOptionPane.showMessageDialog(null, "Senha Incorreta!");
//		} catch (PerfilDesativadoException erro) {
//			JOptionPane.showMessageDialog(null, "Perfil Desativado!");
//		} catch (UsuarioNaoCadastradoException e1) {
//			JOptionPane.showMessageDialog(null, "Usuario Não Cadastrado no Sistema!");
//		}
	}
	
}