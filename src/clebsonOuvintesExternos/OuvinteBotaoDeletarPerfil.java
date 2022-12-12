package clebsonOuvintesExternos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import ListaDeAquecimento.Usuario;



public class OuvinteBotaoDeletarPerfil implements ActionListener{

	private Usuario usuario;
	
	
	public OuvinteBotaoDeletarPerfil(Usuario usuario) {
		this.usuario = usuario;

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

