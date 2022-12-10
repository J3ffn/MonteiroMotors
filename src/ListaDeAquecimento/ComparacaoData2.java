package ListaDeAquecimento;

import java.util.Comparator;

public class ComparacaoData2 implements Comparator <Corrida>{
	public int compare(Corrida o1, Corrida o2) {
		if(o1.getData().isAfter(o2.getData())) {
			return -1;
		} else if (o1.getData().isBefore(o2.getData())) {
			return 1;
		}
		return 0;
	}

}
