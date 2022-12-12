package jefferson.telaDeAdicionarCreditos_OK.ouvintesAdicionar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import ListaDeAquecimento.CentralDeInformacoes;
import ListaDeAquecimento.GeradorDePDF;
import ListaDeAquecimento.Mensageiro;
import ListaDeAquecimento.Mototaxista;
import ListaDeAquecimento.Persistencia;
import clebson.JanelaMototaxista;
import eduardo.Janelas.AdicaoInvalidaException;

public class OuvinteBotaoComprar implements ActionListener{

	private JFormattedTextField quantidadeCreditos;
	private JFrame telaAtual;
	
	private CentralDeInformacoes central;
	private Mototaxista mototaxista;
	private Mensageiro mensageiro = new Mensageiro();
	
	public OuvinteBotaoComprar(JFrame tela, JFormattedTextField campoCreditos, Mototaxista infoMototaxista, CentralDeInformacoes centralD) {
		telaAtual = tela;
		quantidadeCreditos = campoCreditos;
		mototaxista = infoMototaxista;
		central = centralD;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(quantidadeCreditos.getText());
		if (!quantidadeCreditos.getText().isBlank()) {
			int valorcreditos = Integer.parseInt(quantidadeCreditos.getText());
			try {
				mototaxista.adicionarCreditos(valorcreditos, central);
				
				new GeradorDePDF().gerarBoleto(central, mototaxista, valorcreditos);
				
				mensageiro.enviarBoleto(/*mototaxista.getEmail()*/ "jefferson.mangueira@academico.ifpb.edu.br");
				mototaxista.adicionarCreditos(valorcreditos, central);
				
				new Persistencia().salvar(central, "dados-passageiros.xml");
				
				telaAtual.dispose();
				
				new JanelaMototaxista(mototaxista);
				
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} else {
			JOptionPane.showConfirmDialog(null, "Digite um valor", "ALERTA", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE);
		}
		
	}

}
