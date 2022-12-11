
package eduardo.Janelas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import ListaDeAquecimento.Mototaxista;
import ListaDeAquecimento.Persistencia;
import clebson.JanelaPadrao;
import eduardo.Ouvintes.OuvinteBotaoCancelar;
import eduardo.Ouvintes.OuvinteDoTecladoParaApenasNumerico;

public class JanelaDeCompraDeCreditos extends JanelaPadrao {
	private JTextField inputQuant;
	
	public JanelaDeCompraDeCreditos(Mototaxista mtx) {
		super("Janela de Compra de Créditos", mtx);
		this.adicionarBotoes();
		this.adicionarTextos();
		this.setSize(300, 200);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	private void adicionarTextos() {
		JLabel txQuantidade = new JLabel("Insira a quantidade:");
		txQuantidade.setBounds(30, 30, 150, 20);
		this.add(txQuantidade);
		
		inputQuant = new JTextField();
		inputQuant.setBounds(30, 50, 230, 30);
		inputQuant.addKeyListener(new OuvinteDoTecladoParaApenasNumerico());
		this.add(inputQuant);
		
	}

	private void adicionarBotoes() {
		JButton botaoComprar = new JButton("Comprar");
		botaoComprar.setBounds(145, 100, 100, 30);
		botaoComprar.addActionListener(new OuvinteDoBotaoConfirmar(this));
		this.add(botaoComprar);
		
		JButton botaoCancelar = new JButton("Cancelar");
		botaoCancelar.setBounds(40, 100, 100, 30);
		botaoCancelar.addActionListener(new OuvinteBotaoCancelar(this));
		this.add(botaoCancelar);
	}
	private class OuvinteDoBotaoConfirmar implements ActionListener{
		JanelaDeCompraDeCreditos janela;
		public OuvinteDoBotaoConfirmar(JanelaDeCompraDeCreditos janela) {
			this.janela = janela;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			Mototaxista mtx = (Mototaxista) janela.getUsuario();
			try {
				float valor = mtx.adicionarCreditos(Integer.parseInt(inputQuant.getText()), janela.getCentral());
				
				//Enviar nota fiscal++++++++++++++++++++++++++++++++++++++++++++++++++++++
				
				//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
				
				JOptionPane.showMessageDialog(janela, "A nota fiscal foi enviada para o seu email!\nValor da compra: R$ " + valor, "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
				
				try {
					new Persistencia().salvar(getCentral(), "dados-passageiros.xml");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				janela.dispose();
			} catch (AdicaoInvalidaException erro) {
				JOptionPane.showMessageDialog(janela, "Erro! Compra Inválida!", "Erro!", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}