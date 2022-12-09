package eduardo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class OuvinteBotaoCancelar implements ActionListener {
	JFrame janela;
	public OuvinteBotaoCancelar(JFrame j) {
		janela = j;
	}
	public void actionPerformed(ActionEvent e) {
		janela.dispose();
	}
}
