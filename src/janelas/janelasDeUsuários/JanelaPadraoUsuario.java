package janelas.janelasDeUsuários;

import java.awt.Font;

import javax.swing.JButton;

import ouvintes.botoesPerfil.OuvinteBotaoDeslogar;
import ouvintes.botoesPerfil.OuvinteBotaoEditarPerfil;
import sistemas.Usuários.Usuario;
import sistemas.janela.JanelaPadrao;

@SuppressWarnings("serial")
public class JanelaPadraoUsuario extends JanelaPadrao {

	private JButton btDeslogar;
	private JButton btEditarPerfil;

	public JanelaPadraoUsuario(String nome, Usuario usuario) {
		super(nome, usuario);
		adicionarBotoes();
	}

	public void adicionarBotoes() {
		btEditarPerfil = new JButton();
		btEditarPerfil.setBounds(340, 320, 130, 35);
		btEditarPerfil.setText("Editar Perfil");
		btEditarPerfil.setFont(new Font("Tahoma", Font.BOLD, 10));
		add(btEditarPerfil);
		btEditarPerfil.addActionListener(new OuvinteBotaoEditarPerfil(this, getUsuario()));

		btDeslogar = new JButton();
		btDeslogar.setBounds(340, 370, 130, 35);
		btDeslogar.setText("Deslogar");
		btDeslogar.setFont(new Font("Tahoma", Font.BOLD, 10));
		add(btDeslogar);
		btDeslogar.addActionListener(new OuvinteBotaoDeslogar(this, getCentral()));
	}
}
