package eduardo;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import ListaDeAquecimento.CentralDeInformacoes;
import ListaDeAquecimento.Corrida;
import ListaDeAquecimento.MotoTaxistaSemCreditosCreditosException;
import ListaDeAquecimento.Mototaxista;

public class JanelaDeReividicacaoDeCorrida extends JFrame{
	JButton btConfirmar;
	JButton btCancelar;
	CentralDeInformacoes central;
	Corrida corrida;
	Mototaxista mototaxista;
	
	public JanelaDeReividicacaoDeCorrida(CentralDeInformacoes cen, Corrida c, Mototaxista m) {
		this.central = cen;
		this.mototaxista = m;
		this.setTitle("Reividicar Corrida");
		this.setSize(400, 177);
		setResizable(false);
		setLocationRelativeTo(null);				
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		corrida = c;
		this.adicionarLabels();
		this.adicionarBotoes();
		this.setVisible(true);
	}
	public void adicionarBotoes() {
		btConfirmar = new JButton("Confirmar");
		btConfirmar.setBounds(207, 103, 111, 30);
		btConfirmar.addActionListener(new OuvinteDosBotoesJanelaRegistro(this));
		this.add(btConfirmar);
		
		btCancelar = new JButton("Cancelar");
		btCancelar.setBounds(91, 103, 111, 30);
		btCancelar.addActionListener(new OuvinteDosBotoesJanelaRegistro(this));
		this.add(btCancelar);
	}
	private class OuvinteDosBotoesJanelaRegistro implements ActionListener{
		JanelaDeReividicacaoDeCorrida janela;
		
		public OuvinteDosBotoesJanelaRegistro(JanelaDeReividicacaoDeCorrida j) {
			janela = j;
		}
		
		public void actionPerformed(ActionEvent e) {
			if(e.getActionCommand().equals("Confirmar")) {
			int esc = JOptionPane.showConfirmDialog(janela, "Deseja reivindicar essa corrida?");
			if(esc == 0) {
				try {
					mototaxista.reinvidicarCorrida(corrida);
					janela.dispose();
					JanelaDeReividicacaoDeCorrida janela3 = new JanelaDeReividicacaoDeCorrida(central, corrida, mototaxista);
				} catch (MotoTaxistaSemCreditosCreditosException erro) {
					JOptionPane.showMessageDialog(janela, erro.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
				}
			}
			} else {
				janela.dispose();
			}
		}
	}
	public void adicionarLabels() {
		JLabel txPassageiro = new JLabel("Passageiro: " + corrida.getUsuario().toString());
		txPassageiro.setBounds(100, 12, 200, 30);
		txPassageiro.setFont(new Font("Arial", Font.BOLD, 15));
		txPassageiro.setHorizontalAlignment(JLabel.CENTER);
		this.add(txPassageiro);
		
		JLabel txLocaldePartida = new JLabel(String.format("Local de Partida: %s", corrida.getEnderecoDePartida()));
		txLocaldePartida.setBounds(65, 40, 360, 20);
		this.add(txLocaldePartida);
		
		JLabel txLocaldeDestino = new JLabel(String.format("Local de Destino: %s", corrida.getEnderecoDeDestino()));
		txLocaldeDestino.setBounds(65, 60, 360, 20);
		this.add(txLocaldeDestino);
		
		JLabel txDistancia = new JLabel(String.format("Distancia: %,.2f km", corrida.getDistancia()));
		txDistancia.setBounds(65, 80, 120, 20);
		this.add(txDistancia);
		
		JLabel txData = new JLabel(String.format("Data: %s/%s/%s", corrida.getData().getDayOfMonth(), corrida.getData().getMonthValue(), corrida.getData().getYear()));
		txData.setBounds(240, 80, 120, 20);
		this.add(txData);
		
		ImageIcon i = new ImageIcon("icones/icons8-barato-2-12.png");
		JLabel txCreditos = new JLabel(String.format("Creditos: %s",  mototaxista.getCreditos().size()));
		txCreditos.setIcon(i);
		txCreditos.setBounds(285, 0, 90, 30);
		this.add(txCreditos);
	}
}
