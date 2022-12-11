package ListaDeAquecimento;

import java.util.Comparator;

public class ComparacaoData implements Comparator{
	
	@Override
	public int compare(Object o1, Object o2) {
		Corrida c1 = (Corrida)o1;
		Corrida c2 = (Corrida)o2;
		
		if(c1.getData().isAfter(c2.getData())) {
			return -1;
		} else if (c1.getData().isBefore(c2.getData())) {
			return 1;
		}
		return 0;
	}

}
