package janelas.janelasDeUsuários;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import ouvintes.botoesPerfil.OuvinteBotaoDeletarPerfil;
import ouvintes.listagemDeCorridas.OuvinteBotaoCancelar;
import sistemas.Usuários.TipoDeConta;
import sistemas.Usuários.Usuario;
import sistemas.janela.JanelaPadrao;

@SuppressWarnings("serial")
public class JanelaEditarPerfil extends JanelaPadrao {

	private JLabel lbNome;
	private JLabel lbEmailDeUsuario;
	private JLabel lbTipoDeUsuario;

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
		lbNome.setBounds(100, 170, 220, 20);
		lbNome.setFont(new Font("Arial", Font.BOLD, 12));
		add(lbNome);

		lbEmailDeUsuario = new JLabel();
		lbEmailDeUsuario.setText("EMAIL: " + usuario.getEmail());
		lbEmailDeUsuario.setBounds(100, 205, 220, 20);
		lbEmailDeUsuario.setFont(new Font("Arial", Font.BOLD, 12));
		add(lbEmailDeUsuario);

		lbTipoDeUsuario = new JLabel();
		lbTipoDeUsuario.setText("TIPO DE USUÁRIO: " + usuario.recuperarCargo());
		lbTipoDeUsuario.setBounds(100, 240, 220, 20);
		lbTipoDeUsuario.setFont(new Font("Arial", Font.BOLD, 12));
		add(lbTipoDeUsuario);

