package janelas.janelasCentrais;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import janelas.janelaDeCadastro.CadastroDeCorrida.JanelaDeCadastroDeCorrida;
import janelas.janelasDeUsuários.JanelaPadraoUsuario;
import ouvintes.listagemDeCorridas.OuvinteBotaoListarCorridas;
import sistemas.Usuários.Passageiro;

@SuppressWarnings("serial")
public class JanelaPassageiro extends JanelaPadraoUsuario {

	private JFrame tela = this;

	public JanelaPassageiro(Passageiro p) {
		super("Passageiro", p);
		adicionarBotoesPassageiro();
		setVisible(true);
	}

	private class OuvinteDeBtCadastroCorrida implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			dispose();
			new JanelaDeCadastroDeCorrida(tela, getUsuario());
		}
	}

	private void adicionarBotoesPassageiro() {
		super.adicionarBotoes();

		JButton btCadastroCorrida = new JButton();
		btCadastroCorrida.setBounds(170, 121, 130, 50);
		btCadastroCorrida.setText("Cadastrar Corrida");
		btCadastroCorrida.setFont(new Font("Tahoma", Font.BOLD, 10));
		btCadastroCorrida.addActionListener(new OuvinteDeBtCadastroCorrida());
		add(btCadastroCorrida);

		JButton btListarCorridas = new JButton();
		btListarCorridas.setBounds(170, 191, 130, 30);
		btListarCorridas.setText("Listar Corridas");
		btListarCorridas.addActionListener(new OuvinteBotaoListarCorridas(getUsuario(), this));
		btListarCorridas.setFont(new Font("Tahoma", Font.BOLD, 10));
		add(btListarCorridas);

	}

}
