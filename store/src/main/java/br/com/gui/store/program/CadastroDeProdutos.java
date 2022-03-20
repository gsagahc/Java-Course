package br.com.gui.store.program;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.gui.store.entities.Produto;

public class CadastroDeProdutos {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Produto produto = new Produto();
		System.out.println("Digite o nome:");
		produto.setNome(sc.nextLine());
		System.out.println("Digite uma descrição:");
		produto.setDescricao(sc.nextLine());
		System.out.println("Digite o preço:");
		produto.setPreco(sc.nextBigDecimal()); 
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("store");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		em.persist(produto);
		em.getTransaction().commit();
		em.close();
		
	}

}
