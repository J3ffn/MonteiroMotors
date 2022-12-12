package ouvintes.listagemDeCorridas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import janelas.janelaDeLogin.JanelaDeLogin;
import janelas.janelasCentrais.JanelaAdministrador;
import janelas.janelasCentrais.JanelaMototaxista;
import janelas.janelasCentrais.JanelaPassageiro;
import sistemas.Usuários.Administrador;
import sistemas.Usuários.Mototaxista;
import sistemas.Usuários.Passageiro;
import sistemas.Usuários.Usuario;

public class OuvinteBotaoCancelar implements ActionListener {
	JFrame janela;
	private Usuario usuario;
	
	public OuvinteBotaoCancelar(JFrame j, Usuario usuario) {
		janela = j;
	}

	public void actionPerformed(ActionEvent e) {
		janela.dispose();
		if (usuario instanceof Administrador) {
			new JanelaAdministrador((Administrador) usuario);
		} else if (usuario instanceof Mototaxista) {
			new JanelaMototaxista((Mototaxista) usuario);
		} else {
			new JanelaPassageiro((Passageiro) usuario);
		}
	}
}
