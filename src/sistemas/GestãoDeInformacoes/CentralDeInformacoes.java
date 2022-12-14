package sistemas.GestãoDeInformacoes;

import java.time.LocalDate;
import java.util.ArrayList;

import exceções.PerfilDesativadoException;
import exceções.SenhaIncorretaException;
import exceções.UsuarioNaoCadastradoException;
import sistemas.Corridas.Avaliacao;
import sistemas.Corridas.Corrida;
import sistemas.Corridas.Status;
import sistemas.Usuários.Administrador;
import sistemas.Usuários.Mototaxista;
import sistemas.Usuários.Passageiro;
import sistemas.Usuários.Usuario;

public class CentralDeInformacoes {
	private ArrayList<Usuario> todosOsUsuarios = new ArrayList<Usuario>();
	private ArrayList<Corrida> corridas = new ArrayList<Corrida>();
	private float caixaDoSistema = 0;

	// Corrigida
	public boolean adicionarUsuario(Usuario p) {
		int idade = LocalDate.now().compareTo(p.getDataDeNascimento());
		if (idade < 18) {
			return false;
		} else {
			Usuario outro = this.recuperarUsuarioPeloEmail(p.getEmail());
			if (outro == null) {
				todosOsUsuarios.add(p);
				return true;
			}
			return false;
		}
	}

	public Administrador recuperarAdministradorDoSistema() {
		for (Usuario u : todosOsUsuarios)
			if (u instanceof Administrador)
				return (Administrador) u;
		return null;
	}

	public void atualizarCentral(Usuario u) {
		for (int i = 0; i < todosOsUsuarios.size(); i++) {
			if (todosOsUsuarios.get(i).equals(u)) {
				todosOsUsuarios.remove(i);
				todosOsUsuarios.add(i, u);
			}
		}
	}

	public void atualizarCentral(Corrida u) {
		for (int i = 0; i < corridas.size(); i++) {
			if (corridas.get(i).equals(u)) {
				corridas.remove(i);
				corridas.add(i, u);
			}
		}
	}

	public Usuario getUsuarioPeloId(String Id) {
		for (Usuario usuario : todosOsUsuarios) {
			if (usuario.getId().equals(Id)) {
				return usuario;
			}
		}
		return null;
	}

	public void setCorridas(ArrayList<Corrida> corridas) {
		this.corridas = corridas;
	}

	public void deletarPerfil(Usuario u) {
		todosOsUsuarios.remove(u);
	}

	public Usuario recuperarUsuarioPeloEmail(String email) {
		for (Usuario usuario : todosOsUsuarios) {
			if (usuario.getEmail().equals(email)) {
				return usuario;
			}
		}
		return null;
	}

	public Usuario fazerLogin(String email, String senha)
			throws SenhaIncorretaException, PerfilDesativadoException, UsuarioNaoCadastradoException {
		Usuario u = recuperarUsuarioPeloEmail(email);
		if (u != null) {
			u.fazerLogin(senha);
		} else {
			throw new UsuarioNaoCadastradoException();
		}
		return u;
	}

	public String listarTodosOsUsuarios() {
		String txt = "Lista de Passageiros: \n";
		for (Usuario usuario : todosOsUsuarios) {
			txt += String.format("%s - %s \n", usuario.getNome(), usuario.getId());
		}
		return txt;
	}

	public String listarTodasAsCorridas() {
		String txt = "Lista de Corridas: \n";
		for (Corrida corrida : corridas) {
			txt += String.format("%d - %s \n", corridas.indexOf(corrida) + 1, corrida.toString());
		}
		return txt;
	}

	public ArrayList<Usuario> getTodosOsUsuarios() {
		return todosOsUsuarios;
	}

	public ArrayList<Usuario> getTodosOsMototaxistas() {
		ArrayList<Usuario> mtxs = new ArrayList<Usuario>();
		for (Usuario u : todosOsUsuarios) {
			if (u instanceof Mototaxista) {
				mtxs.add(u);
			}
		}
		return mtxs;
	}

	public ArrayList<Usuario> getTodosOsPassageiros() {
		ArrayList<Usuario> mtxs = new ArrayList<Usuario>();
		for (Usuario u : todosOsUsuarios) {
			if (u instanceof Passageiro) {
				mtxs.add(u);
			}
		}
		return mtxs;
	}

