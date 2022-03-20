package br.com.alura.loja.testes;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.loja.dao.CategoriaDao;
import br.com.alura.loja.dao.ProdutoDao;
import br.com.alura.loja.modelo.Categoria;
import br.com.alura.loja.modelo.Produto;
import br.com.alura.loja.util.JPAUtil;

public class CadastroDeProduto {
	
	public static void main(String[] args) {
		cadastrar();
		
		
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDao produtoDao = new ProdutoDao(em);
		Produto p = produtoDao.buscarPosId(1l);
		
		System.out.println(p.getPreco());	
		
		List<Produto> todos = produtoDao.buscarTodos();
		todos.forEach(p2 -> System.out.println(p2.getNome()));
		
		Produto p3 = produtoDao.buscarNome("Xiaomi Redmi");
		System.out.println(p3.getNome());
		
		List<Produto> categoria = produtoDao.buscarCategoria("CELULARES");
		categoria.forEach(p4 -> System.out.println("Nome:  "+p4.getNome()));
		
		BigDecimal precoDoProduto = produtoDao.buscarPreco("Xiaomi Redmi");
		System.out.println("Preço do produto: " + precoDoProduto);
		
	}

	private static void cadastrar() {
		Categoria celulares = new Categoria("CELULARES");
		Produto celular = new Produto("Xiaomi Redmi", "Muito legal", new BigDecimal("800"), LocalDate.now(),celulares );
		
		
		EntityManager em = JPAUtil.getEntityManager();
		CategoriaDao categoriaDao = new CategoriaDao(em);
		ProdutoDao produtoDao = new ProdutoDao(em);
		
		
		em.getTransaction().begin();
		
		categoriaDao.cadastrar(celulares);
		produtoDao.cadastrar(celular);
		
		em.getTransaction().commit();
		em.close();
	}

}
