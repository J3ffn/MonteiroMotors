package clebsonOuvintesExternos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import clebson.JanelaMudancaTipo;

public class OuvinteBotaoConfirmaTrocaDeTipo implements ActionListener{
	
	private JanelaMudancaTipo janela;
	public OuvinteBotaoConfirmaTrocaDeTipo(JanelaMudancaTipo janela) {
		this.janela = janela;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String tipo = (String) janela.getTipos().getSelectedItem();
		janela.dispose();
		
	}

}
