package eduardo;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import clebson.JanelaPadrao;

public class JanelaDeRegistro extends JanelaPadrao{

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
		//ToDo- Adicionar A Lista de seleção de tipo de usuario
		
		JButton btCriarConta = new JButton("Criar Conta");
		btCriarConta.setBounds(189, 360, 120, 32);
		
		this.add(btCriarConta);
	}
}
