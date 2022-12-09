package clebson;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class JanelaEditarPerfilAdmin extends JanelaEditarPerfil{
	
	public JanelaEditarPerfilAdmin() {

		adicionarTextos();
		adicionarBotoes();
		
		setVisible(true);
	}
	
public class OuvinteBotaoEditarTipo implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			String tipo = JOptionPane.showInputDialog("Digite o novo Tipo de usuario: ");
			JOptionPane.showMessageDialog(null, "Mudança Concluida");
			JLabel LbTipo = new JLabel (tipo);
			setLbTipoDeUsuario(LbTipo);
		}
	}
OuvinteBotaoEditarTipo ouvinteEditarTipo = new OuvinteBotaoEditarTipo();

	
	public void adicionarBotoes() {
		super.adicionarBotoes();
		
		JButton btEditarTipo = new JButton();
		btEditarTipo.setBounds(350, 240, 100, 20);
		btEditarTipo.setText("Editar Tipo");
		btEditarTipo.setFont(new Font("Tahoma",Font.BOLD,10));
		btEditarTipo.addActionListener(ouvinteEditarTipo);
		add (btEditarTipo);
	}
}
