package eduardo.Janelas;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.time.LocalDate;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import ListaDeAquecimento.Administrador;
import ListaDeAquecimento.CentralDeInformacoes;
import ListaDeAquecimento.Mototaxista;
import ListaDeAquecimento.Passageiro;
import ListaDeAquecimento.Persistencia;
import ListaDeAquecimento.Usuario;
import clebson.JanelaPadrao;

public class JanelaDeRegistro extends JanelaPadrao{
	CentralDeInformacoes central;
	Persistencia persistencia;
	
	JComboBox < String > cbTipoUsuario;
	JButton btCriarConta;
	JTextField inputNome;
	JTextField inputEmail;
	JPasswordField inputSenha;
	JPasswordField inputConfirmacaoSenha;
	JFormattedTextField inputDataDeNascimento; JComboBox <String> cbSexo;
	
	public JanelaDeRegistro(CentralDeInformacoes central, Persistencia per) {
		super("Registro de Usuário");
		this.central = central;
		this.persistencia = per;
		this.adicionarBotoes();
		this.adicionarCaixasDeTexto();
		this.setVisible(true);
	}
	
	public void adicionarCaixasDeTexto() {
		int x = 125;
		
		String[] tiposUsuarios = {"Administrador", "Mototaxista", "Passageiro"};
		cbTipoUsuario = new JComboBox < String >(tiposUsuarios);
		cbTipoUsuario.setBounds(190, 7, 110, 30);
		if(central.getTodosOsUsuarios().isEmpty()) {
			cbTipoUsuario.setEnabled(false);
		} else {
			cbTipoUsuario.removeItemAt(0);
			cbTipoUsuario.setEnabled(true);
		}
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
		inputConfirmacaoSenha.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				inputSenha.setBackground(Color.WHITE);
				inputConfirmacaoSenha.setBackground(Color.WHITE);
			}

			@Override
			public void focusLost(FocusEvent e) {
				String texto = new String(inputConfirmacaoSenha.getPassword());
				if(texto.equals(new String(inputSenha.getPassword()))){
					inputSenha.setBackground(Color.GREEN);
					inputConfirmacaoSenha.setBackground(Color.GREEN);
				} else {
					inputSenha.setBackground(Color.RED);
					inputConfirmacaoSenha.setBackground(Color.RED);
				}
			}
		});
		
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
		btCriarConta.addActionListener(new OuvinteClickBtCriarConta(this));
		btCriarConta.setToolTipText("Crie a sua conta! Venha fazer parte da Monteiro-Motos!");
		
		this.add(btCriarConta);
	}
	
	private class OuvinteClickBtCriarConta implements ActionListener{
		JanelaDeRegistro j;
		
		public OuvinteClickBtCriarConta(JanelaDeRegistro j) {
			this.j = j;
		}
		public void actionPerformed(ActionEvent e) {
			try {
			if(new String(inputSenha.getPassword()).equals(new String(inputConfirmacaoSenha.getPassword())) 
					&& !inputNome.getText().equals("")&& !inputEmail.getText().equals("") && 
					!inputDataDeNascimento.getText().equals("  /  /    ") && 
					! new String(inputSenha.getPassword()).equals("")
					) {
			Usuario u;
			String[] datas = inputDataDeNascimento.getText().split("/");
			LocalDate dataNascimento = LocalDate.of(Integer.parseInt(datas[2]), 
					Integer.parseInt(datas[1]), 
					Integer.parseInt(datas[0]));
			if(central.getTodosOsUsuarios().isEmpty()) {
				u = new Administrador(inputNome.getText(), 
									  (String) cbSexo.getSelectedItem(), 
									  inputEmail.getText(), 
									  new String(inputSenha.getPassword()),
									  dataNascimento);
			} else {
				String opcao = (String)cbTipoUsuario.getSelectedItem();
				if(opcao.equals("Mototaxista")) {
					u = new Mototaxista(inputNome.getText(), 
									   (String)cbSexo.getSelectedItem(), 
									    inputEmail.getText(), 
									    new String(inputSenha.getPassword()),
									    dataNascimento);
				} else {
					u = new Passageiro(inputNome.getText(), 
									  (String)cbSexo.getSelectedItem(), 
									  inputEmail.getText(), 
									  new String(inputSenha.getPassword()), 
									  dataNascimento);
				}
			}
			central.adicionarUsuario(u);
			try {
				persistencia.salvar(central, "dados-passageiros.xml");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			JOptionPane.showMessageDialog(j, "Usuário cadastrado Com Sucesso!");
			j.dispose();
			} } catch (Exception erro){
			JOptionPane.showMessageDialog(j, "Ocorreu um erro, corrija os campos!", "Erro!", JOptionPane.ERROR_MESSAGE);
		}
		
	}
	}
	private class OuvinteMouseBtCriarConta implements MouseListener{
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
	public JComboBox<String> getCbTipoUsuario() {
		return cbTipoUsuario;
	}
	public JButton getBtCriarConta() {
		return btCriarConta;
	}
	public JTextField getInputNome() {
		return inputNome;
	}
	public JTextField getInputEmail() {
		return inputEmail;
	}
	public JPasswordField getInputSenha() {
		return inputSenha;
	}
	public JPasswordField getInputConfirmacaoSenha() {
		return inputConfirmacaoSenha;
	}
	public JFormattedTextField getInputDataDeNascimento() {
		return inputDataDeNascimento;
	}
	public JComboBox<String> getCbSexo() {
		return cbSexo;
	}
}
