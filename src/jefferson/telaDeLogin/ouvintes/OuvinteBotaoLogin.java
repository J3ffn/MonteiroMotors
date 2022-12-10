package jefferson.telaDeLogin.ouvintes;

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
import jefferson.UsuarioTeste;

public class OuvinteBotaoLogin implements ActionListener{

	private JTextField campoLogin;
	private JPasswordField campoSenha;
	private CentralDeInformacoes central;
	private Usuario usuario;
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
		String senha = new String(campoSenha.getPassword());
		if (UsuarioTeste.email.equals(campoLogin.getText()) && UsuarioTeste.senha.equals(senha)) {
			JOptionPane.showMessageDialog(null, "Está dentro");
			tela.dispose();
			
			switch(usuario.getTipoDeConta()) {
			case ADMINISTRADOR:
				Administrador adm = (Administrador) usuario;
				new JanelaAdministrador(central, new Persistencia(), adm);
				break;
			case PASSAGEIRO:
				Passageiro pass = (Passageiro) usuario;
				new JanelaPassageiro(central, new Persistencia(), pass);
				break;
			case MOTOTAXISTA:
				Mototaxista mtx = (Mototaxista) usuario;
				new JanelaMototaxista(central, new Persistencia(), mtx);
				break;
			} 
			
		} else {
			JOptionPane.showMessageDialog(null, "Usuário não encontrado");
			
		}
	}
	
}