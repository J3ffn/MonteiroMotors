package eduardo.Janelas;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import ListaDeAquecimento.Administrador;
import ListaDeAquecimento.Usuario;
import clebson.JanelaPadrao;

import eduardo.JanelaCorridasDisponiveis.Painel;
import eduardo.Ouvintes.OuvinteBotaoCancelar;

public class JanelaDeListagemDeUsuarios extends JanelaPadrao {
	private JScrollPane painel;
	private Painel painel1;
	private JComboBox < String > filtro;
	private JButton btAtualizar;
	private ArrayList <Usuario> usuariosQueVaoAparecer;
	
	public JanelaDeListagemDeUsuarios(Administrador u) {
		super("Janela de Listagem de Usuarios", u);
		usuariosQueVaoAparecer = getCentral().getTodosOsUsuarios();
		adicionarBotoes();
		adicionarPainel();
		this.setVisible(true);
	}
	public void adicionarBotoes() {
		String[] opcoes = {"Todos", "Mototaxistas", "Passageiros"};
		
		JLabel texto = new JLabel("Lista de Usuarios");
		texto.setBounds(20, 40, 440, 20);
		texto.setBackground(Color.GRAY);
		texto.setOpaque(true);
		texto.setHorizontalAlignment(JLabel.CENTER);
		this.add(texto);
		
		JButton b = new JButton("< Voltar");
		b.setBounds(5, 5, 80, 20);
		b.addActionListener(new OuvinteBotaoCancelar(this));
		this.add(b);
		
		
		filtro = new JComboBox < String >(opcoes);
		filtro.setBounds(350, 5, 110, 20);
		this.add(filtro);
		
		btAtualizar = new JButton("Atualize!");
		btAtualizar.setBounds(90, 5, 100, 20);
		btAtualizar.addMouseListener(new OuvinteDoAtualizar(this));
		this.add(btAtualizar);
		
	}
	public void adicionarPainel() {
		
		painel1 = new PainelListaUsuarios((Administrador) getUsuario(), usuariosQueVaoAparecer);
		painel = new JScrollPane(painel1);
		
		painel.setBounds(20, 60, 440, 340);
		
		this.add(painel);
	}
	private class OuvinteDoAtualizar implements MouseListener{
		JanelaDeListagemDeUsuarios janela;
		
		public OuvinteDoAtualizar(JanelaDeListagemDeUsuarios j) {
			janela = j;
		}
		public void mouseClicked(MouseEvent e) {
			if(filtro.getSelectedItem().equals("Mototaxistas")) {
				usuariosQueVaoAparecer = getCentral().getTodosOsMototaxistas();
			} else if(filtro.getSelectedItem().equals("Passageiros")) {
				usuariosQueVaoAparecer = getCentral().getTodosOsPassageiros();
			} else if(filtro.getSelectedItem().equals("Todos")) {
				usuariosQueVaoAparecer = getCentral().getTodosOsUsuarios();
			}
			JButton botao = (JButton) e.getSource();
			botao.setText("Atualizar!");
			botao.transferFocus();
			janela.remove(painel);
			adicionarPainel();
			janela.repaint();
		}
		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		public JScrollPane getPainel() {
			return painel;
		}
	}
}
