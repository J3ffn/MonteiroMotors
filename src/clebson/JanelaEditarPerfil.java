package clebson;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import ListaDeAquecimento.TipoDeConta;
import ListaDeAquecimento.Usuario;
import clebsonOuvintesExternos.OuvinteBotaoDeletarPerfil;
import eduardo.Ouvintes.OuvinteBotaoCancelar;

@SuppressWarnings("serial")
public class JanelaEditarPerfil extends JanelaPadrao{
	
	private JLabel lbNome;
	private JLabel lbEmailDeUsuario;
	
	public JLabel getLbNome() {
		return lbNome;
	}


	public void setLbNome(JLabel lbNome) {
		this.lbNome = lbNome;
	}


	public JLabel getLbEmail() {
		return lbEmailDeUsuario;
	}


	public void setLbEmail(JLabel lbEmail) {
		this.lbEmailDeUsuario = lbEmail;
	}


	private JLabel lbTipoDeUsuario;
	
	public JLabel getLbTipoDeUsuario() {
		return lbTipoDeUsuario;
	}


	public void setLbTipoDeUsuario(JLabel lbTipoDeUsuario) {
		this.lbTipoDeUsuario = lbTipoDeUsuario;
	}


	public JanelaEditarPerfil(Usuario usuario) {
		super("Editar Perfil", usuario);
		adicionarTextos(usuario);
		adicionarBotoes(usuario);
		setVisible(true);
	}
	

	private void adicionarTextos(Usuario usuario) {
		lbNome = new JLabel();
		lbNome.setText("NOME: " + usuario.getNome());
		lbNome.setBounds(100,170 , 220, 20);
		lbNome.setFont(new Font("Arial",Font.BOLD,12));
		add(lbNome);
		
		lbEmailDeUsuario = new JLabel();
		lbEmailDeUsuario.setText("EMAIL: " + usuario.getEmail());
		lbEmailDeUsuario.setBounds(100,205 , 220, 20);
		lbEmailDeUsuario.setFont(new Font("Arial",Font.BOLD,12));
		add(lbEmailDeUsuario);
		
		lbTipoDeUsuario = new JLabel();
		lbTipoDeUsuario.setText("TIPO DE USUÁRIO: " + usuario.recuperarCargo());
		lbTipoDeUsuario.setBounds(100,240 , 220, 20);
		lbTipoDeUsuario.setFont(new Font("Arial",Font.BOLD,12));
		add(lbTipoDeUsuario);
		
		ImageIcon icone = new ImageIcon("icones/User (1).png");
		JLabel lbImagem = new JLabel(icone);
		lbImagem.setBounds(199, 40, 100, 100);
		add(lbImagem);
		
	}
	
	private class OuvinteBotaoEditarNome implements ActionListener{
		
		private Usuario usuario;
		
		public OuvinteBotaoEditarNome(Usuario usuario) {
			this.usuario = usuario;
		}
		public void actionPerformed(ActionEvent e) {
			String novoNome = JOptionPane.showInputDialog("Digite o novo nome: ");
			usuario.setNome(novoNome);
			lbNome.setText("NOME: " + usuario.getNome());
			JOptionPane.showMessageDialog(null, "Mudança Concluida");
			
	
		}
	}
	private class OuvinteBotaoEditarEmail implements ActionListener{
		
		private Usuario usuario;

		
		public OuvinteBotaoEditarEmail(Usuario usuario) {
			// TODO Auto-generated constructor stub
			this.usuario = usuario;
		}
		
		public void actionPerformed(ActionEvent e) {
			String novoEmail = JOptionPane.showInputDialog("Digite o novo email: ");
			usuario.setEmail(novoEmail);
			lbEmailDeUsuario.setText("EMAIL: " + usuario.getEmail());
			JOptionPane.showMessageDialog(null, "Mudança Concluida");
		
			
		}
	}
	private class OuvinteBotaoEditarTipo implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			new JanelaMudançaTipo();

		}
				
		}
	
	
	OuvinteBotaoEditarNome ouvinteEditarNome = new OuvinteBotaoEditarNome(this.getUsuario());
	OuvinteBotaoEditarEmail ouvinteEditarEmail = new OuvinteBotaoEditarEmail(this.getUsuario());
	OuvinteBotaoDeletarPerfil ouvinteDeletarPerfil = new OuvinteBotaoDeletarPerfil();
	OuvinteBotaoEditarTipo ouvinteEditarTipo = new OuvinteBotaoEditarTipo();
	
	private void adicionarBotoes(Usuario usuario) {
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
		
		JButton btVoltar = new JButton();
		btVoltar.setBounds(174, 387, 150, 20);
		btVoltar.setText("Cancelar");
		btVoltar.setFont(new Font("Tahoma",Font.BOLD,10));
		btVoltar.addActionListener(new OuvinteBotaoCancelar(this));
		add (btVoltar);
		
		if (usuario.getTipoDeConta() == TipoDeConta.ADMINISTRADOR) {
			JButton btEditarPerfil = new JButton();
			btEditarPerfil.setBounds(350, 240, 100, 20);
			btEditarPerfil.setText("Editar Tipo");
			btEditarPerfil.setFont(new Font("Tahoma",Font.BOLD,10));
			btEditarPerfil.addActionListener(ouvinteEditarTipo);
			add (btEditarPerfil);
			
		}
	}
}
