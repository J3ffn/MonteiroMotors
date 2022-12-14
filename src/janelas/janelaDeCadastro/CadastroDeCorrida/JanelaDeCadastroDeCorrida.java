package janelas.janelaDeCadastro.CadastroDeCorrida;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.time.LocalDateTime;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import janelas.janelasCentrais.JanelaPassageiro;
import janelas.janelasDeUsuários.JanelaPadraoUsuario;
import ouvintes.botaoVoltar.OuvinteBotaoCancelar;
import ouvintes.listagemDeCorridas.OuvinteDoTecladoParaApenasNumerico;
import sistemas.Corridas.Corrida;
import sistemas.GestãoDeInformacoes.Persistencia;
import sistemas.Usuários.Passageiro;
import sistemas.Usuários.Usuario;
import sistemas.janela.JanelaPadrao;

public class JanelaDeCadastroDeCorrida extends JanelaPadrao {

	private JTextField inputEnderecoPartida;
	private JTextField inputEnderecoDestino;
	private JFormattedTextField inputDistancia;
	private JFormattedTextField inputDataDaCorrida;
	private JFormattedTextField inputHoraDaCorrida;
	private JCheckBox checkBCorridaParaAgora;
	private Passageiro passageiro;

	public JanelaDeCadastroDeCorrida(JFrame telaAnterior, Usuario p) {
		super("Cadastrar Solicitação de Corrida", p);
		passageiro = (Passageiro)p;
		this.adicionarBotoes(telaAnterior, p);
		this.adicionarTextos();
		this.setSize(500, 320);
		this.setVisible(true);
	}

	public void adicionarBotoes(JFrame telaAnterior, Usuario u) {
		JButton botaoConfirmar = new JButton("Confirmar");
		botaoConfirmar.setBounds(360, 240, 100, 30);
		botaoConfirmar.addActionListener(new OuvinteDoBotaoConfirmarCadastroCorrida(telaAnterior, this));
		this.add(botaoConfirmar);
		JButton botaoCancelar = new JButton("Cancelar");
		botaoCancelar.setBounds(255, 240, 100, 30);
		botaoCancelar.addActionListener(new OuvinteBotaoCancelar(telaAnterior, this));
		this.add(botaoCancelar);
	}

	private class OuvinteDoBotaoConfirmarCadastroCorrida implements ActionListener {
		private JanelaDeCadastroDeCorrida janela;
		private JFrame janelaAnterior;
		
		public OuvinteDoBotaoConfirmarCadastroCorrida(JFrame janelaAnterior, JanelaDeCadastroDeCorrida j) {
			janela = j;
			this.janelaAnterior = janelaAnterior;
		}

