package jefferson.telaDeRecuperacao_OK.telasParaRecuperacao;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import ListaDeAquecimento.CentralDeInformacoes;
import ListaDeAquecimento.Persistencia;
import ListaDeAquecimento.Usuario;
import clebson.JanelaPadrao;
import jefferson.telaDeLogin_OK.telas.TelaDeLogin;

@SuppressWarnings("serial")
public final class TelaDeAlteracaoDaSenha extends JanelaPadrao {

	private Usuario usuarioParaAlteracao;
	private CentralDeInformacoes central;
	private JFrame tela = this;
	private JPasswordField linhaPassword;
	private JPasswordField linhaConfirmarPassword;
	
	public TelaDeAlteracaoDaSenha(String email) {
		super("Recuperar senha", null);
		recuperarCentral();
		usuarioParaAlteracao = central.recuperarUsuarioPeloEmail(email);
		
		addTituloDaTela();
		addCampoTextField();
		addBotoesDaTela();
		setVisible(true);
	}
	
	private void recuperarCentral() {
		try {
			central = (CentralDeInformacoes) new Persistencia().recuperar("dados-passageiros.xml");
		} catch (Exception e) {
			System.out.println("Não deu certo");
		}
	}
	
	private void addTituloDaTela() {
		JLabel linhaTitulo = new JLabel("ALTERE SUA SENHA");
		linhaTitulo.setFont(new Font("", Font.BOLD, 18));
		linhaTitulo.setBounds(150, 100, 190, 40);
		
		add(linhaTitulo);
	}
	
	private void addCampoTextField() {
		// Campo password
		JLabel subTextoSenha = new JLabel("Password: ");
		subTextoSenha.setBounds(115, 140, 80, 30);
		subTextoSenha.setFont(new Font("", Font.BOLD, 12));

		linhaPassword = new JPasswordField();
		linhaPassword.setBounds(115, 165, 250, 40);
		
		
		// Campo confirmar password
		JLabel subTextoConfirmarSenha = new JLabel("Confirmar password: ");
		subTextoConfirmarSenha.setBounds(115, 201, 130, 30);
		subTextoConfirmarSenha.setFont(new Font("", Font.BOLD, 12));
		
		linhaConfirmarPassword = new JPasswordField();
		linhaConfirmarPassword.setBounds(115, 225, 250, 40);
		
		
		add(subTextoSenha);
		add(linhaPassword);
		
		add(subTextoConfirmarSenha);
		add(linhaConfirmarPassword);
	}
	
	private void addBotoesDaTela() {
		JButton botaoConfirmar = new JButton("Alterar senha");
		botaoConfirmar.setBounds(170, 270, 125, 40);
		
		botaoConfirmar.addActionListener(new ActionListener() {
			
			
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				String novaSenha = new String(linhaPassword.getPassword());
				String confirmarNovaSenha = new String(linhaConfirmarPassword.getPassword());
				
				if (confirmarNovaSenha.equals(novaSenha) && !(confirmarNovaSenha.isBlank() || novaSenha.isBlank())) {
					
					try {
						ArrayList<Usuario> usuarios = central.getTodosOsUsuarios();
						
						for(int i = 0; i < usuarios.size(); i++) {
							if (usuarioParaAlteracao.equals(usuarios.get(i))) {
								usuarios.get(0).alterarSenha(linhaPassword.getText());
								break;
							}
						}
						
						central.setTodosOsUsuarios(usuarios);
					
						new Persistencia().salvar(central, "dados-passageiros.xml");
						
						tela.dispose();
						new TelaDeLogin();
					} catch (Exception e1) {
						
						e1.printStackTrace();
					}
					// TODO ABAIXO É APENAS PARA TESTE
//					UsuarioTeste.senha = novaSenha;
//					System.out.println(UsuarioTeste.senha);
//					System.out.println("Sucesso!!");
//					
//					tela.dispose();
//					new TelaDeLogin(central, new Persistencia());
					
				} else if (linhaPassword.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "Campos vazios");
				} else {
					JOptionPane.showMessageDialog(null, "Senhas diferentes");
				}
				
			}
		});
		
		add(botaoConfirmar);
	}
	
}
