package janelas.janelasAdministrativas;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import janelas.janelasDeUsuários.JanelaEditarPerfil;
import sistemas.Usuários.Administrador;
import sistemas.Usuários.Usuario;
import sistemas.painel.Painel;

public class PainelListaUsuarios extends Painel {
	ArrayList<Usuario> usuarios;

	public PainelListaUsuarios(JFrame janelaAnterior, Administrador usuario, ArrayList<Usuario> usuarios) {
		super(null, usuario);
		this.usuarios = usuarios;
		preencherPainel(janelaAnterior);
	}

	public void preencherPainel(JFrame janelaAnterior) {

		this.setBackground(Color.WHITE);
		int y = 10;
		this.setLayout(null);

		if (usuarios != null) {
			for (Usuario c : usuarios) {
				JLabel corrida = new JLabel("Usuario: " + c.getNome());
				corrida.setBounds(10, y, 170, 20);

				JButton botao = new JButton("Detalhes");
				botao.setBounds(310, y, 115, 40);
				botao.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						janelaAnterior.setVisible(false);
						new JanelaEditarPerfil(janelaAnterior, c);
					}
				});
				this.add(corrida);
				this.add(botao);
				y += 45;
			}
			if (usuarios.size() > 6) {
				GridLayout layout = new GridLayout(0, 2, 150, 20);
				this.setLayout(layout);
			}
		}
	}

	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(ArrayList<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

}
