package ouvintes.financas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;

import sistemas.Corridas.Corrida;
import sistemas.GestãoDeInformacoes.CentralDeInformacoes;
import sistemas.Manipuladores.GeradorDePDF;
import sistemas.Manipuladores.Mensageiro;
import sistemas.Usuários.Mototaxista;
import sistemas.Usuários.TipoDeConta;
import sistemas.Usuários.Usuario;

public class OuvinteDeFinancas implements ActionListener {

	private Usuario usuario;
	private ArrayList<Corrida> corridas;
	private LocalDateTime dataFiltro;
	private JFormattedTextField dataDigitada;
	private Mensageiro mensageiro = new Mensageiro();
	private JComboBox<String> comboBox;
	private CentralDeInformacoes central;
	private ArrayList<Mototaxista> mototaxistas;
	private String escolha;

	public OuvinteDeFinancas(Usuario infoUsuario, ArrayList<Corrida> listaCorridas, LocalDateTime data,
			JComboBox<String> box, JFormattedTextField campoData, CentralDeInformacoes centralI) {
		usuario = infoUsuario;
		corridas = listaCorridas;
		comboBox = box;
		dataFiltro = data;
		dataDigitada = campoData;
		central = centralI;
	}
	
	private boolean verificarQuantidade(ArrayList<Usuario> usuarios) {
		
		for(int i = 0; i < usuarios.size(); i++) {
			Mototaxista moto = (Mototaxista) usuarios.get(i);
				switch(escolha) {
				case "Tudo":
					if (moto.getCreditos().size() > 0) 
						return true;
				case "Recentes":
					if (moto.getCreditos().size() > 0 && moto.getCreditos().get(i).getData().isAfter(dataFiltro)) {
						return true;
					}
					break;
				case "Antigas":
					if (moto.getCreditos().size() > 0 && moto.getCreditos().get(i).getData().isBefore(dataFiltro)) {
						return true;
					}
			}
		}
		return false;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			escolha = (String) comboBox.getSelectedItem();
			if (!escolha.equals("Tudo")) {
		
					String textoData = dataDigitada.getText();
		
					String dataDigitada = textoData + " 00:00";
		
					try {
		
						DateTimeFormatter sdf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
						dataFiltro = LocalDateTime.parse(dataDigitada, sdf);
		
					} catch (Exception c) {
						JOptionPane.showMessageDialog(null, "Data inválida");
					}
			}
			
			ArrayList<Usuario> usuarios = central.getTodosOsMototaxistas();
			mototaxistas = new ArrayList<>();
			
		/*---------------------------------------------------------------------*/
			if (verificarQuantidade(usuarios)) {
					for (Usuario c : usuarios) {
						if (c.getTipoDeConta() == TipoDeConta.MOTOTAXISTA) {
							Mototaxista moto = (Mototaxista) c;
							for(int i = 0; i < moto.getCreditos().size(); i++) {
								switch (escolha) {
								case "Tudo":
									mototaxistas.add(moto);
									break;
								case "Recentes":
									if (moto.getCreditos().get(i).getData().isAfter(dataFiltro)) {
										mototaxistas.add(moto);
									}
									break;
								case "Antigas":
									if (moto.getCreditos().get(i).getData().isBefore(dataFiltro)) {
										mototaxistas.add(moto);
										
									}
								}
							}
						}
					}
					new GeradorDePDF().gerarRelatorioFinancas(mototaxistas);
					mensageiro.enviarRelatorioFinancas(usuario.getEmail());
					central.atualizarCentral(usuario);
					JOptionPane.showMessageDialog(null, "Um email com as informações foi enviado");
			
			} else {
				JOptionPane.showConfirmDialog(null, "Não há registro de compras", "Impossível", JOptionPane.DEFAULT_OPTION,
						JOptionPane.INFORMATION_MESSAGE);
			}
		} catch (Exception c) {
			JOptionPane.showMessageDialog(null, "Digite uma data");
		}

	}

}
