package jefferson.telaDeLogin.telas;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import ListaDeAquecimento.CentralDeInformacoes;
import ListaDeAquecimento.Persistencia;
import clebson.JanelaPadrao;
import jefferson.telaDeLogin.ouvintes.OuvinteBotaoEsqueceuSenha;
import jefferson.telaDeLogin.ouvintes.OuvinteBotaoLogin;
import jefferson.telaDeLogin.ouvintes.OuvinteBotaoRegistrar;

@SuppressWarnings("serial")
public class TelaDeLogin extends JanelaPadrao{
	private CentralDeInformacoes central;
	private Persistencia persistencia;
	
	private JTextField campoEmail;
	private JPasswordField campoPassword;
	
	public TelaDeLogin(CentralDeInformacoes c, Persistencia p) {
		super("Tela de Login", null);
		addTextField();
		addImagem();
		addBotoes();
		central = c;
		persistencia = p;
		setVisible(true);
	}
	
	public void addBotoes() {
		
		JFrame tela = this;
		JButton login = new JButton("Login");
		login.setBounds(175, 280, 125, 40);
		login.addActionListener(new OuvinteBotaoLogin(campoEmail, campoPassword, tela));
		
		/*---------------------------------------*/
		
		JButton registrar = new JButton("Registrar");
		registrar.setBounds(100, 330, 125, 40);
		registrar.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseEntered(MouseEvent e) {
				registrar.addActionListener(new OuvinteBotaoRegistrar(tela, central, persistencia));
			}
			
		});
		
		/*---------------------------------------*/
		
		JButton esqueceuSenha = new JButton("Esqueceu a senha");
		esqueceuSenha.setBounds(236, 330, 145, 40);
		esqueceuSenha.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseEntered(MouseEvent e) {
				esqueceuSenha.addActionListener(new OuvinteBotaoEsqueceuSenha(tela));
			}
			
		});
		
		/*---------------------------------------*/
		
		add(login);
		add(registrar);
		add(esqueceuSenha);
	}

	public void addTextField() {
		JLabel subLogin = new JLabel("E-MAIL:");
		subLogin.setBounds(115, 140, 80, 30);
		
		campoEmail = new JTextField();
		campoEmail.setBounds(115, 165, 250, 40);
		
		/*---------------------------------------*/
		
		JLabel subSenha = new JLabel("SENHA:");
		subSenha.setBounds(115, 201, 130, 30);
		
		campoPassword = new JPasswordField();
		campoPassword.setBounds(115, 225, 250, 40);
		
		/*---------------------------------------*/

		add(subLogin);
		add(campoEmail);
		add(subSenha);
		add(campoPassword);
	}
	
	public void addImagem() {
		ImageIcon imagem = new ImageIcon("icones/Logo.png");
		
		/*---------------------------------------*/
		
		JLabel logo = new JLabel();
		logo.setIcon(imagem);
		logo.setBounds(140, -55, 300, 300);
		
		/*---------------------------------------*/
		
		add(logo);
	}
	
}
