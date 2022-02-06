package entities.services;

import java.util.List;

public class calculationService {

	public static<G extends Comparable<G>> G max(List<G>list) {
		if (list.isEmpty()) {
			throw new IllegalStateException("Lista não pode ser vazia");
		}
		G max = list.get(0);
		for (G item : list) {
			if (item.compareTo(max)>0) {
				max = item;
			}
		}
	return max;

	}

}
