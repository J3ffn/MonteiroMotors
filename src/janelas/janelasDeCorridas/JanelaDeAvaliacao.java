package janelas.janelasDeCorridas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

import sistemas.Corridas.Avaliacao;
import sistemas.Corridas.Corrida;
import sistemas.Usuários.Usuario;

public class JanelaDeAvaliacao extends JanelaDeDetalhesDeUmaCorrida {

	private Corrida corrida = getCorrida();
	private Usuario usuario = getUsuario();

	private ButtonGroup bg;

	JRadioButton avaliacao1;
	JRadioButton avaliacao2;
	JRadioButton avaliacao3;
	JRadioButton avaliacao4;
	JRadioButton avaliacao5;

	public JanelaDeAvaliacao(Corrida corrida, Usuario usuario) {
		super(corrida, usuario, 2);

		addRadioButton();
		addBotao();
		addCampoComentario();

		setSize(298, 262);
		setVisible(true);
	}

	public void addRadioButton() {
		JLabel subTexto = new JLabel("SUA AVALIAÇÃO:");
		subTexto.setBounds(30, 5, 100, 30);

		avaliacao1 = new JRadioButton("1", false);
		avaliacao1.setBounds(39, 25, 35, 30);

		avaliacao2 = new JRadioButton("2", false);
		avaliacao2.setBounds(79, 25, 35, 30);

		avaliacao3 = new JRadioButton("3", false);
		avaliacao3.setBounds(119, 25, 35, 30);

		avaliacao4 = new JRadioButton("4", false);
		avaliacao4.setBounds(159, 25, 35, 30);

		avaliacao5 = new JRadioButton("5", false);
		avaliacao5.setBounds(199, 25, 35, 30);

		bg = new ButtonGroup();
		bg.add(avaliacao1);
		bg.add(avaliacao2);
		bg.add(avaliacao3);
		bg.add(avaliacao4);
		bg.add(avaliacao5);

		add(subTexto);
		add(avaliacao1);
		add(avaliacao2);
		add(avaliacao3);
		add(avaliacao4);
		add(avaliacao5);
	}

	private JRadioButton verificarBotaoSelecionado() {
		JRadioButton[] botoes = { avaliacao1, avaliacao2, avaliacao3, avaliacao4, avaliacao5 };
		for (JRadioButton c : botoes) {
			if (c.isSelected()) {
				return c;
			}
		}
		return null;
	}

	public void addCampoComentario() {
		JLabel subTexto = new JLabel("COMENTARIO:");
		subTexto.setBounds(30, 60, 100, 40);

		JTextArea campoTexto = new JTextArea();
		campoTexto.setBounds(30, 90, 225, 60);

		add(subTexto);
		add(campoTexto);
	}

	public void addBotao() {
		JButton botaoAvaliar = new JButton("Avaliar");
		botaoAvaliar.setBounds(85, 165, 110, 40);

		botaoAvaliar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (verificarBotaoSelecionado() != null) {
					int numeroBotao = Integer.parseInt(verificarBotaoSelecionado().getText());

					new Avaliacao(corrida, usuario, corrida.getMototaxista(), numeroBotao, getName());
					dispose();
				} else {
					JOptionPane.showMessageDialog(null, "Escolha uma das opções");
				}

			}
		});

		add(botaoAvaliar);
	}
}
