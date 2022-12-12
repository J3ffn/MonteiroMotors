package clebson;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import ListaDeAquecimento.TipoDeConta;
import ListaDeAquecimento.Usuario;

@SuppressWarnings("serial")
public class JanelaMudancaTipo extends JFrame{
	private Usuario usuario;
	private JComboBox<TipoDeConta> tipos = new JComboBox<TipoDeConta>();
	public JComboBox<TipoDeConta> getTipos() {
		return tipos;
	}
	
	public JanelaMudancaTipo(Usuario usuario) {
		this.usuario = usuario;
		setTitle("Mudança de Tipo");
		setSize(350, 200);
		setResizable(false);
		setLocationRelativeTo(null);				
		setLayout(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		adicionarBotaoConfirma();
		adicionarCombo();
		setVisible(true);
	}
	private void adicionarCombo() {
		tipos.setBounds(30, 55, 150, 50);
		tipos.addItem(TipoDeConta.ADMINISTRADOR);
		tipos.addItem(TipoDeConta.MOTOTAXISTA);
		tipos.addItem(TipoDeConta.PASSAGEIRO);
		add(tipos);		
	}

	private void adicionarBotaoConfirma() {
		
		JButton confirmar = new JButton("Confirmar");
		confirmar.setBounds(200, 55, 100, 50);
		confirmar.setFont(new Font("Tahoma",Font.BOLD,12));
		add(confirmar);
		OuvinteBotaoConfirmar ouvinteConfirmar = new OuvinteBotaoConfirmar(this);
		confirmar.addActionListener(ouvinteConfirmar);	
		
	}
	private class OuvinteBotaoConfirmar implements ActionListener{
		private JFrame janela;
		public OuvinteBotaoConfirmar(JFrame janela) {
			this.janela = janela;

		}
		@Override
		public void actionPerformed(ActionEvent e) {
			String tipo = (String) tipos.getSelectedItem();
			switch(tipo) {
			case("ADMINISTRADOR"):
				usuario.setSexo();
			}
			janela.dispose();
		}
	}
	

		

	
}
