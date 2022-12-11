package eduardo.JanelaCorridasDisponiveis;

import javax.swing.JScrollPane;

import ListaDeAquecimento.Administrador;
import ListaDeAquecimento.Mototaxista;
import ListaDeAquecimento.Passageiro;
import ListaDeAquecimento.Usuario;

public class JanelaDeChamadasDeCorridas extends JanelaDeCorridasDisponiveis{

	public JanelaDeChamadasDeCorridas(Usuario u) {
		super(u);
	}
	public void adicionarPainel() {
		this.setPainel1(new PainelReinvindicacao(getCorridasTodasAsDisponiveis(), getUsuario()));
		setPainel(new JScrollPane(getPainel1()));
		
		getPainel().setBounds(20, 60, 440, 340);
		
		this.add(getPainel());
	}

}
