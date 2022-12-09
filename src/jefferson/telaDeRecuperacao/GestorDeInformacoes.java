package jefferson.telaDeRecuperacao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class GestorDeInformacoes implements OuvinteGestorDeInformacoes, ActionListener{

	@Override
	public void gestor(String texto, JFrame tela, JTextField campoEmail) {
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JTextField tf = (JTextField) e.getSource();
		
		if (tf.getText().length() > 0) {
			
		}
		
	}

}
