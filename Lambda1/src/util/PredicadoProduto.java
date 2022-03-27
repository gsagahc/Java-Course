package util;

import java.util.function.Predicate;

import entidades.Produto;

public class PredicadoProduto implements Predicate<Produto>{

	@Override
	public boolean test(Produto p) {
		return p.getPreco()>= 30.0 ;
	}

}
