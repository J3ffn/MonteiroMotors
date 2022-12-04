package ListaDeAquecimento;

import java.time.LocalDate;
import java.util.ArrayList;

public class CentralDeInformacoes {
	private ArrayList < Usuario > todosOsUsuarios = new ArrayList < Usuario >();
	private ArrayList < Corrida > corridas = new ArrayList < Corrida > ();
	
	//Corrigida
	public boolean adicionarUsuario(Usuario p) {
		int idade = LocalDate.now().compareTo(p.getDataDeNascimento());
		if(idade < 18) {
			return false;
		} else {
			Usuario outro = this.recuperarUsuarioPeloEmail(p.getEmail());
			if(outro==null) {
				todosOsUsuarios.add(p);
				return true;
			}
			return false;
		}
	}
	public Administrador recuperarAdministradorDoSistema() {
		for(Usuario u : todosOsUsuarios)
			if(u instanceof Administrador)
				return (Administrador) u;
		return null;
	}
	public void setCorridas(ArrayList<Corrida> corridas) {
		this.corridas = corridas;
	}

	public Usuario recuperarUsuarioPeloEmail(String email) {
		for(Usuario usuario : todosOsUsuarios) {
			if(usuario.getEmail().equals(email)) {
				return usuario;
			}
		}
		return null;
	}
	public String listarTodosOsUsuarios() {
		String txt = "Lista de Passageiros: \n";
		for(Usuario usuario : todosOsUsuarios) {
			txt += String.format("%s - %s \n", usuario.getNome(), usuario.getId());
		}
		return txt;
	}
	public String listarTodasAsCorridas() {
		String txt = "Lista de Corridas: \n";
		for(Corrida corrida : corridas) {
			txt += String.format("%d - %s \n", corridas.indexOf(corrida) + 1, corrida.toString());
		}
		return txt;
	}
	// Corrigida
	public boolean adicionarCorrida(Corrida corrida) {
		Corrida outra = this.recuperarCorridaPeloId(corrida.getId());
		if(outra == null) {
			corridas.add(corrida);
			return true;
		} else {
			return false;
		}
	}
	public Corrida recuperarCorridaPeloId(long idDaCorrida) {
		for(Corrida c : corridas) {
			if(c.getId() == idDaCorrida) {
				return c;
			}
		}
		return null;
	}
	public ArrayList <Corrida> recuperarCorridasDeUmPassageiro(String idUsuario){
		Usuario p = this.recuperarUsuarioPeloEmail(idUsuario);
		if(p == null) {
			return null;
		} else {
			ArrayList <Corrida> corridasDoPass = new ArrayList <Corrida>();
			for(Corrida c : corridas) {
				if(c.getUsuario().equals(p)) {
					corridasDoPass.add(c);
				}
			}
			return corridasDoPass;
		}
	}
	public ArrayList<Usuario> getTodosOsUsuarios() {
		return todosOsUsuarios;
	}
	public void setTodosOsUsuarios(ArrayList<Usuario> todosOsUsuarios) {
		this.todosOsUsuarios = todosOsUsuarios;
	}
}
