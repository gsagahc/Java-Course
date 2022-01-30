package model.services;

import model.entities.CarRental;
import model.entities.Invoice;

public class RentalService {
	private Double pricePerDay;
	private Double pricePerHour;
	
	private TaxService taxservice;
	
	
	public RentalService(Double pricePerDay, Double pricePerHour, TaxService taxservice) {
		this.pricePerDay = pricePerDay;
		this.pricePerHour = pricePerHour;
		this.taxservice = taxservice;
	}
	public void processInvoice(CarRental carrental) {
		long t1 = carrental.getStart().getTime();
		long t2 = carrental.getFinish().getTime();
		double hours = (double) (t2 - t1)/1000/ 60 / 60;
		
		double basicPayment;
		if (hours <= 12.0) {
			basicPayment = Math.ceil(hours) * pricePerHour;
		}
		else {
			basicPayment = Math.ceil(hours/24)*pricePerDay;
		}
		
		double tax = taxservice.tax(basicPayment);
		carrental.setInvoice(new Invoice(basicPayment, tax));
	}
	

}
