package jefferson.telaDeAdicionarCreditos_OK.telasParaAdicionar;

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

import ListaDeAquecimento.CentralDeInformacoes;
import ListaDeAquecimento.Mensageiro;
import ListaDeAquecimento.Mototaxista;
import clebson.JanelaMototaxista;
import eduardo.Janelas.AdicaoInvalidaException;
import jefferson.telaDeAdicionarCreditos_OK.ouvintesAdicionar.OuvinteBotaoComprar;

@SuppressWarnings({ "serial" })
public class TelaDeAdicionarCreditos extends JFrame{

	private Mototaxista mototaxista;
	private JFormattedTextField quantidadeCreditos;
	private JFrame tela = this;
	
	public TelaDeAdicionarCreditos(Mototaxista mtx, CentralDeInformacoes central) {
		super("Adicionar créditos");
		mototaxista = mtx;
		
		setResizable(false);
		setLocationRelativeTo(null);				
		setLayout(null);
		
		setSize(300, 170);
		addCampoTextField();
		addBotoes(central);
		setVisible(true);
	}
	
	private void addCampoTextField() {
		JLabel subTexto = new JLabel("DIGITE O VALOR");
		subTexto.setBounds(40, 30, 150, 40);
		
		try {
			MaskFormatter msk = new MaskFormatter("##");
			quantidadeCreditos = new JFormattedTextField(msk);
			quantidadeCreditos.setBounds(40, 60, 100, 40);
			quantidadeCreditos.setHorizontalAlignment(JFormattedTextField.CENTER);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		add(subTexto);
		add(quantidadeCreditos);
	}
	
	private void addBotoes(CentralDeInformacoes central) {
		JButton botaoVoltar = new JButton("< voltar");
		botaoVoltar.setBounds(5, 5, 80, 20);
		botaoVoltar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				tela.dispose();
				new JanelaMototaxista(mototaxista);
			}
		});
		
		JButton botaoComprar = new JButton("Comprar");
		botaoComprar.setBounds(150, 60, 110, 40);
		botaoComprar.addActionListener(new OuvinteBotaoComprar(tela, quantidadeCreditos, mototaxista, central));
		
		add(botaoVoltar);
		add(botaoComprar);
	}
	
}
