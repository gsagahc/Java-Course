package entidades;

import java.util.Date;

public class Produto {
	private String nome;
	private Double preco;
	private Date data;
	
	public Produto() {
		
	}

	public Produto(String nome, Double preco, Date data) {
		this.nome = nome;
		this.preco = preco;
		this.data = data;
	}
	public Produto(String nome, Double preco) {
		this.nome = nome;
		this.preco = preco;
		
	}
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	public static String toUppercase(Produto p) {
		return p.getNome().toUpperCase();
	}
	
	

}
