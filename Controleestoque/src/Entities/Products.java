package Entities;

public class Products {
	public String name;
	public double price;
	public int quantity;
	
	public double totalValueInStock() {
		return price * quantity;
	}
	
	public void addProduct(int quantity) {
		this.quantity += quantity;
		
	}
	
	public void removeProducts(int quantity) {
		this.quantity -= quantity;
		
	}
    public String toString() {
    	return  ("Nome: "+ name + " , "+"Preço: $"+ price 
    			           + " , "+ "Quantidade: "+ quantity+
    			           "  Valor total: $" + totalValueInStock());
    }
}
