package ListaDeAquecimento;

import java.util.Comparator;

public class ComparacaoData implements Comparator<Corrida>{

	public int compare(Corrida o1, Corrida o2) {
		return o1.getData().compareTo(o2.getData());
	}
}
