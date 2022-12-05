package eduardo;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import clebson.JanelaPadrao;

public class JanelaDeRegistro extends JanelaPadrao{
	JComboBox < String > cbTipoUsuario;
	JButton btCriarConta;
	JTextField inputNome;
	JTextField inputEmail;
	JPasswordField inputSenha;
	JPasswordField inputConfirmacaoSenha;
	JFormattedTextField inputDataDeNascimento; JComboBox <String> cbSexo;
	
	
	public JanelaDeRegistro() {
		super("Registro de Usuário");
		this.adicionarBotoes();
		this.adicionarCaixasDeTexto();
		this.setVisible(true);
	}
	public void adicionarCaixasDeTexto() {
		int x = 125;
		
		String[] tiposUsuarios = {"Administrador", "Mototaxista", "Passageiro"};
		cbTipoUsuario = new JComboBox < String >(tiposUsuarios);
		cbTipoUsuario.setBounds(190, 7, 110, 30);
		
		JLabel txNome = new JLabel("Nome Completo:");
		txNome.setBounds(x, 40, 134, 20);
		inputNome = new JTextField();
		inputNome.setBounds(x, 60, 243, 30);
		
		JLabel txEmail = new JLabel("Email:");
		txEmail.setBounds(x, 95, 134, 20);
		inputEmail = new JTextField();
		inputEmail.setBounds(x, 115, 243, 30);
		
		
		JLabel txSenha = new JLabel("Senha:");
		txSenha.setBounds(x, 150, 134, 20);
		inputSenha = new JPasswordField();
		inputSenha.setBounds(x, 170, 243, 30);
		
		JLabel txConfirmacaoSenha = new JLabel("Confirme a sua senha:");
		txConfirmacaoSenha.setBounds(x, 205, 170, 20);
		inputConfirmacaoSenha = new JPasswordField();
		inputConfirmacaoSenha.setBounds(x, 230, 243, 30);
		
		JLabel txDataDeNascimento = new JLabel("Data de Nascimento:");
		MaskFormatter msk = null;
		txDataDeNascimento.setBounds(x, 265, 150, 30);
		try {
			msk = new MaskFormatter("##/##/####");
		} catch (ParseException e) {}
		inputDataDeNascimento = new JFormattedTextField(msk);
		inputDataDeNascimento.setHorizontalAlignment(JTextField.CENTER);
		inputDataDeNascimento.setBounds(x, 295, 100, 30);
		
		JLabel txSexo = new JLabel("Sexo:");
		txSexo.setBounds(280, 266, 50, 30);
		
		String[] sexos = {"Masculino", "Feminino"};
		cbSexo = new JComboBox <String> (sexos);
		cbSexo.setBounds(280, 295, 90, 30);
		
		this.add(cbTipoUsuario);
		
		this.add(txNome);
		this.add(inputNome);
		
		this.add(txEmail);
		this.add(inputEmail);
		
		this.add(txSenha);
		this.add(inputSenha);
		
		this.add(txConfirmacaoSenha);
		this.add(inputConfirmacaoSenha);
		
		this.add(txDataDeNascimento);
		this.add(inputDataDeNascimento);
		
		this.add(txSexo);
		this.add(cbSexo);
		
	}
	public void adicionarBotoes() {
		//ToDo- Adicionar A Lista de seleção de tipo de usuario em cima do JTExtField de nome.
		
		btCriarConta = new JButton("Criar Conta");
		btCriarConta.setBounds(190, 365, 120, 30);
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
