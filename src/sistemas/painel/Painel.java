package sistemas.painel;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ouvintes.listagemDeCorridas.OuvinteBotaoDetalhes;
import sistemas.Corridas.Corrida;
import sistemas.GestãoDeInformacoes.CentralDeInformacoes;
import sistemas.GestãoDeInformacoes.ComparacaoData;
import sistemas.GestãoDeInformacoes.ComparacaoData2;
import sistemas.GestãoDeInformacoes.Persistencia;
import sistemas.Usuários.Usuario;

@SuppressWarnings("serial")
public abstract class Painel extends JPanel {
	private ArrayList<Corrida> corridasTodasAsDisponiveis;
	private CentralDeInformacoes central;
	private Map<Integer, JButton> listaBotoes = new HashMap<>();
	private Usuario usuario;

	public Painel(ArrayList<Corrida> corridasTodasAsDisponiveis, Usuario usuario) {
		this.setCorridasTodasAsDisponiveis(corridasTodasAsDisponiveis);
		try {
			this.central = (CentralDeInformacoes) new Persistencia().recuperar("src/arquivos/dados-passageiros.xml");
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.usuario = usuario;
		this.preencherPainel();
	}

	public void preencherPainel() {
		this.setBackground(Color.WHITE);
		int y = 10;
		this.setLayout(null);
		this.repaint();

		if (getCorridasTodasAsDisponiveis() != null) {

			for (int i = 0; i < getCorridasTodasAsDisponiveis().size(); i++) {
				JLabel corrida = new JLabel("Corrida: " + corridasTodasAsDisponiveis.get(i).getId());
				corrida.setBounds(10, y + 10, 170, 20);

				JButton botao = new JButton("Detalhes");
				botao.setBounds(310, y, 115, 40);
				botao.addActionListener(new OuvinteBotaoDetalhes(corridasTodasAsDisponiveis, i, usuario));

				listaBotoes.put(i, botao);

				add(corrida);
				add(botao);
				y += 45;
			}

			if (getCorridasTodasAsDisponiveis().size() > 6) {
				GridLayout layout = new GridLayout(0, 2, 150, 20);
				this.setLayout(layout);
			}
		}
	}

	public ArrayList<Corrida> getCorridasTodasAsDisponiveis() {
		return corridasTodasAsDisponiveis;
	}

	public CentralDeInformacoes getCentral() {
		return central;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public ArrayList<Corrida> getCorridasOrganizadasMaisRecentes() {
		ArrayList<Corrida> corrida = getCorridasTodasAsDisponiveis();
		ComparacaoData c = new ComparacaoData();
		corrida.sort(c);
		return corrida;
	}

	public ArrayList<Corrida> getCorridasOrganizadasMaisAntigas() {
		ArrayList<Corrida> corrida = getCorridasTodasAsDisponiveis();
		ComparacaoData2 c = new ComparacaoData2();
		corrida.sort(c);
		return corrida;
	}

	public void setCorridasTodasAsDisponiveis(ArrayList<Corrida> corridasTodasAsDisponiveis) {
		this.corridasTodasAsDisponiveis = corridasTodasAsDisponiveis;
	}

	public void setCentral(CentralDeInformacoes central) {
		this.central = central;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
