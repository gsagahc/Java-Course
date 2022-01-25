package entities;

public class ImportedProduct extends Product{
	private Double customsfee;
	
	public ImportedProduct() {
		super();
	}

	public ImportedProduct(String name, Double price, Double customsfee) {
		super(name, price);
		this.customsfee = customsfee;
	}
	
	public Double getCustomsfee() {
		return customsfee;
	}

	public void setCustomsfee(Double customsfee) {
		this.customsfee = customsfee;
	}
    public Double totalPrice () {
    	return getPrice() + customsfee;
    }
	@Override
    public String priceTag() {
		String tag = getName()+
			     "$ "+
			     totalPrice()+
			     "  ("+
			     "Customs fee: "+
			     "  $ "+
			     getCustomsfee()+
			     " )";
	
		return tag;	
	}
 }

