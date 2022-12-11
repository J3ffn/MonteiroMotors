package jefferson.telaDeAdicionarCreditos.ouvintesAdicionar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Date;

import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;

public class OuvinteComboBox implements ActionListener{

	private JFrame telaAtual;
	private JFormattedTextField campoDigitarData;
	private LocalDate data;
	
	public OuvinteComboBox(JFrame tela, JFormattedTextField campo, LocalDate data) {
		telaAtual = tela;
		campoDigitarData = campo;
		this.data = data;
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
			campoDigitarData.setVisible(false);
			ativarCampoData();
			break;
		}
	}
	
	private void ativarCampoData() {
		campoDigitarData.setVisible(true);
		
		campoDigitarData.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				char key = e.getKeyChar();
				String texto = campoDigitarData.getText();
				if (texto.lastIndexOf("/") > 12 || texto.lastIndexOf("/") < 0) {
					e.consume();
				}
				
			}
			
			public void keyReleased(KeyEvent e) {}
			
			public void keyPressed(KeyEvent e) {}
		});
		
		campoDigitarData.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				String dataDigitada = campoDigitarData.getText();
				CharSequence c = dataDigitada;
				System.out.println(campoDigitarData.getText());;
				
				DateTimeFormatter sdf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				data = sdf.ofPattern(dataDigitada);
				;
				System.out.println(data.getYear());
				
			}
			
			@Override
			public void focusGained(FocusEvent e) {}
		});
		
	}

}