		public void actionPerformed(ActionEvent e) {
			LocalDateTime agora = LocalDateTime.now();
			LocalDateTime agoraM = agora.minusMinutes(20);
			if (!(inputEnderecoPartida.getText().equals("") || inputEnderecoDestino.getText().equals("")
					|| inputDistancia.getText().equals("    . ") || inputDistancia.getText().equals("0000.0"))) {
				LocalDateTime dataDaCorrida = null;
				if (!checkBCorridaParaAgora.isSelected()) {
					String[] datas = inputDataDaCorrida.getText().split("/");
					String[] hora = inputHoraDaCorrida.getText().split(":");
					dataDaCorrida = LocalDateTime.of(Integer.parseInt(datas[2]), Integer.parseInt(datas[1]),
							Integer.parseInt(datas[0]), Integer.parseInt(hora[0]), Integer.parseInt(hora[1]));

				} else {
					dataDaCorrida = agora;
				}
				if (dataDaCorrida.isAfter(agoraM)) {
					Corrida c = new Corrida(inputEnderecoPartida.getText(), inputEnderecoDestino.getText(),
							Float.parseFloat(inputDistancia.getText()), checkBCorridaParaAgora.isSelected(),
							dataDaCorrida, getUsuario(), null);
					getCentral().adicionarCorrida(c);

					try {
						new Persistencia().salvar(getCentral(), "dados-passageiros.xml");
					} catch (Exception e1) {
						e1.printStackTrace();
					}

					JOptionPane.showMessageDialog(janela, "Corrida adicionada com Sucesso!");
					dispose();
					new JanelaPassageiro(passageiro);
					
				} else {
					JOptionPane.showMessageDialog(janela, "Agende a corrida para agora ou para uma data futura!",
							"ERRO!", JOptionPane.ERROR_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(janela, "Preencha os campos corretamente", "ERRO!",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	public void adicionarTextos() {
		JLabel txTitulo = new JLabel("Cadastrar Solicitação de Corrida");
		txTitulo.setBounds(90, 20, 400, 30);
		Font i = new Font("Arial", Font.BOLD, 20);
		txTitulo.setFont(i);

		JLabel txEnderecoPartida = new JLabel("Endereço de Partida:");
		txEnderecoPartida.setBounds(30, 60, 134, 20);
		inputEnderecoPartida = new JTextField();
		inputEnderecoPartida.setBounds(30, 80, 428, 30);

		JLabel txEnderecoDestino = new JLabel("Endereço de Destino:");
		txEnderecoDestino.setBounds(30, 115, 134, 20);
		inputEnderecoDestino = new JTextField();
		inputEnderecoDestino.setBounds(30, 140, 428, 30);

		JLabel txDistancia = new JLabel("Distancia (0000.0 Km):");
		txDistancia.setBounds(30, 170, 134, 20);
		try {
			inputDistancia = new JFormattedTextField(new MaskFormatter("####.#"));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		inputDistancia.addKeyListener(new OuvinteDoTecladoParaApenasNumerico());
		inputDistancia.setBounds(30, 190, 134, 30);

		JLabel txDataDaCorrida = new JLabel("Data da Corrida: ");
		MaskFormatter msk = null;
		txDataDaCorrida.setBounds(175, 166, 100, 30);
		try {
			msk = new MaskFormatter("##/##/####");
		} catch (ParseException e) {
		}
		inputDataDaCorrida = new JFormattedTextField(msk);
		inputDataDaCorrida.setHorizontalAlignment(JTextField.CENTER);
		inputDataDaCorrida.setBounds(175, 192, 100, 30);

		JLabel txHoraDaCorrida = new JLabel("Hora da Corrida: ");
		MaskFormatter msk1 = null;
		txHoraDaCorrida.setBounds(285, 166, 100, 30);

		try {
			msk1 = new MaskFormatter("##:##");
		} catch (ParseException e) {
		}
		inputHoraDaCorrida = new JFormattedTextField(msk1);
		inputHoraDaCorrida.setHorizontalAlignment(JTextField.CENTER);
		inputHoraDaCorrida.setBounds(285, 192, 100, 30);

		checkBCorridaParaAgora = new JCheckBox("Corrida para agora!", false);
		checkBCorridaParaAgora.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (checkBCorridaParaAgora.isSelected()) {
					inputDataDaCorrida.setEnabled(false);
					inputHoraDaCorrida.setEnabled(false);
				} else {
					inputDataDaCorrida.setEnabled(true);
					inputHoraDaCorrida.setEnabled(true);
				}
			}

		});
		checkBCorridaParaAgora.setBounds(30, 222, 170, 30);

		this.add(txTitulo);
		this.add(txDistancia);
		this.add(txEnderecoDestino);
		this.add(txEnderecoPartida);
		this.add(txDataDaCorrida);
		this.add(txHoraDaCorrida);
		this.add(inputDataDaCorrida);
		this.add(inputHoraDaCorrida);
		this.add(inputDistancia);
		this.add(inputEnderecoDestino);
		this.add(inputEnderecoPartida);
		this.add(checkBCorridaParaAgora);
	}
}
