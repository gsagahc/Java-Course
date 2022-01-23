package Entities;

public class BusinessAccount extends Account{
	private Double loanlimit;
	
	public BusinessAccount() {
		
	}

	public BusinessAccount(Integer number, String holder, Double balance, Double loanlimit) {
		super(number, holder, balance);
		this.loanlimit = loanlimit;
	}

	public Double getLoanlimit() {
		return loanlimit;
	}

	public void setLoanlimit(Double loanlimit) {
		this.loanlimit = loanlimit;
	}
	public void loan(Double amount) {
		if (amount <= loanlimit) {
			deposit(amount);
		}
	}
}
