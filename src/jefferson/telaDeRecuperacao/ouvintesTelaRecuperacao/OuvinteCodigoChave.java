package jefferson.telaDeRecuperacao.ouvintesTelaRecuperacao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.UUID;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import ListaDeAquecimento.Mensageiro;
import jefferson.telaDeRecuperacao.telasParaRecuperacao.TelaDeAlteracaoDaSenha;
import jefferson.telaDeRecuperacao.telasParaRecuperacao.TelaVerificarCodigo;

@SuppressWarnings("unused")
public class OuvinteCodigoChave extends SimpleEmail implements ActionListener{

	private String emailDestinatario;
	private String codigoChave;
	private JFrame telaAtual;
	private JTextField linhaEmail;
	private JButton jbotao;
	
	public OuvinteCodigoChave(JFrame tela, JTextField linha, JButton botao) {
		emailDestinatario = linha.getText();
		telaAtual = tela;
		jbotao = botao;

		// Gerador de palavra secreta; TODO mudar isso depois
		UUID geradorID = UUID.randomUUID();
		codigoChave = String.valueOf(geradorID).substring(0, 7);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Descomentar essas verificações.
//		if (new CentralDeInformacoes().recuperarUsuarioPeloEmail(emailDestinatario) != null) {

			if (new Mensageiro().verificarEmail(emailDestinatario)) {
				
				new Mensageiro().enviarCodigoDeRecuperacao(emailDestinatario, codigoChave, "Chave de recuperação");
				
				telaAtual.dispose();
				new TelaVerificarCodigo(codigoChave, linhaEmail);
			}
			
//		} else { JOptionPane.showMessageDialog(null, "Usuário não está cadastrado."); }
	}
	
	
	
}
