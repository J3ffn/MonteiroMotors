package janelas.janelasAdministrativas;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import janelas.janelasCentrais.JanelaAdministrador;
import sistemas.Usuários.Administrador;
import sistemas.Usuários.Usuario;
import sistemas.janela.JanelaPadrao;
import sistemas.painel.Painel;

public class JanelaDeListagemDeUsuarios extends JanelaPadrao {
	private JScrollPane painel;
	private Painel painel1;
	private JComboBox<String> filtro;
	private JButton btAtualizar;
	private ArrayList<Usuario> usuariosQueVaoAparecer;

	public JanelaDeListagemDeUsuarios(JFrame janelaAnterior, Administrador u) {
		super("Janela de Listagem de Usuarios", u);
		usuariosQueVaoAparecer = getCentral().getTodosOsUsuarios();
		adicionarBotoes(janelaAnterior, u);
		adicionarPainel(janelaAnterior);
		this.setVisible(true);
	}

	public void adicionarBotoes(JFrame janelaAnterior, Administrador adm) {
		String[] opcoes = { "Todos", "Mototaxistas", "Passageiros" };

		JLabel texto = new JLabel("Lista de Usuarios");
		texto.setBounds(20, 40, 440, 20);
		texto.setBackground(Color.GRAY);
		texto.setOpaque(true);
		texto.setHorizontalAlignment(JLabel.CENTER);
		this.add(texto);

		JButton b = new JButton("< Voltar");
		b.setBounds(5, 5, 80, 20);
		b.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new JanelaAdministrador(adm);
			}
		});
		this.add(b);

		filtro = new JComboBox<String>(opcoes);
		filtro.setBounds(350, 5, 110, 20);
		this.add(filtro);

		btAtualizar = new JButton("Atualize!");
		btAtualizar.setBounds(90, 5, 100, 20);
		btAtualizar.addMouseListener(new OuvinteDoAtualizar(janelaAnterior, this));
		this.add(btAtualizar);

	}

	public void adicionarPainel(JFrame janelaAnterior) {

		painel1 = new PainelListaUsuarios(janelaAnterior, (Administrador) getUsuario(), usuariosQueVaoAparecer);
		painel = new JScrollPane(painel1);

		painel.setBounds(20, 60, 440, 340);

		this.add(painel);
	}

	private class OuvinteDoAtualizar extends MouseAdapter {
		JFrame janelaAnterior;
		JanelaDeListagemDeUsuarios janela;

		public OuvinteDoAtualizar(JFrame janelaAnterior, JanelaDeListagemDeUsuarios j) {
			this.janelaAnterior = janelaAnterior;
			janela = j;
		}

		public void mouseClicked(MouseEvent e) {
			if (filtro.getSelectedItem().equals("Mototaxistas")) {
				usuariosQueVaoAparecer = getCentral().getTodosOsMototaxistas();
			} else if (filtro.getSelectedItem().equals("Passageiros")) {
				usuariosQueVaoAparecer = getCentral().getTodosOsPassageiros();
			} else if (filtro.getSelectedItem().equals("Todos")) {
				usuariosQueVaoAparecer = getCentral().getTodosOsUsuarios();
			}
			JButton botao = (JButton) e.getSource();
			botao.setText("Atualizar!");
			botao.transferFocus();
			janela.remove(painel);
			adicionarPainel(janelaAnterior);
			janela.repaint();
		}
	}
}
