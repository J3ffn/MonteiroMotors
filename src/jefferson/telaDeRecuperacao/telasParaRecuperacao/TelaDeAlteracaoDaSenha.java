package jefferson.telaDeRecuperacao.telasParaRecuperacao;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JTextField;

import ListaDeAquecimento.CentralDeInformacoes;
import ListaDeAquecimento.Usuario;
import jefferson.telaDeRecuperacao.ouvintesTelaRecuperacao.OuvinteAlteracaoDeSenha;

@SuppressWarnings("serial")
public final class TelaDeAlteracaoDaSenha extends TelaDeRecuperarSenha {

	private Usuario usuarioParaAlteracao;
	
	public TelaDeAlteracaoDaSenha(String email) {
		usuarioParaAlteracao = new CentralDeInformacoes().recuperarUsuarioPeloEmail(email);
		
		addTituloDaTela();
		addCampoTextField();
		addBotoesDaTela();
		setVisible(true);
	}
	
	@Override
	protected void addTituloDaTela() {
		JLabel linhaTitulo = new JLabel("ALTERE SUA SENHA");
		linhaTitulo.setFont(new Font("", Font.BOLD, 18));
		linhaTitulo.setBounds(150, 100, 190, 40);
		
		add(linhaTitulo);
	}
	
	@Override
	protected void addCampoTextField() {
		// Campo password
		JLabel subTextoSenha = new JLabel("Password: ");
		subTextoSenha.setBounds(115, 140, 80, 30);
		subTextoSenha.setFont(new Font("", Font.BOLD, 12));

		JTextField linhaPassword = new JTextField();
		linhaPassword.setBounds(115, 165, 250, 40);
		
		
		// Campo confirmar password
		JLabel subTextoConfirmarSenha = new JLabel("Confirmar password: ");
		subTextoConfirmarSenha.setBounds(115, 201, 130, 30);
		subTextoConfirmarSenha.setFont(new Font("", Font.BOLD, 12));
		
		JTextField linhaConfirmarPassword = new JTextField();
		linhaConfirmarPassword.setBounds(115, 225, 250, 40);
		
		if (linhaPassword.getText().length() != 0 && linhaPassword.getText().equals(linhaConfirmarPassword.getText()))
			linhaConfirmarPassword.addActionListener(new OuvinteAlteracaoDeSenha(this, linhaPassword, usuarioParaAlteracao));
		
		add(subTextoSenha);
		add(linhaPassword);
		
		add(subTextoConfirmarSenha);
		add(linhaConfirmarPassword);
	}
	
}
