package eduardo.JanelaCorridasDisponiveis;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import ListaDeAquecimento.Administrador;
import ListaDeAquecimento.ComparacaoData;
import ListaDeAquecimento.ComparacaoData2;
import ListaDeAquecimento.Corrida;
import ListaDeAquecimento.Mototaxista;
import ListaDeAquecimento.Passageiro;
import ListaDeAquecimento.Persistencia;
import ListaDeAquecimento.Usuario;
import clebson.JanelaPadrao;
import eduardo.Ouvintes.OuvinteBotaoCancelar;

public class JanelaDeCorridasDisponiveis extends JanelaPadrao {
	private ArrayList<Corrida> corridasTodasAsDisponiveis;
	private ArrayList<Passageiro> passageiros = new ArrayList<Passageiro>();;
	private JScrollPane painel;
	private Painel painel1;
	private JButton btAtualizar;
	private String[] opcoes = { "Todas", "Mais Recentes", "Mais Antigas", "Reinvindicadas", "Não Reinvindicadas" };
	private JComboBox<String> filtro;

	public JanelaDeCorridasDisponiveis(Usuario u) {
		super("Janela de Corridas Disponiveis", u);
		adicionarPainel();
		adicionarBotoes();
		this.setVisible(true);
	}

	public void adicionarBotoes() {
		JLabel texto = new JLabel("Corridas Disponiveis");
		texto.setBounds(20, 40, 440, 20);
		texto.setBackground(Color.GRAY);
		texto.setOpaque(true);
		texto.setHorizontalAlignment(JLabel.CENTER);
		this.add(texto);

		JButton b = new JButton("< Voltar");
		b.setBounds(5, 5, 80, 20);
		b.addMouseListener((new MouseAdapter() {

			public void mouseEntered(MouseEvent e) {
				try {
					new Persistencia().salvar(getCentral(), "dados-passageiros.xml");
				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}

		}));
		b.addActionListener(new OuvinteBotaoCancelar(this));
		this.add(b);

		filtro = new JComboBox<String>(opcoes);

		if (this.getUsuario() instanceof Mototaxista) {
			filtro.removeItemAt(3);
			filtro.removeItemAt(3);

		} else if (this.getUsuario() instanceof Passageiro) {
			filtro.removeItemAt(1);
			filtro.removeItemAt(1);

		} else if (this.getUsuario() instanceof Administrador) {
			for (Usuario u : this.getCentral().getTodosOsUsuarios()) {
				if (u instanceof Passageiro) {
					filtro.addItem(u.getNome());
					passageiros.add((Passageiro) u);
				}
			}
		}
		filtro.setSelectedItem(opcoes[0]);
		filtro.setBounds(350, 5, 110, 20);
		this.add(filtro);

		btAtualizar = new JButton("Atualize!");
		btAtualizar.setBounds(90, 5, 100, 20);
		btAtualizar.addMouseListener(new OuvinteDoAtualizar(this));
		this.add(btAtualizar);
	}

	public void adicionarPainel() {
		if (getUsuario() instanceof Mototaxista) {
			painel1 = new PainelListaCorridasMototaxista(getCorridasTodasAsDisponiveis(), (Mototaxista) getUsuario());
		} else if (getUsuario() instanceof Administrador) {
			painel1 = new PainelListaCorridasAdministrador(getCorridasTodasAsDisponiveis(),
					(Administrador) getUsuario());
		} else if (getUsuario() instanceof Passageiro) {
			painel1 = new PainelListaCorridasPassageiro(getCorridasTodasAsDisponiveis(), (Passageiro) getUsuario());
		}
		painel = new JScrollPane(painel1);

		painel.setBounds(20, 60, 440, 340);

		this.add(painel);
	}

	public Painel getPainel1() {
		return painel1;
	}

	public void setPainel1(Painel painel1) {
		this.painel1 = painel1;
	}

	public void setPainel(JScrollPane painel) {
		this.painel = painel;
	}

	public JScrollPane getPainel() {
		return painel;
	}

	public ArrayList<Corrida> getCorridasTodasAsDisponiveis() {
		return corridasTodasAsDisponiveis;
	}

	public void setCorridasTodasAsDisponiveis(ArrayList<Corrida> corridasTodasAsDisponiveis) {
		this.corridasTodasAsDisponiveis = corridasTodasAsDisponiveis;
	}

	private class OuvinteDoAtualizar extends MouseAdapter {
		JanelaDeCorridasDisponiveis janela;

		public OuvinteDoAtualizar(JanelaDeCorridasDisponiveis j) {
			janela = j;
		}

		public void mouseClicked(MouseEvent e) {
			if (filtro.getSelectedItem().equals("Mais Antigas") && getCorridasTodasAsDisponiveis() != null) {
				getCorridasTodasAsDisponiveis().sort(new ComparacaoData());

			} else if (filtro.getSelectedItem().equals("Mais Recentes") && getCorridasTodasAsDisponiveis() != null) {
				getCorridasTodasAsDisponiveis().sort(new ComparacaoData2());

			} else if (filtro.getSelectedItem().equals("Não Reinvindicadas")) {
				setCorridasTodasAsDisponiveis(getCentral().recuperarNaoReinvindicadas(getUsuario()));

			} else if (filtro.getSelectedItem().equals("Reinvindicadas")) {
				setCorridasTodasAsDisponiveis(getCentral().recuperarReinvindicadas(getUsuario()));

			} else if (filtro.getSelectedItem().equals("Todas")) {
				ArrayList<Corrida> listaCorridasQueVaoAparecer = null;
				if (getUsuario() instanceof Mototaxista) {
					if (janela instanceof JanelaDeChamadasDeCorridas) {
						listaCorridasQueVaoAparecer = getCentral()
								.recuperarCorridasPossiveisParaoMototaxista((Mototaxista) getUsuario());
					} else {
						listaCorridasQueVaoAparecer = getCentral().recuperarReinvindicadas((Mototaxista) getUsuario());
					}
				} else if (getUsuario() instanceof Administrador) {
					listaCorridasQueVaoAparecer = getCentral().getCorridas();
				} else if (getUsuario() instanceof Passageiro) {
					listaCorridasQueVaoAparecer = getCentral().recuperarCorridasDeUmPassageiro(getUsuario().getEmail());
				}
				setCorridasTodasAsDisponiveis(listaCorridasQueVaoAparecer);
			} else if (getUsuario() instanceof Administrador) {
				Usuario u = passageiros.get(filtro.getSelectedIndex() - opcoes.length);
				String email = (u.getEmail());// (String) filtro.getSelectedItem(); getCentral(
				setCorridasTodasAsDisponiveis(getCentral().recuperarCorridasDeUmPassageiro(email));
			}

			JButton botao = (JButton) e.getSource();
			botao.setText("Atualizar!");
			botao.transferFocus();
			janela.remove(painel);
			adicionarPainel();
			janela.repaint();
		}
	}
}
