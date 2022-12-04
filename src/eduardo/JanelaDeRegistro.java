package eduardo;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import clebson.JanelaPadrao;

public class JanelaDeRegistro extends JanelaPadrao{
	JButton btCriarConta;
	
	public JanelaDeRegistro() {
		super("Registro de Usuário");
		this.adicionarBotoes();
		this.adicionarCaixasDeTexto();
		this.setVisible(true);
	}
	public void adicionarCaixasDeTexto() {
		int x = 124;
		JLabel txNome = new JLabel("NOME COMPLETO:");
		txNome.setBounds(x, 39, 134, 20);
		JTextField inputNome = new JTextField();
		inputNome.setBounds(x, 59, 243, 32);
		
		JLabel txEmail = new JLabel("EMAIL:");
		txEmail.setBounds(x, 98, 134, 20);
		JTextField inputEmail = new JTextField();
		inputEmail.setBounds(x, 121, 243, 32);
		
		JLabel txDataDeNascimento = new JLabel("DATA DE NASCIMENTO(DD/MM/YYYY):");
		txDataDeNascimento.setBounds(x, 166, 250, 20);
		JTextField inputDataDeNascimento = new JTextField();
		inputDataDeNascimento.setBounds(x, 186, 243, 32);
		
		JLabel txSenha = new JLabel("SENHA:");
		txSenha.setBounds(x, 228, 134, 20);
		JTextField inputSenha = new JTextField();
		inputSenha.setBounds(x, 248, 243, 32);
		
		JLabel txConfirmacaoSenha = new JLabel("CONFIRME A SUA SENHA:");
		txConfirmacaoSenha.setBounds(x, 292, 170, 20);
		JTextField inputConfirmacaoSenha = new JTextField();
		inputConfirmacaoSenha.setBounds(x, 312, 243, 32);
		
		this.add(txNome);
		this.add(inputNome);
		
		this.add(txEmail);
		this.add(inputEmail);
		
		this.add(txDataDeNascimento);
		this.add(inputDataDeNascimento);
		
		this.add(txSenha);
		this.add(inputSenha);
		
		this.add(txConfirmacaoSenha);
		this.add(inputConfirmacaoSenha);
	}
	public void adicionarBotoes() {
		//ToDo- Adicionar A Lista de seleção de tipo de usuario em cima do JTExtField de nome.
		
		btCriarConta = new JButton("Criar Conta");
		btCriarConta.setBounds(189, 360, 120, 32);
		btCriarConta.addMouseListener(new OuvinteMouseBtCriarConta());
		btCriarConta.setToolTipText("Crie a sua conta! Venha fazer parte da Monteiro-Motos!");
		this.add(btCriarConta);
	}
	public class OuvinteMouseBtCriarConta implements MouseListener{
		public void mouseClicked(MouseEvent e) {}
		public void mousePressed(MouseEvent e) {}
		public void mouseReleased(MouseEvent e) {}
		
		public void mouseEntered(MouseEvent e) {
			btCriarConta.setBackground(Color.getHSBColor(100/360f, 50/100f, 80/100f));
		}

		public void mouseExited(MouseEvent e) {
			btCriarConta.setBackground(null);
		}
	}
}
