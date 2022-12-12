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

import ListaDeAquecimento.CentralDeInformacoes;
import ListaDeAquecimento.Corrida;
import ListaDeAquecimento.GeradorDePDF;
import ListaDeAquecimento.Mensageiro;
import ListaDeAquecimento.Mototaxista;
import ListaDeAquecimento.TipoDeConta;
import ListaDeAquecimento.Usuario;

public class OuvinteDeFinancas implements ActionListener {

	private ArrayList< Corrida > corridas;
	private LocalDateTime dataFiltro;
	private JComboBox<String> campoBox;
	private JFormattedTextField dataDigitada;
	private Mensageiro mensageiro = new Mensageiro();
	private String email;
	private CentralDeInformacoes central;
	
	public OuvinteDeFinancas(Usuario usuario, ArrayList<Corrida> listaCorridas, LocalDateTime data, JComboBox<String> box, JFormattedTextField campoData, CentralDeInformacoes centralI){
		email = usuario.getEmail();
		corridas = listaCorridas;
		dataFiltro = data;
		campoBox = box;
		dataDigitada = campoData;
		central = centralI;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (corridas.size() > 0) {
			
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
			ArrayList<Mototaxista> mototaxistas = new ArrayList<>();
			
			for(Usuario m: central.getTodosOsMototaxistas()) {
				mototaxistas.add( (Mototaxista) m );
			}
			
			new GeradorDePDF().gerarRelatorioFinancas(mototaxistas);
			mensageiro.enviarRelatorioFinancas(/*email*/ "jefferson.mangueira@academico.ifpb.edu.br");
		} else {
			JOptionPane.showConfirmDialog(null, "Não há registro de compras", "Impossível", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
		}
		
	}
	
}
