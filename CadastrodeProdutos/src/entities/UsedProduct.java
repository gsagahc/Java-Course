package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UsedProduct extends Product{
	private Date manufacterddate;
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	public UsedProduct() {
		super();
	}

	public UsedProduct(String name, Double price, Date manufacterddate) {
		super(name, price);
		this.manufacterddate = manufacterddate;
	}

	public Date getManufacterddate() {
		return manufacterddate;
	}

	public void setManufacterddate(Date manufacterddate) {
		this.manufacterddate = manufacterddate;
	}
	@Override
    public String priceTag() {
		String tag = getName()+
			     "(used)  $ "+
			     getPrice()+
			     "  ("+
			     "Manufacture date: "+
			     sdf.format(getManufacterddate())+
			     " )";
	
		return tag;	
	}

}