	public void setTodosOsUsuarios(ArrayList<Usuario> todosOsUsuarios) {
		this.todosOsUsuarios = todosOsUsuarios;
	}

	/// METODOS DE CORRIDAS===========================================
	// Corrigida
	public boolean adicionarCorrida(Corrida corrida) {
		Corrida outra = this.recuperarCorridaPeloId(corrida.getId());
		if (outra == null) {
			corridas.add(corrida);
			corrida.setStatus(Status.PENDENTE);
			return true;
		} else {
			return false;
		}
	}

	public Corrida recuperarCorridaPeloId(long idDaCorrida) {
		for (Corrida c : corridas) {
			if (c.getId() == idDaCorrida) {
				return c;
			}
		}
		return null;
	}

	public ArrayList<Corrida> recuperarCorridasDeUmPassageiro(String idUsuario) {
		Usuario p = this.recuperarUsuarioPeloEmail(idUsuario);
		if (p == null) {
			return null;
		} else {
			ArrayList<Corrida> corridasDoPass = new ArrayList<Corrida>();
			for (Corrida c : corridas) {
				if (c.getUsuario().equals(p)) {
					corridasDoPass.add(c);
				}
			}
			return corridasDoPass;
		}
	}

	public void adicionarAvaliacao(Avaliacao avaliacao) {
		avaliacao.getCorrida().setAvaliacao(avaliacao);
		Mototaxista mototaxista = (Mototaxista) this.recuperarUsuarioPeloEmail(avaliacao.getDestinatario().getEmail());
		mototaxista.addAvaliacao(avaliacao);
	}

	public void adicionarAoCaixa(float f) {
		caixaDoSistema += f;
	}

	public ArrayList<Corrida> recuperarCorridasNaoReivindicadas() {
		ArrayList<Corrida> lista = new ArrayList<Corrida>();
		for (Corrida c : corridas) {
			if (c.getStatus() == Status.PENDENTE) {
				lista.add(c);
			}
		}
		return lista;
	}

	public ArrayList<Corrida> recuperarCorridasPossiveisParaoMototaxista(Mototaxista m) {
		ArrayList<Corrida> lista = new ArrayList<Corrida>();
		for (Corrida c : corridas) {
			Passageiro p = (Passageiro) c.getUsuario();
			if (c.getStatus() == Status.PENDENTE && !p.verificarSeEBloqueado(m)) {
				lista.add(c);
			}
		}
		return lista;
	}

	public ArrayList<Corrida> getCorridas() {

		return corridas;
	}

	public ArrayList<Corrida> recuperarReinvindicadas(Usuario p) {
		ArrayList<Corrida> lista = new ArrayList<Corrida>();
		if (p instanceof Passageiro) {
			for (Corrida c : corridas) {
				Passageiro p1 = (Passageiro) c.getUsuario();
				if (c.getStatus() == Status.REINVINDICADA && p1.equals(p)) {
					lista.add(c);
				}
			}
		} else if (p instanceof Administrador) {
			for (Corrida c : corridas) {
				Passageiro p1 = (Passageiro) c.getUsuario();
				if (c.getStatus() == Status.REINVINDICADA) {
					lista.add(c);
				}
			}
		} else if (p instanceof Mototaxista) {
			Mototaxista a = (Mototaxista) p;
			for (Corrida c : corridas) {
				Mototaxista p1 = c.getMototaxista();
				if (c.getStatus() == Status.REINVINDICADA && a.equals(p1)) {
					lista.add(c);
				}
			}
		}
		return lista;
	}

	public ArrayList<Corrida> recuperarNaoReinvindicadas(Usuario p) {
		ArrayList<Corrida> lista = new ArrayList<Corrida>();
		if (p instanceof Passageiro) {
			for (Corrida c : corridas) {
				Passageiro p1 = (Passageiro) c.getUsuario();
				if (c.getStatus() == Status.PENDENTE && p1.equals(p)) {
					lista.add(c);
				}
			}
		} else if (p instanceof Administrador) {
			for (Corrida c : corridas) {
				Passageiro p1 = (Passageiro) c.getUsuario();
				if (c.getStatus() == Status.PENDENTE) {
					lista.add(c);
				}
			}
		}
		return lista;
	}
}
