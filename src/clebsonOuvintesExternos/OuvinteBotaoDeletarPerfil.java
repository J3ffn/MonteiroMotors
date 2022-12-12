package clebsonOuvintesExternos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import ListaDeAquecimento.CentralDeInformacoes;
import ListaDeAquecimento.Persistencia;
import ListaDeAquecimento.Usuario;
import jefferson.telaDeLogin_OK.telas.TelaDeLogin;



public class OuvinteBotaoDeletarPerfil implements ActionListener{
	private CentralDeInformacoes central;
	private Usuario usuario;
	private JFrame janela;
	
	public CentralDeInformacoes getCentral() {
		return central;
	}

	public void setCentral(CentralDeInformacoes central) {
		this.central = central;
	}

	public OuvinteBotaoDeletarPerfil(Usuario usuario, JFrame janela) {
		this.usuario = usuario;
		this.janela = janela;
		try {
			this.setCentral((CentralDeInformacoes)new Persistencia().recuperar("dados-passageiros.xml"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		int op = JOptionPane.showConfirmDialog(null, "Deseja Deletar o Perfil?", "Pergunta", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
		switch(op){
		case(JOptionPane.YES_OPTION):
			central.deletarPerfil(usuario);
			JOptionPane.showMessageDialog(null, "Perfil Deletado! :)");
			janela.dispose();
			new TelaDeLogin();
			break;
		}	
	}
}

