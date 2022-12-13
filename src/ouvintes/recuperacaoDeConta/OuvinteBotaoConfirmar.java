package ouvintes.recuperacaoDeConta;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import janelas.janelaDeLogin.JanelaDeLogin;
import sistemas.GestãoDeInformacoes.CentralDeInformacoes;
import sistemas.GestãoDeInformacoes.Persistencia;
import sistemas.Usuários.Usuario;

public class OuvinteBotaoConfirmar implements ActionListener {

	private JFrame tela;
	private JPasswordField linhaPassword;
	private JPasswordField linhaConfirmarPassword;
	private CentralDeInformacoes central;
	private Usuario usuarioParaAlteracao;

	public OuvinteBotaoConfirmar(JFrame tela, JPasswordField linhaPassword, JPasswordField linhaConfirmarPassword,
			CentralDeInformacoes central, Usuario usuarioParaAlteracao) {
		this.tela = tela;
		this.linhaPassword = linhaPassword;
		this.linhaConfirmarPassword = linhaConfirmarPassword;
		this.central = central;
		this.usuarioParaAlteracao = usuarioParaAlteracao;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String novaSenha = new String(linhaPassword.getPassword());
		String confirmarNovaSenha = new String(linhaConfirmarPassword.getPassword());

		if (confirmarNovaSenha.equals(novaSenha) && !(confirmarNovaSenha.isBlank() || novaSenha.isBlank())) {

			try {
				usuarioParaAlteracao.alterarSenha(confirmarNovaSenha);
				ArrayList<Usuario> usuarios = central.getTodosOsUsuarios();

				for (int i = 0; i < usuarios.size(); i++) {
					if (usuarioParaAlteracao.equals(usuarios.get(i))) {
						usuarios.remove(i);
						usuarios.add(usuarioParaAlteracao);
					}
				}

				central.setTodosOsUsuarios(usuarios);

				new Persistencia().salvar(central, "dados-passageiros.xml");

				tela.dispose();
				new JanelaDeLogin();
			} catch (Exception e1) {

				e1.printStackTrace();
			}
		} else if (linhaPassword.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Campos vazios");
		} else {
			JOptionPane.showMessageDialog(null, "Senhas diferentes");
		}

	}

}
