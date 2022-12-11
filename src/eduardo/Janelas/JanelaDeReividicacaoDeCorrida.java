package eduardo.Janelas;

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
import ListaDeAquecimento.Mensageiro;
import ListaDeAquecimento.MotoTaxistaSemCreditosCreditosException;
import ListaDeAquecimento.Mototaxista;
import ListaDeAquecimento.Persistencia;
import ListaDeAquecimento.Status;
import clebson.JanelaPadrao;
import eduardo.Ouvintes.OuvinteBotaoCancelar;

public class JanelaDeReividicacaoDeCorrida extends JanelaPadrao{
	private JLabel txLocaldePartida;
	private JLabel txLocaldeDestino;
	private JLabel txData;
	private JButton btConfirmar;
	private JButton btCancelar;
	private Corrida corrida;
	private JLabel txCreditos;
	
	public JanelaDeReividicacaoDeCorrida(Corrida c, Mototaxista m) {
		super("Reivindicação de corrida", m);
		corrida = c;
		this.setSize(400, 177);
		this.setLocationRelativeTo(null);
		
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
		btCancelar.addActionListener(new OuvinteBotaoCancelar(this));
		this.add(btCancelar);
	}
	private class OuvinteDosBotoesJanelaRegistro implements ActionListener{
		JanelaDeReividicacaoDeCorrida janela;
		
		public OuvinteDosBotoesJanelaRegistro(JanelaDeReividicacaoDeCorrida j) {
			janela = j;
		}
		
		public void actionPerformed(ActionEvent e) {
			Mototaxista m = ((Mototaxista) getUsuario());
			if(e.getActionCommand().equals("Confirmar")) {
			int esc = JOptionPane.showConfirmDialog(janela, "Deseja reivindicar essa corrida?");
			if(esc == 0 && corrida.getStatus() == Status.PENDENTE && m.getCorridaAtual() == null) {
				try {
					m.reinvidicarCorrida(corrida);
					JOptionPane.showMessageDialog(janela, "Corrida Reivindicada!", "Reivindicada!", JOptionPane.INFORMATION_MESSAGE);
					txLocaldePartida.setText(String.format("Local de Partida: %s", corrida.getEnderecoDePartida()));
					txLocaldeDestino.setText(String.format("Local de Destino: %s", corrida.getEnderecoDeDestino()));
					txData.setText(String.format("Data: %s/%s/%s    Hora: %d:%d", corrida.getData().getDayOfMonth(), corrida.getData().getMonthValue(), corrida.getData().getYear(), corrida.getData().getHour(), corrida.getData().getMinute()));
					new Mensageiro().enviarQueCorridaFoiReinvindicada(corrida.getUsuario().getEmail(), corrida, m);
					txCreditos.repaint();
					btConfirmar.setEnabled(false);
					
					try {
						new Persistencia().salvar(getCentral(), "dados-passageiros.xml");
						
					} catch (Exception erro){
						System.out.println("Houve um erro ao salvar os dados!");
					}
					janela.repaint();
				} catch (MotoTaxistaSemCreditosCreditosException erro) {
					JOptionPane.showMessageDialog(janela, erro.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
				}
			} else if(corrida.getStatus() != Status.PENDENTE) {
				JOptionPane.showMessageDialog(janela, "Esta corrida já foi reinvindicada", "Erro!", JOptionPane.ERROR_MESSAGE);
			} else if ( m.getCorridaAtual() != null) {
				JOptionPane.showMessageDialog(janela, "Você não pode reinvindicar mais que uma corrida por vez!", "Erro!", JOptionPane.ERROR_MESSAGE);
			}
			}
		}
	}
	public void adicionarLabels() {
		JLabel txPassageiro = new JLabel("Passageiro: " + corrida.getUsuario().toString());
		txPassageiro.setBounds(100, 12, 200, 30);
		txPassageiro.setFont(new Font("Arial", Font.BOLD, 15));
		txPassageiro.setHorizontalAlignment(JLabel.CENTER);
		this.add(txPassageiro);
		
		txLocaldePartida = new JLabel("Local de Partida: Reivindique a corrida!");
		txLocaldePartida.setBounds(65, 40, 360, 20);
		this.add(txLocaldePartida);
		
		txLocaldeDestino = new JLabel("Local de Destino: Reivindique a corrida!");
		txLocaldeDestino.setBounds(65, 60, 360, 20);
		this.add(txLocaldeDestino);
		
		JLabel txDistancia = new JLabel(String.format("Distancia: %,.2f km", corrida.getDistancia()));
		txDistancia.setBounds(65, 80, 120, 20);
		this.add(txDistancia);
		
		txData = new JLabel(String.format("Data: **/**/****    Hora: **:**"));
		txData.setBounds(180, 80, 200, 20);
		this.add(txData);
		
		ImageIcon i = new ImageIcon("icones/icons8-barato-2-12.png");
		txCreditos = new JLabel(String.format("Creditos: %s",  ((Mototaxista) getUsuario()).getCreditos().size()));
		txCreditos.setIcon(i);
		txCreditos.setBounds(285, 0, 90, 30);
		this.add(txCreditos);
	}
}
