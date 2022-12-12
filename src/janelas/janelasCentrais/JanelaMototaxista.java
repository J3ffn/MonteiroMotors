package janelas.janelasCentrais;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import janelas.janelaDeAdicionarCreditos.JanelaDeAdicionarCreditos;
import janelas.janelasDeCorridas.JanelaDeChamadasDeCorridas;
import janelas.janelasDeUsuários.JanelaPadraoUsuario;
import ouvintes.listagemDeCorridas.OuvinteBotaoListarCorridas;
import sistemas.Usuários.Mototaxista;

@SuppressWarnings("serial")
public class JanelaMototaxista extends JanelaPadraoUsuario {

	private int qtddDeCretidos;
	private Mototaxista mototaxista;

	public JanelaMototaxista(Mototaxista mtx) {
		super("Mototaxista", mtx);
		qtddDeCretidos = mtx.getCreditos().size();

		adicionarTextosDeCredito();
		adicionarBotoesMototaxista(mtx);

		setVisible(true);
	}

	private void adicionarTextosDeCredito() {
		JLabel lbCreditos = new JLabel("Créditos: ");
		lbCreditos.setBounds(340, 10, 60, 20);
		lbCreditos.setFont(new Font("Arial", Font.BOLD, 12));
		add(lbCreditos);

		ImageIcon moeda = new ImageIcon("icones/Coin (1).png");
		JLabel lbMoeda = new JLabel(qtddDeCretidos + "", moeda, JLabel.CENTER);
		lbMoeda.setBounds(370, 10, 100, 20);
		lbMoeda.setFont(new Font("Arial", Font.BOLD, 12));
		add(lbMoeda);

	}

	private class OuvinteBotaoChamadas implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			dispose();
			new JanelaDeChamadasDeCorridas(getUsuario());
		}
	}

	private void adicionarBotoesMototaxista(Mototaxista mtx) {
		super.adicionarBotoes();

		JButton btListarCorridas = new JButton();
		btListarCorridas.setBounds(170, 121, 130, 40);
		btListarCorridas.setText("Listar Corridas");
		btListarCorridas.setFont(new Font("Tahoma", Font.BOLD, 10));
		btListarCorridas.addActionListener(new OuvinteBotaoListarCorridas(getUsuario(), this));
		add(btListarCorridas);

		JButton btChamadas = new JButton();
		btChamadas.setBounds(170, 181, 130, 60);
		btChamadas.setText("Chamadas para corridas");
		btChamadas.addActionListener(new OuvinteBotaoChamadas());
		btChamadas.setFont(new Font("Tahoma", Font.BOLD, 8));
		add(btChamadas);

		ImageIcon icone = new ImageIcon("icones/+.png");
		JButton adicionarCredito = new JButton(icone);
		adicionarCredito.setFont(new Font("ARIAL", Font.BOLD, 12));
		adicionarCredito.setFocusable(false);
		adicionarCredito.setOpaque(true);
		adicionarCredito.setBorderPainted(false);
		adicionarCredito.setBounds(450, 10, 25, 20);

		adicionarCredito.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new JanelaDeAdicionarCreditos(mtx, getCentral());
			}
		});

		add(adicionarCredito);
	}

}
