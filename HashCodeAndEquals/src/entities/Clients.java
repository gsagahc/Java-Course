package entities;

import java.util.Objects;

public class Clients {
	private String nome;
	private String email;
	private Integer id;
	
	public Clients() {
		
	}

	public Clients(String nome, String email, Integer id) {
		this.nome = nome;
		this.email = email;
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, id, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Clients other = (Clients) obj;
		return Objects.equals(email, other.email) && Objects.equals(id, other.id) && Objects.equals(nome, other.nome);
	}
	
	@Override
	public String toString() {
		String texto= "Nome: "+
					   getNome()+
					   "  "+
					   "email: "+
					   getEmail()+
					   " "+
					   "id: "+
					   getId();
		return texto;
	}

	
}
