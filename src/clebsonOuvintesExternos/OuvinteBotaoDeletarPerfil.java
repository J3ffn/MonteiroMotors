package clebsonOuvintesExternos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;



public class OuvinteBotaoDeletarPerfil implements ActionListener{

	public void actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(null, "Perfil Deletado! :)");
	}

}

