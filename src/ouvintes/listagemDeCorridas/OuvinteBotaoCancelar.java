package ouvintes.listagemDeCorridas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

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
		this.usuario = usuario;
	}

	public void actionPerformed(ActionEvent e) {
		janela.dispose();
		switch (usuario.getTipoDeConta()) {
		case ADMINISTRADOR:
			new JanelaAdministrador((Administrador) usuario);
			break;
		case MOTOTAXISTA:
			new JanelaMototaxista((Mototaxista) usuario);
			break;
		case PASSAGEIRO:
			new JanelaPassageiro((Passageiro) usuario);
		}

	}
}
