package clebson;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import clebsonOuvintesExternos.OuvinteBotaoDeletarPerfil;

@SuppressWarnings("serial")
public class JanelaEditarPerfil extends JanelaPadrao{
	
	private JLabel lbNome;
	private JLabel novoTipo;
	
	public JLabel getLbNome() {
		return lbNome;
	}


	public void setLbNome(JLabel lbNome) {
		this.lbNome = lbNome;
	}


	public JLabel getLbEmail() {
		return novoTipo;
	}


	public void setLbEmail(JLabel lbEmail) {
		this.novoTipo = lbEmail;
	}


	private JLabel lbTipoDeUsuario;
	
	public JLabel getLbTipoDeUsuario() {
		return lbTipoDeUsuario;
	}


	public void setLbTipoDeUsuario(JLabel lbTipoDeUsuario) {
		this.lbTipoDeUsuario = lbTipoDeUsuario;
	}


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
		
		novoTipo = new JLabel("EMAIL: ");		
		novoTipo.setBounds(100,205 , 220, 20);
		novoTipo.setFont(new Font("Arial",Font.BOLD,12));
		add(novoTipo);
		
		lbTipoDeUsuario = new JLabel("TIPO DE USUÁRIO: ");		
		lbTipoDeUsuario.setBounds(100,240 , 220, 20);
		lbTipoDeUsuario.setFont(new Font("Arial",Font.BOLD,12));
		add(lbTipoDeUsuario);
		
		ImageIcon icone = new ImageIcon("icones/User (1).png");
		JLabel lbImagem = new JLabel(icone);
		lbImagem.setBounds(199, 40, 100, 100);
		add(lbImagem);
		
	}
	
	public class OuvinteBotaoEditarNome implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			JLabel nome = getLbNome();
			String novoNome = JOptionPane.showInputDialog("Digite o novo nome: ");
			JOptionPane.showMessageDialog(null, "Mudança Concluida");
			//corrigir erro ao deixar em branco
			if (novoNome != null) {
			lbNome.setText("NOME: "+novoNome);
			}else {
				lbNome = nome;
			}
		}
	}
	public class OuvinteBotaoEditarEmail implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			JLabel email = getLbEmail();
			String novoEmail = JOptionPane.showInputDialog("Digite o novo email: ");
			JOptionPane.showMessageDialog(null, "Mudança Concluida");
			//corrigir erro ao deixar em branco
			if ((novoEmail != null)){
				novoTipo.setText("EMAIL: " + novoEmail);
			}else {
				novoTipo = email;
			}
			
		}
	}
	
	OuvinteBotaoEditarNome ouvinteEditarNome = new OuvinteBotaoEditarNome();
	OuvinteBotaoEditarEmail ouvinteEditarEmail = new OuvinteBotaoEditarEmail();
	OuvinteBotaoDeletarPerfil ouvinteDeletarPerfil = new OuvinteBotaoDeletarPerfil();
	
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
		
		JButton btDeletarPerfil = new JButton();
		btDeletarPerfil.setBounds(174, 362, 150, 20);
		btDeletarPerfil.setText("Deletar Perfil");
		btDeletarPerfil.setFont(new Font("Tahoma",Font.BOLD,10));
		add (btDeletarPerfil);
		btDeletarPerfil.addActionListener(ouvinteDeletarPerfil);
	}
}
