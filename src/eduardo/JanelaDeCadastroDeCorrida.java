package eduardo;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.time.LocalDate;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import ListaDeAquecimento.CentralDeInformacoes;
import ListaDeAquecimento.Corrida;
import ListaDeAquecimento.Passageiro;
import ListaDeAquecimento.Persistencia;
import clebson.JanelaPadrao;

public class JanelaDeCadastroDeCorrida extends JanelaPadrao{
	CentralDeInformacoes central;
	Persistencia persistencia;
	Passageiro passageiro;
	
	JTextField inputEnderecoPartida;
	JTextField inputEnderecoDestino;
	JFormattedTextField inputDistancia;
	JFormattedTextField inputDataDaCorrida;
	JCheckBox checkBCorridaParaAgora;
	
	public JanelaDeCadastroDeCorrida(CentralDeInformacoes c, Persistencia per, Passageiro p) {
		super("Cadastrar Solicitação de Corrida");
		this.adicionarBotoes();
		this.adicionarTextos();
		this.setSize(500, 320);
		central = c;
		passageiro = p;
		persistencia = per;
		this.setVisible(true);
	}
	public void adicionarBotoes() {
		JButton botaoConfirmar = new JButton("Confirmar");
		botaoConfirmar.setBounds(360, 240, 100, 30);
		botaoConfirmar.addActionListener(new OuvinteDoBotaoConfirmarCadastroCorrida(this));
		this.add(botaoConfirmar);
		JButton botaoCancelar = new JButton("Cancelar");
		botaoCancelar.setBounds(255, 240, 100, 30);
		botaoCancelar.addActionListener(new OuvinteBotaoCancelar(this));
		this.add(botaoCancelar);
	}
	private class OuvinteDoBotaoConfirmarCadastroCorrida implements ActionListener{
		private JanelaDeCadastroDeCorrida janela;
		public OuvinteDoBotaoConfirmarCadastroCorrida(JanelaDeCadastroDeCorrida j) {
			janela = j;
		}
			public void actionPerformed(ActionEvent e) {
				if(!(inputEnderecoPartida.getText().equals("") || inputEnderecoDestino.getText().equals("") || inputDistancia.getText().equals(""))) {
					LocalDate dataDaCorrida = null;
					
					if(!checkBCorridaParaAgora.isSelected()) {
						String[] datas = inputDataDaCorrida.getText().split("/");
						dataDaCorrida = LocalDate.of(Integer.parseInt(datas[2]), 
								Integer.parseInt(datas[1]), 
								Integer.parseInt(datas[0]));
					} else {
						dataDaCorrida = LocalDate.now();
					}
					Corrida c = new Corrida(inputEnderecoPartida.getText(), 
							inputEnderecoDestino.getText(), 
							Float.parseFloat(inputDistancia.getText()), 
							checkBCorridaParaAgora.isSelected(), 
							dataDaCorrida, 
							passageiro);
					central.adicionarCorrida(c);
					
					try {
						persistencia.salvar(central, "dados-passageiros.xml");
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					JOptionPane.showMessageDialog(janela, "Corrida adicionada com Sucesso!");
					janela.dispose();
				} else {
					JOptionPane.showMessageDialog(janela, "Preencha os campos corretamente", "ERRO!", JOptionPane.ERROR_MESSAGE);
				}
			}
	}
	public void adicionarTextos() {
		JLabel txTitulo = new JLabel("Cadastrar Solicitação de Corrida");
		txTitulo.setBounds(90, 20, 400, 30);
		Font i = new Font ("Arial", Font.BOLD, 20);
		txTitulo.setFont(i);
		
		JLabel txEnderecoPartida = new JLabel("Endereço de Partida:");
		txEnderecoPartida.setBounds(30, 60, 134, 20);
		inputEnderecoPartida = new JTextField();
		inputEnderecoPartida.setBounds(30, 80, 428, 30);
		
		
		JLabel txEnderecoDestino = new JLabel("Endereço de Destino:");
		txEnderecoDestino.setBounds(30, 115, 134, 20);
		inputEnderecoDestino = new JTextField();
		inputEnderecoDestino.setBounds(30, 140, 428, 30);
		
		JLabel txDistancia = new JLabel("Distancia (0000.00 Km):");
		txDistancia.setBounds(30, 170, 134, 20);
		try {
			inputDistancia = new JFormattedTextField(new MaskFormatter("####.##"));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		inputDistancia.addKeyListener(new OuvinteDoTecladoParaApenasNumerico());
		inputDistancia.setBounds(30, 190, 134, 30);
		
		JLabel txDataDaCorrida = new JLabel("Data da Corrida: ");
		MaskFormatter msk = null;
		txDataDaCorrida.setBounds(175, 166, 100, 30);
		try {
			msk = new MaskFormatter("##/##/####");
		} catch (ParseException e) {}
		inputDataDaCorrida = new JFormattedTextField(msk);
		inputDataDaCorrida.setHorizontalAlignment(JTextField.CENTER);
		inputDataDaCorrida.setBounds(175, 192, 70, 30);
		
		checkBCorridaParaAgora = new JCheckBox("Corrida para agora!", false);
		checkBCorridaParaAgora.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(checkBCorridaParaAgora.isSelected()) {
					inputDataDaCorrida.setEnabled(false);
				} else {
					inputDataDaCorrida.setEnabled(true);
				}
			}
			
		});
		checkBCorridaParaAgora.setBounds(275, 187, 170, 30);
		
		this.add(txTitulo);
		this.add(txDistancia);
		this.add(txEnderecoDestino);
		this.add(txEnderecoPartida);
		this.add(txDataDaCorrida);
		this.add(inputDataDaCorrida);
		this.add(inputDistancia);
		this.add(inputEnderecoDestino);
		this.add(inputEnderecoPartida);
		this.add(checkBCorridaParaAgora);
	}
}
