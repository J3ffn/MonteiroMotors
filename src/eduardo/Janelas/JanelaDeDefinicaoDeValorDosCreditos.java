package eduardo.Janelas;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import ListaDeAquecimento.Administrador;
import clebson.JanelaPadrao;
import eduardo.Ouvintes.OuvinteBotaoCancelar;

public class JanelaDeDefinicaoDeValorDosCreditos extends JanelaPadrao{
	
	private JFormattedTextField inputValorCreditos;
	private JButton btConfirmar;
	private Administrador administrador;
	
	public JanelaDeDefinicaoDeValorDosCreditos(Administrador adm) {
		super("Definir Valor Dos Creditos");
		administrador = adm;
		this.setSize(500, 300);
		this.setLocationRelativeTo(null);
		this.adicionarCamposTexto();
		this.adicionarBotoes();
		this.setVisible(true);
	}
	public void adicionarCamposTexto() {
		JLabel titulo1 = new JLabel("Definir valor dos créditos de reivindicação");
		titulo1.setFont(new Font("Arial", Font.BOLD, 15));
		titulo1.setBounds(90, 20, 350, 50);
		
		JLabel txtNovoValor = new JLabel("Novo Valor:");
		txtNovoValor.setBounds(70, 100, 100, 20);
		
		try {
			MaskFormatter msk = new MaskFormatter("R$ ##.##");
			inputValorCreditos = new JFormattedTextField(msk);
			inputValorCreditos.setBounds(70, 120, 350, 30);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		this.add(titulo1);
		this.add(txtNovoValor);
		this.add(inputValorCreditos);
	}
	public void adicionarBotoes() {
		btConfirmar = new JButton("Confirmar");
		btConfirmar.setBounds(365, 220, 100, 30);
		btConfirmar.addActionListener(new OuvinteDoBotaoConfirmar(this));
		
		JButton btCancelar = new JButton("Cancelar");
		btCancelar.setBounds(260, 220, 100, 30);
		btCancelar.addActionListener(new OuvinteBotaoCancelar(this));
		
		this.add(btConfirmar);
		this.add(btCancelar);
	}
	private class OuvinteDoBotaoConfirmar implements ActionListener{
		JanelaDeDefinicaoDeValorDosCreditos janela;
		public OuvinteDoBotaoConfirmar(JanelaDeDefinicaoDeValorDosCreditos j) {
			janela = j;
		}
		public void actionPerformed(ActionEvent e) {
			if(!inputValorCreditos.getText().equals("R$   .  ")){
				String v = inputValorCreditos.getText().substring(3);
				if(JOptionPane.showConfirmDialog(janela, "Deseja alterar o valor dos creditos para R$ " + v + " ?") == 0){
					administrador.atualizarValorDosCreditos(Float.parseFloat(v));
					JOptionPane.showMessageDialog(janela, "Valor atualizado!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
				}
				janela.dispose();
			} else {
				JOptionPane.showMessageDialog(janela, "Insira um Valor!", "Erro!", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

}
