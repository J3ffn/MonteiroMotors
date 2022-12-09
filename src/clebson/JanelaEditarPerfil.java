package clebson;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class JanelaEditarPerfil extends JanelaPadrao{
	
	private JLabel lbNome;
	private JLabel lbEmail;
	private JLabel lbTipoDeUsuario;
	
	public JanelaEditarPerfil() {
		super("Editar Perfil");
		adicionarTextos();
		adicionarBotoes();
		
		setVisible(true);
	}


	public void adicionarTextos() {
		lbNome = new JLabel("NOME: ");		
		lbNome.setBounds(100,170 , 220, 20);
		lbNome.setFont(new Font("Arial",Font.BOLD,12));
		add(lbNome);
		
		lbEmail = new JLabel("EMAIL: ");		
		lbEmail.setBounds(100,205 , 220, 20);
		lbEmail.setFont(new Font("Arial",Font.BOLD,12));
		add(lbEmail);
		
		lbTipoDeUsuario = new JLabel("TIPO DE USUÁRIO: ");		
		lbTipoDeUsuario.setBounds(100,240 , 220, 20);
		lbTipoDeUsuario.setFont(new Font("Arial",Font.BOLD,12));
		add(lbTipoDeUsuario);
		
	}
	
	public class OuvinteBotaoEditarNome implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			String nome = JOptionPane.showInputDialog("Digite o novo nome: ");
			JOptionPane.showMessageDialog(null, "Mudança Concluida");
			lbNome.setText("NOME: "+nome);
		}
	}
	public class OuvinteBotaoEditarEmail implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			String email = JOptionPane.showInputDialog("Digite o novo email: ");
			JOptionPane.showMessageDialog(null, "Mudança Concluida");
			lbEmail.setText("EMAIL: " + email);
			
		}
	}
	OuvinteBotaoEditarNome ouvinteEditarNome = new OuvinteBotaoEditarNome();
	OuvinteBotaoEditarEmail ouvinteEditarEmail = new OuvinteBotaoEditarEmail();
	
	
	public void adicionarBotoes() {
		JButton btEditarNome = new JButton();
		btEditarNome.setBounds(350, 170, 100, 20);
		btEditarNome.setText("Editar Nome");
		btEditarNome.setFont(new Font("Tahoma",Font.BOLD,10));
		add (btEditarNome);
		btEditarNome.addActionListener(ouvinteEditarNome);
		
		
		JButton btEditarEmail = new JButton();
		btEditarEmail.setBounds(350, 205, 100, 20);
		btEditarEmail.setText("Editar E-mail");
		btEditarEmail.setFont(new Font("Tahoma",Font.BOLD,10));
		add (btEditarEmail);
		btEditarEmail.addActionListener(ouvinteEditarEmail);
		
		JButton btEditarTipo = new JButton();
		btEditarTipo.setBounds(350, 240, 100, 20);
		btEditarTipo.setText("Editar Tipo");
		btEditarTipo.setFont(new Font("Tahoma",Font.BOLD,10));
		add (btEditarTipo);
		
		JButton btDeletarPerfil = new JButton();
		btDeletarPerfil.setBounds(174, 362, 150, 20);
		btDeletarPerfil.setText("Deletar Perfil");
		btDeletarPerfil.setFont(new Font("Tahoma",Font.BOLD,10));
		add (btDeletarPerfil);
	}
}
