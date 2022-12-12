package jefferson.telaDeAdicionarCreditos_OK.ouvintesAdicionar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import ListaDeAquecimento.*;
import ListaDeAquecimento.Mensageiro;
import clebson.JanelaMototaxista;

public class OuvinteBotaoComprar implements ActionListener{

	private JFormattedTextField quantidadeCreditos;
	private JFrame telaAtual;
	
	private Mensageiro mensageiro;
	
	private CentralDeInformacoes central;
	private Mototaxista mototaxista;
	
	public OuvinteBotaoComprar(JFrame tela, JFormattedTextField campoCreditos, Mototaxista infoMototaxista, CentralDeInformacoes centralD) {
		telaAtual = tela;
		quantidadeCreditos = campoCreditos;
		mototaxista = infoMototaxista;
		central = centralD;
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		mensageiro = new Mensageiro();
		if (!quantidadeCreditos.getText().isBlank()) {
			int quantidadeCreditosComprados = Integer.parseInt(quantidadeCreditos.getText());
			try {
				float valor = mototaxista.adicionarCreditos(quantidadeCreditosComprados, central);
				
				new GeradorDePDF().gerarBoleto(central, mototaxista, valor);
				
				mensageiro.enviarBoleto(mototaxista.getEmail());
				
				ArrayList<Usuario> usuarios = central.getTodosOsUsuarios();
				for(int i = 0; i < usuarios.size(); i++) {
					if (usuarios.get(i).equals(mototaxista)) {
						usuarios.remove(i);
						usuarios.add(mototaxista);
					}
				}
				central.setTodosOsUsuarios(usuarios);
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
