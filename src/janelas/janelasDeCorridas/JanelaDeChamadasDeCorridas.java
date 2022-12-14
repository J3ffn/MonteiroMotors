package janelas.janelasDeCorridas;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import sistemas.Corridas.Corrida;
import sistemas.GestãoDeInformacoes.Persistencia;
import sistemas.Manipuladores.Mensageiro;
import sistemas.Usuários.Mototaxista;
import sistemas.Usuários.Usuario;

public class JanelaDeChamadasDeCorridas extends JanelaDeCorridasDisponiveis {

	public JanelaDeChamadasDeCorridas(Usuario u) {
		super(u);
	}

	public void adicionarPainel() {
		this.setPainel1(new PainelReinvindicacao(this, getCorridasTodasAsDisponiveis(), getUsuario()));
		JButton btConcluir = new JButton("Concluir corrida atual!");
		btConcluir.setBackground(Color.getHSBColor(100 / 360f, 50 / 100f, 80 / 100f));
		btConcluir.setBounds(150, 400, 180, 20);
		btConcluir.addActionListener(new OuvinteConcluirCorrida(this));

		setPainel(new JScrollPane(getPainel1()));

		getPainel().setBounds(20, 60, 440, 340);

		this.add(getPainel());
		this.add(btConcluir);
	}

	private class OuvinteConcluirCorrida implements ActionListener {

		private JanelaDeChamadasDeCorridas janela;

		public OuvinteConcluirCorrida(JanelaDeChamadasDeCorridas janela) {
			this.janela = janela;
		}

		public void actionPerformed(ActionEvent e) {
			Mototaxista m = (Mototaxista) getUsuario();
			if (m.getCorridaAtual() != null) {
				int esc = JOptionPane.showConfirmDialog(janela,
						"Deseja concluir a corrida de id: " + m.getCorridaAtual().getId() + "?");
				if (esc == 0) {
					Corrida c = m.getCorridaAtual();
					m.concluirCorrida(getCentral());
					new Mensageiro().enviarQueCorridaFoiConcluida(c.getUsuario().getEmail(), c);

					JOptionPane.showMessageDialog(janela, "Corrida Concluida!");
					try {
						new Persistencia().salvar(getCentral(), "dados-passageiros.xml");
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			} else {
				JOptionPane.showMessageDialog(janela, "Reinvindique uma corrida primeiro!");
			}
		}

	}
}
