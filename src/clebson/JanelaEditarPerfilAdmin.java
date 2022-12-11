package clebson;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import ListaDeAquecimento.Administrador;

@SuppressWarnings("serial")
public class JanelaEditarPerfilAdmin extends JanelaEditarPerfil{
	
	private JLabel lbTipo;
	
	public JLabel getLbTipo() {
		return lbTipo;
	}


	public void setLbTipo(JLabel lbTipo) {
		this.lbTipo = lbTipo;
	}


	public JanelaEditarPerfilAdmin(Administrador adm) {
		super(adm);
		adicionarTextos(adm);
		adicionarBotoes();
		
		setVisible(true);
	}
	
public class OuvinteBotaoEditarTipo implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			JLabel tipo = getLbTipo();
			String novoTipo = JOptionPane.showInputDialog("Digite o novo tipo:");
			JOptionPane.showMessageDialog(null, "Mudança Concluida");
			if ((novoTipo != null)) {
				lbTipo.setText("TIPO: "+novoTipo);
			}else {
				lbTipo = tipo;
			}

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
