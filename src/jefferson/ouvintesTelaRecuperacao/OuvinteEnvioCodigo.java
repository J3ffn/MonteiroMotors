package jefferson.ouvintesTelaRecuperacao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.TreeSet;
import java.util.UUID;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;
import org.apache.commons.mail.SimpleEmail;

import ListaDeAquecimento.CentralDeInformacoes;
import ListaDeAquecimento.Usuario;
import jefferson.telasDeRecuperacao.TelaVerificarCodigo;

@SuppressWarnings("unused")
public class OuvinteEnvioCodigo extends SimpleEmail implements ActionListener {

	private String emailRemetente = "projetomonteiromotors@gmail.com";
	private String emailDestinatario;
	private String codigoChave;
	private JFrame telaAtual;

	public OuvinteEnvioCodigo(JFrame tela, JTextField linha) {
		emailDestinatario = linha.getText();
		telaAtual = tela;

		// Gerador de palavra secreta;
		UUID te = UUID.randomUUID();
		codigoChave = String.valueOf(te).substring(0, 7);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Descomentar essas verificações.
//		if (new CentralDeInformacoes().recuperarUsuarioPeloEmail(emailDestinatario) != null) {

			try {
				setSubject("Código de recuperação da conta");
				enviarEmail();
				telaAtual.dispose();
				
				new TelaVerificarCodigo(codigoChave);
	
			} catch (EmailException e1) {
	
				JOptionPane.showMessageDialog(null, "Não foi possível enviar o email");
	
			}

//		} else { JOptionPane.showMessageDialog(null, "Usuário não está cadastrado."); }
	}

	public boolean enviarEmail() throws EmailException {
		// email projetomonteiromotors@gmail.com
		setarProtocolo();

		addTo(emailDestinatario);
		setMsg("Sua chave é: " + codigoChave);

		send();
		System.out.println("Enviado");
		return true;
	}

	private void setarProtocolo() {
		setHostName("smtp.gmail.com");
		setSmtpPort(587);
		setAuthenticator(new DefaultAuthenticator("projetomonteiromotors@gmail.com", "uvlwjpmlkbuhreeq"));
		setSSLOnConnect(true);

		try {
			setFrom(emailRemetente);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
