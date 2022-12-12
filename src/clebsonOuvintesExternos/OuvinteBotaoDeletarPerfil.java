package clebsonOuvintesExternos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import ListaDeAquecimento.CentralDeInformacoes;
import ListaDeAquecimento.Persistencia;
import ListaDeAquecimento.Usuario;



public class OuvinteBotaoDeletarPerfil implements ActionListener{
	private CentralDeInformacoes central;
	private Usuario usuario;
	
	
	public CentralDeInformacoes getCentral() {
		return central;
	}

	public void setCentral(CentralDeInformacoes central) {
		this.central = central;
	}

	public OuvinteBotaoDeletarPerfil(Usuario usuario) {
		this.usuario = usuario;
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
			JOptionPane.showMessageDialog(null, "Perfil Deletado! :)");
			break;
		}	
	}
}

