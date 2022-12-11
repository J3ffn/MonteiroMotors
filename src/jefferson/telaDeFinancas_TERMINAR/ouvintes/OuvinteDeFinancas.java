package jefferson.telaDeFinancas_TERMINAR.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.itextpdf.text.Document;

import ListaDeAquecimento.Corrida;
import ListaDeAquecimento.GeradorDePDF;
import ListaDeAquecimento.Mensageiro;
import ListaDeAquecimento.Usuario;

public class OuvinteDeFinancas implements ActionListener {

	private JFrame telaAtual;
	private ArrayList< Corrida > corridas;
	private LocalDateTime dataFiltro;
	private JComboBox<String> campoBox;
	private JFormattedTextField dataDigitada;
	private Mensageiro mensageiro = new Mensageiro();
	private String email;
	
	public OuvinteDeFinancas(JFrame tela, Usuario usuario, ArrayList<Corrida> listaCorridas, LocalDateTime data, JComboBox<String> box, JFormattedTextField campoData){
		telaAtual = tela;
		email = usuario.getEmail();
		corridas = listaCorridas;
		dataFiltro = data;
		campoBox = box;
		dataDigitada = campoData;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (corridas.size() > 0) {
			
			String selecionado = (String) campoBox.getSelectedItem();
			
			System.out.println(selecionado);
			
			String textoData = dataDigitada.getText();
			
			String dataDigitada = textoData + " 00:00";
	
			System.out.println(textoData);
			
			try {
				
				DateTimeFormatter sdf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
				dataFiltro = LocalDateTime.parse(dataDigitada, sdf);
				
			} catch(Exception c){
				JOptionPane.showMessageDialog(null, "Data inválida");
			}
			
			/*---------------------------------------------------------------------*/
			
			String escolha = (String) campoBox.getSelectedItem();
			System.out.println(escolha);
			mensageiro.enviarRelatorioFinancas(email);
			ArrayList<Corrida> corridasFiltradas = new ArrayList<>();
			for(Corrida c: corridas) {
				switch(escolha) {
				case "Recentes":
					if (c.getData().isAfter(dataFiltro)) {
						corridasFiltradas.add(c);
					}
					break;
				case "Antigas":
					if (c.getData().isBefore(dataFiltro)) {
						corridasFiltradas.add(c);
					}
				}
			}
			
			new GeradorDePDF().gerarRelatorioFinancas(corridasFiltradas);
			mensageiro.enviarRelatorioFinancas(email);
		} else {
			JOptionPane.showConfirmDialog(null, "Não há registro de compras", "Impossível", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
		}
		
	}
	
}
