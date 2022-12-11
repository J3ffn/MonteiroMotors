package jefferson.telaDeAdicionarCreditos.telasParaAdicionar;

import javax.swing.JButton;

import ListaDeAquecimento.Mototaxista;
import clebson.JanelaPadrao;

public class TelaDeAdicionarCreditos extends JanelaPadrao{

	private Mototaxista mototaxista;
	
	public TelaDeAdicionarCreditos(Mototaxista mtx) {
		super("Adicionar créditos", null);
		mototaxista = mtx;
		
		setSize(300, 200);
		addBotoes();
		setVisible(true);
	}
	
	public void addBotoes() {
		JButton botaoVoltar = new JButton("< voltar");
		botaoVoltar.setBounds(5, 5, 80, 20);
		
		JButton botaoComprar = new JButton("Comprar");
		botaoComprar.setBounds(90, 110, 110, 40);
		
		add(botaoVoltar);
		add(botaoComprar);
	}
	
}
