package clebson;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;

import ListaDeAquecimento.TipoDeConta;
import clebsonOuvintesExternos.OuvinteBotaoConfirmaTrocaDeTipo;

@SuppressWarnings("serial")
public class JanelaMudancaTipo extends JFrame{
	
	private JComboBox<TipoDeConta> tipos;

	public JComboBox<TipoDeConta> getTipos() {
		return tipos;
	}

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
		OuvinteBotaoConfirmaTrocaDeTipo ouvinteTrocaPerfil = new OuvinteBotaoConfirmaTrocaDeTipo(this);
		confirmar.addActionListener(ouvinteTrocaPerfil);

		
	
}
}