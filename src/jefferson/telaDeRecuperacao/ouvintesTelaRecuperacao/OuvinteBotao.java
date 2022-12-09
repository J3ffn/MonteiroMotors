package jefferson.telaDeRecuperacao.ouvintesTelaRecuperacao;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class OuvinteBotao implements MouseListener{

	private JButton botaoEnviar;
	private JFrame telaEmail;
	private JTextField linhaEmail;
	
	public OuvinteBotao(JButton botao, JFrame tela, JTextField linha){
		botaoEnviar = botao;
		telaEmail = tela;
		linhaEmail = linha;
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {}
	
	@Override
	public void mousePressed(MouseEvent e) {}
	
	@Override
	public void mouseExited(MouseEvent e) {}
	
	@Override
	public void mouseEntered(MouseEvent e) {}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		botaoEnviar.addActionListener(new OuvinteCodigoChave(telaEmail, linhaEmail));
		
	}

}
