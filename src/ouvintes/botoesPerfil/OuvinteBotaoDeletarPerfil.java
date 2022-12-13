package ouvintes.botoesPerfil;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import janelas.janelaDeLogin.JanelaDeLogin;
import janelas.janelasAdministrativas.JanelaDeListagemDeUsuarios;
import sistemas.GestãoDeInformacoes.CentralDeInformacoes;
import sistemas.GestãoDeInformacoes.Persistencia;
import sistemas.Usuários.Administrador;
import sistemas.Usuários.Usuario;

public class OuvinteBotaoDeletarPerfil implements ActionListener {
	private CentralDeInformacoes central;
	private Usuario usuario;
	private JFrame janela;
	private Usuario usuarioADM;
	private JFrame janelaAnterior;

	public OuvinteBotaoDeletarPerfil(Usuario usuario, JFrame janela, Usuario usuarioADM, JFrame janelaAnterior) {
		this.usuario = usuario;
		this.janela = janela;
		this.usuarioADM = usuarioADM;
		this.janelaAnterior = janelaAnterior;
		
		try {
			central = (CentralDeInformacoes) new Persistencia().recuperar("dados-passageiros.xml");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void actionPerformed(ActionEvent e) {
		int op = JOptionPane.showConfirmDialog(null, "Deseja Deletar o Perfil?", "Pergunta", JOptionPane.YES_NO_OPTION,
				JOptionPane.WARNING_MESSAGE);
		switch (op) {
		case (JOptionPane.YES_OPTION):
			central.deletarPerfil(usuario);
		
			try {
				new Persistencia().salvar(central, "dados-passageiros.xml");
			JOptionPane.showMessageDialog(null, "Perfil Deletado! :)");
			janela.dispose();
			if (usuarioADM != null) {
				janelaAnterior.setVisible(true);
			} else {
				new JanelaDeLogin();
			}
			break;
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}
}