		ImageIcon icone = new ImageIcon("icones/User (1).png");
		JLabel lbImagem = new JLabel(icone);
		lbImagem.setBounds(199, 40, 100, 100);
		add(lbImagem);

	}

	private class OuvinteBotaoEditarNome implements ActionListener {

		private Usuario usuario;
		private JFrame janela;

		public OuvinteBotaoEditarNome(Usuario usuario, JFrame janela) {
			this.usuario = usuario;
			this.janela = janela;
		}

		public void actionPerformed(ActionEvent e) {
			try {
				String novoNome = JOptionPane.showInputDialog("Digite o novo nome: ");
				if (!novoNome.equals("")) {
					usuario.setNome(novoNome);
					getCentral().recuperarUsuarioPeloEmail(usuario.getEmail()).setNome(usuario.getNome());
					lbNome.setText("NOME: " + usuario.getNome());
					getCentral().atualizarCentral(usuario);
				}

			} catch (NullPointerException erro) {

			} finally {
				JOptionPane.showMessageDialog(null, "Mudança Concluida");
				new JanelaEditarPerfil(usuario);
				janela.dispose();
			}
		}
	}

	private class OuvinteBotaoEditarEmail implements ActionListener {

		private Usuario usuario;
		private JFrame janela;

		public OuvinteBotaoEditarEmail(Usuario usuario, JFrame janela) {
			this.usuario = usuario;
		}

		public void actionPerformed(ActionEvent e) {
			try {
				String novoEmail = JOptionPane.showInputDialog("Digite o novo email: ");
				if (!novoEmail.equals("")) {
					usuario.setEmail(novoEmail);
					getCentral().getUsuarioPeloId(usuario.getId()).setEmail(novoEmail);
					lbEmailDeUsuario.setText("EMAIL: " + usuario.getEmail());
					getCentral().atualizarCentral(usuario);
				}
			} catch (NullPointerException erro) {

			} finally {
				JOptionPane.showMessageDialog(null, "Mudança Concluida");
				new JanelaEditarPerfil(usuario);
				janela.dispose();
			}
		}
	}

	private class OuvinteBotaoEditarTipo implements ActionListener {
		private Usuario usuario;
		private JFrame janela;
		private String novoTipo;

		public OuvinteBotaoEditarTipo(Usuario usuario, JFrame janela) {
			this.usuario = usuario;
			this.janela = janela;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				novoTipo = JOptionPane.showInputDialog("Digite o novo tipo: ");
				if (!novoTipo.equals("")) {
					switch (novoTipo.toUpperCase()) {
					case ("ADMINISTRADOR"):
						usuario.setTipoDeConta(TipoDeConta.ADMINISTRADOR);
						getCentral().atualizarCentral(usuario);
						lbTipoDeUsuario.setText("TIPO : " + usuario.recuperarCargo());
						novoTipo = "Administrador";
						break;
					case ("MOTOTAXISTA"):
						usuario.setTipoDeConta(TipoDeConta.MOTOTAXISTA);
						getCentral().atualizarCentral(usuario);
						lbTipoDeUsuario.setText("TIPO : " + usuario.recuperarCargo());
						novoTipo = "Mototaxista";
						break;
					case ("PASSAGEIRO"):
						usuario.setTipoDeConta(TipoDeConta.PASSAGEIRO);
						getCentral().getUsuarioPeloId(usuario.getId()).setTipoDeConta(TipoDeConta.PASSAGEIRO);
						;
						getCentral().atualizarCentral(usuario);
						lbTipoDeUsuario.setText("TIPO : " + usuario.recuperarCargo());
						novoTipo = "Passageiro";
						break;
					}
				}
			} catch (NullPointerException erro) {

			} finally {
				JOptionPane.showMessageDialog(null, "Mudança Concluida");

				lbTipoDeUsuario.setText("TIPO : " + novoTipo);

				new JanelaEditarPerfil(usuario);
			}

		}

	}

	OuvinteBotaoEditarNome ouvinteEditarNome = new OuvinteBotaoEditarNome(this.getUsuario(), this);
	OuvinteBotaoEditarEmail ouvinteEditarEmail = new OuvinteBotaoEditarEmail(this.getUsuario(), this);
	OuvinteBotaoDeletarPerfil ouvinteDeletarPerfil = new OuvinteBotaoDeletarPerfil(this.getUsuario(), this);
	OuvinteBotaoEditarTipo ouvinteEditarTipo = new OuvinteBotaoEditarTipo(this.getUsuario(), this);

	private void adicionarBotoes(Usuario usuario) {
		JButton btEditarNome = new JButton();
		btEditarNome.setBounds(350, 170, 100, 20);
		btEditarNome.setText("Editar Nome");
		btEditarNome.setFont(new Font("Tahoma", Font.BOLD, 10));
		add(btEditarNome);
		btEditarNome.addActionListener(ouvinteEditarNome);

		JButton btEditarEmail = new JButton();
		btEditarEmail.setBounds(350, 205, 100, 20);
		btEditarEmail.setText("Editar E-mail");
		btEditarEmail.setFont(new Font("Tahoma", Font.BOLD, 10));
		add(btEditarEmail);
		btEditarEmail.addActionListener(ouvinteEditarEmail);

		JButton btDeletarPerfil = new JButton();
		btDeletarPerfil.setBounds(174, 362, 150, 20);
		btDeletarPerfil.setText("Deletar Perfil");
		btDeletarPerfil.setFont(new Font("Tahoma", Font.BOLD, 10));
		add(btDeletarPerfil);
		btDeletarPerfil.addActionListener(ouvinteDeletarPerfil);

		JButton btVoltar = new JButton();
		btVoltar.setBounds(174, 387, 150, 20);
		btVoltar.setText("Voltar");
		btVoltar.setFont(new Font("Tahoma", Font.BOLD, 10));
		btVoltar.addActionListener(new OuvinteBotaoCancelar(this, usuario));
		add(btVoltar);

		if (usuario.getTipoDeConta() == TipoDeConta.ADMINISTRADOR) {
			JButton btEditarPerfil = new JButton();
			btEditarPerfil.setBounds(350, 240, 100, 20);
			btEditarPerfil.setText("Editar Tipo");
			btEditarPerfil.setFont(new Font("Tahoma", Font.BOLD, 10));
			btEditarPerfil.addActionListener(ouvinteEditarTipo);
			add(btEditarPerfil);

		}
	}
}
