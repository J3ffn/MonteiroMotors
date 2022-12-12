package clebson;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;

import ListaDeAquecimento.TipoDeConta;

@SuppressWarnings("serial")
public class JanelaMudancaTipo extends JFrame{
	
	JComboBox<TipoDeConta> tipos = new JComboBox<TipoDeConta>();

	public JanelaMudancaTipo() {
	// TODO Auto-generated constructor stub
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

	public class OuvinteBotaoConfirmar implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
		}
	}
	
	OuvinteBotaoConfirmar ouvinteConfirmar = new OuvinteBotaoConfirmar();
	
	private void adicionarCombo(){
		tipos.setBounds(30, 55, 150, 50);;
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
		confirmar.addActionListener(ouvinteConfirmar);
		
	
}
}