package jefferson.telaDeAdicionarCreditos.telasParaAdicionar;

import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;

import ListaDeAquecimento.Mototaxista;
import clebson.JanelaPadrao;
import eduardo.Janelas.AdicaoInvalidaException;

public class TelaDeAdicionarCreditos extends JanelaPadrao{

	private Mototaxista mototaxista;
	private JFormattedTextField quantidadeCreditos;
	private JFrame tela = this;
	
	public TelaDeAdicionarCreditos(Mototaxista mtx) {
		super("Adicionar créditos", null);
		mototaxista = mtx;
		
		setSize(300, 200);
		addCampoTextField();
		addBotoes();
		setVisible(true);
	}
	
	private void addCampoTextField() {
		JLabel subTexto = new JLabel("DIGITE O VALOR");
		subTexto.setBounds(50, 35, 150, 40);
		
		try {
			MaskFormatter msk = new MaskFormatter("##");
			quantidadeCreditos = new JFormattedTextField(msk);
			quantidadeCreditos.setBounds(40, 60, 100, 40);
			quantidadeCreditos.setHorizontalAlignment(JFormattedTextField.CENTER);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		add(subTexto);
		add(quantidadeCreditos);
	}
	
	private void addBotoes() {
		JButton botaoVoltar = new JButton("< voltar");
		botaoVoltar.setBounds(5, 5, 80, 20);
		
		JButton botaoComprar = new JButton("Comprar");
		botaoComprar.setBounds(150, 60, 110, 40);
		botaoComprar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(quantidadeCreditos.getText());
				if (!quantidadeCreditos.getText().isBlank()) {
					int valorcreditos = Integer.parseInt(quantidadeCreditos.getText());
					try {
						JOptionPane.showMessageDialog(null, "uma N-fe foi enviada ao seu email");
						mototaxista.adicionarCreditos(valorcreditos, getCentral());
						tela.dispose();
					} catch (AdicaoInvalidaException e1) {
						e1.printStackTrace();
					}
				} else {
					JOptionPane.showConfirmDialog(null, "Digite um valor", "ALERTA", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		
		add(botaoVoltar);
		add(botaoComprar);
	}
	
}
