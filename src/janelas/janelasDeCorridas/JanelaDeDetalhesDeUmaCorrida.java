package janelas.janelasDeCorridas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.format.DateTimeFormatter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import sistemas.Corridas.Corrida;
import sistemas.Usuários.TipoDeConta;
import sistemas.Usuários.Usuario;

public class JanelaDeDetalhesDeUmaCorrida extends JFrame {

	private Corrida corrida;
	private Usuario usuario;

	public JanelaDeDetalhesDeUmaCorrida(Corrida corrida, Usuario usuario, int num) {
		this.corrida = corrida;
		this.usuario = usuario;

		setResizable(false);
		setLayout(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		if (num == 1) {
			setSize(598, 162);
			setTitle("Detalhes da corrida");

			addTabela();
			addBotoes();
		}
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public Corrida getCorrida() {
		return corrida;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	private void addTabela() {
		JLabel detalhes = new JLabel("DETALHES CORRIDA:");
		detalhes.setBounds(20, 1, 150, 40);

		DateTimeFormatter formater = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		DefaultTableModel modelo = new DefaultTableModel();
		String[] titulos = { "Data", "Distância", "Partida", "Destino", "ID", "Status", "Usuário" };
		for (int i = 0; i < titulos.length; i++) {
			modelo.addColumn(titulos[i]);
		}

		Object[] linha = new Object[7];
		linha[0] = formater.format(corrida.getData());
		linha[1] = corrida.getDistancia();
		linha[2] = corrida.getEnderecoDePartida();
		linha[3] = corrida.getEnderecoDeDestino();
		linha[4] = corrida.getId();
		linha[5] = corrida.getStatus();
		linha[6] = corrida.getUsuario();

		modelo.addRow(linha);

		JTable tabela = new JTable(modelo);
		JScrollPane painelTabela = new JScrollPane(tabela);
		painelTabela.setBounds(20, 30, 545, 39);

		add(detalhes);
		add(painelTabela);
	}

	private void addBotoes() {
		if (usuario.getTipoDeConta() == TipoDeConta.PASSAGEIRO) {
			JButton avaliarCorrida = new JButton("Avaliar corrida");
			avaliarCorrida.setBounds(229, 75, 130, 40);
			avaliarCorrida.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					new JanelaDeAvaliacao(corrida, usuario);

				}
			});

			add(avaliarCorrida);
		}
	}

}
