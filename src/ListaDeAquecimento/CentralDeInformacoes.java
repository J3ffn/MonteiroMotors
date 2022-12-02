package ListaDeAquecimento;

import java.time.LocalDate;
import java.util.ArrayList;

public class CentralDeInformacoes {
	private ArrayList < Passageiro > todosOsPassageiros = new ArrayList < Passageiro >();
	private ArrayList < Corrida > corridas = new ArrayList < Corrida > ();
	
	//Corrigida
	public boolean adicionarPassageiro(Passageiro p) {
		int idade = LocalDate.now().compareTo(p.getDataDeNascimento());
		if(idade < 18) {
			return false;
		} else {
			Passageiro outro = this.recuperarPassageiroPeloEmail(p.getEmail());
			if(outro==null) {
				todosOsPassageiros.add(p);
				return true;
			}
			return false;
		}
	}
	
	public void setCorridas(ArrayList<Corrida> corridas) {
		this.corridas = corridas;
	}

	public Passageiro recuperarPassageiroPeloEmail(String email) {
		for(Passageiro passageiro : todosOsPassageiros) {
			if(passageiro.getEmail().equals(email)) {
				return passageiro;
			}
		}
		return null;
	}
	public String listarTodosOsPassageiros() {
		String txt = "Lista de Passageiros: \n";
		for(Passageiro passageiro : todosOsPassageiros) {
			txt += String.format("%s - %s \n", passageiro.getNome(), passageiro.getId());
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
	public ArrayList <Corrida> recuperarCorridasDeUmPassageiro(String idPassageiro){
		Passageiro p = this.recuperarPassageiroPeloEmail(idPassageiro);
		if(p == null) {
			return null;
		} else {
			ArrayList <Corrida> corridasDoPass = new ArrayList <Corrida>();
			for(Corrida c : corridas) {
				if(c.getPassageiro().equals(p)) {
					corridasDoPass.add(c);
				}
			}
			return corridasDoPass;
		}
	}
	public ArrayList<Passageiro> getTodosOsPassageiros() {
		return todosOsPassageiros;
	}
	public void setTodosOsPassageiros(ArrayList<Passageiro> todosOsPassageiros) {
		this.todosOsPassageiros = todosOsPassageiros;
	}
}
