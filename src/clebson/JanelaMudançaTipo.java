package clebson;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;

import ListaDeAquecimento.TipoDeConta;

@SuppressWarnings("serial")
public class JanelaMudançaTipo extends JFrame{
	
	JComboBox<TipoDeConta> tipos = new JComboBox<TipoDeConta>();

	public JComboBox<TipoDeConta> getTipos() {
		return tipos;
	}

	public JanelaMudançaTipo() {
	// TODO Auto-generated constructor stub
	setTitle("Mudança de Tipo");
	setSize(350, 200);
	setResizable(false);
	setLocationRelativeTo(null);				
	setLayout(null);
	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	adicionarBotoesTipo();
	
	setVisible(true);
}

	public class OuvinteBotaoConfirmar implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			
			
		}
	}
	
	public void adicionarBotoesTipo(){
		JComboBox<TipoDeConta> tipos = new JComboBox<TipoDeConta>();
		tipos.setBounds(30, 55, 150, 50);;
		tipos.addItem(TipoDeConta.ADMINISTRADOR);
		tipos.addItem(TipoDeConta.MOTOTAXISTA);
		tipos.addItem(TipoDeConta.PASSAGEIRO);
		add(tipos);
		
		JButton confirmar = new JButton("Confirmar");
		confirmar.setBounds(200, 55, 100, 50);
		confirmar.setFont(new Font("Tahoma",Font.BOLD,12));
		add(confirmar);
		
	
}
}
