package janelas.janelasAdministrativas;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;

import ouvintes.botaoVoltar.OuvinteBotaoCancelar;
import sistemas.GestãoDeInformacoes.Persistencia;
import sistemas.Usuários.Administrador;
import sistemas.Usuários.Usuario;
import sistemas.janela.JanelaPadrao;

public class JanelaDeDefinicaoDeValorDosCreditos extends JanelaPadrao {

	private JFormattedTextField inputValorCreditos;
	private JButton btConfirmar;

	public JanelaDeDefinicaoDeValorDosCreditos(JFrame janelaAnterior, Administrador adm) {
		super("Definir Valor Dos Creditos", adm);
		this.setSize(500, 300);
		this.setLocationRelativeTo(null);
		this.adicionarCamposTexto();
		this.adicionarBotoes(janelaAnterior, adm);
		this.setVisible(true);
	}

	public void adicionarCamposTexto() {
		JLabel titulo1 = new JLabel("Definir valor dos créditos de reivindicação");
		titulo1.setFont(new Font("Arial", Font.BOLD, 15));
		titulo1.setBounds(90, 20, 350, 50);

		JLabel txtNovoValor = new JLabel("Novo Valor:");
		txtNovoValor.setBounds(70, 100, 100, 20);

		JLabel txtValorAtual = new JLabel(
				"Valor atual: R$ " + ((Administrador) this.getUsuario()).getValorDosCreditos());
		txtValorAtual.setBounds(200, 5, 150, 20);

		try {
			MaskFormatter msk = new MaskFormatter("R$ ##.##");
			inputValorCreditos = new JFormattedTextField(msk);
			inputValorCreditos.setBounds(70, 120, 350, 30);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		this.add(titulo1);
		this.add(txtNovoValor);
		this.add(txtValorAtual);
		this.add(inputValorCreditos);
	}

	public void adicionarBotoes(JFrame janelaAnterior, Usuario usuario) {
		btConfirmar = new JButton("Confirmar");
		btConfirmar.setBounds(365, 220, 100, 30);
		btConfirmar.addActionListener(new OuvinteDoBotaoConfirmar(this));

		JButton btCancelar = new JButton("Cancelar");
		btCancelar.setBounds(260, 220, 100, 30);
		btCancelar.addActionListener(new OuvinteBotaoCancelar(janelaAnterior, this));

		this.add(btConfirmar);
		this.add(btCancelar);
	}

	private class OuvinteDoBotaoConfirmar implements ActionListener {
		JanelaDeDefinicaoDeValorDosCreditos janela;

		public OuvinteDoBotaoConfirmar(JanelaDeDefinicaoDeValorDosCreditos j) {
			janela = j;
		}

		public void actionPerformed(ActionEvent e) {
			if (!inputValorCreditos.getText().equals("R$   .  ")) {
				String v = inputValorCreditos.getText().substring(3);
				if (JOptionPane.showConfirmDialog(janela,
						"Deseja alterar o valor dos creditos para R$ " + v + " ?") == 0) {
					Administrador administrador = (Administrador) janela.getUsuario();
					try {
						administrador.atualizarValorDosCreditos(Float.parseFloat(v));
						JOptionPane.showMessageDialog(janela, "Valor atualizado!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
						
						getCentral().atualizarCentral(administrador);
						new Persistencia().salvar(getCentral(), "dados-passageiros.xml");
					} catch (Exception e1) {
						
					}
				}
				janela.dispose();
			} else {
				JOptionPane.showMessageDialog(janela, "Insira um Valor!", "Erro!", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

}
