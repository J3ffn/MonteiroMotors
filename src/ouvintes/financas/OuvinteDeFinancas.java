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
import sistemas.Manipuladores.Mensageiro;
import sistemas.Usuários.Usuario;

public class OuvinteDeFinancas implements ActionListener {

	private Usuario usuario;
	private ArrayList<Corrida> corridas;
	private LocalDateTime dataFiltro;
	private JComboBox<String> campoBox;
	private JFormattedTextField dataDigitada;
	private Mensageiro mensageiro = new Mensageiro();
	private String email;
	private CentralDeInformacoes central;

	public OuvinteDeFinancas(Usuario infoUsuario, ArrayList<Corrida> listaCorridas, LocalDateTime data,
			JComboBox<String> box, JFormattedTextField campoData, CentralDeInformacoes centralI) {
		usuario = infoUsuario;
		email = infoUsuario.getEmail();
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

			try {

				DateTimeFormatter sdf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
				dataFiltro = LocalDateTime.parse(dataDigitada, sdf);

			} catch (Exception c) {
				JOptionPane.showMessageDialog(null, "Data inválida");
			}

			/*---------------------------------------------------------------------*/
			if (dataFiltro != null) {
				String escolha = (String) campoBox.getSelectedItem();

				ArrayList<Corrida> corridasFiltradas = new ArrayList<>();
				for (Corrida c : corridas) {
					switch (escolha) {
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
				central.atualizarCentral(usuario);
			}
		} else {
			JOptionPane.showConfirmDialog(null, "Não há registro de compras", "Impossível", JOptionPane.DEFAULT_OPTION,
					JOptionPane.INFORMATION_MESSAGE);
		}

	}

}
