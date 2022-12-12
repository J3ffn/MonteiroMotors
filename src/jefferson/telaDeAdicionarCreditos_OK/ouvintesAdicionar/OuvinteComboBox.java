package jefferson.telaDeAdicionarCreditos_OK.ouvintesAdicionar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;

import jefferson.telaDeFinancas_TERMINAR.telas.TelaFinancas;

public class OuvinteComboBox implements ActionListener{

	private TelaFinancas telaAtual;
	private JFormattedTextField campoDigitarData;
	
	public OuvinteComboBox(TelaFinancas tela, JFormattedTextField campo) {
		telaAtual = tela;
		campoDigitarData = campo;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JComboBox<String> box = (JComboBox<String>) e.getSource();
		
		String selecionado = (String) box.getSelectedItem();
		System.out.println(selecionado);
		
		switch (selecionado) {
		case "Tudo":
			campoDigitarData.setVisible(false);
			break;
		default:
			campoDigitarData.setVisible(true);
		}
	}
	
}
