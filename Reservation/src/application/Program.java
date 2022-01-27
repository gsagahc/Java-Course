package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {
	
	public static void main(String[] args)  {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.println("Room number: ");
			int number = sc.nextInt();
			System.out.println("Check-in date (dd/MM/yyyy): ");
			Date checkin = sdf.parse(sc.next());
			System.out.println("Check-out date (dd/MM/yyyy): ");
			Date checkout = sdf.parse(sc.next());
			Reservation reserva = new Reservation(number, checkin, checkout ); 
			System.out.println(reserva.toString());		 
		
			
		} catch (ParseException e) {
			System.out.println("Ivalid date format");
			
		}
		
		finally {
			sc.close();
		}
  }
}