package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class Reservation {
	
	private Integer roomNumber;
	private Date checkinDate;
	private Date checkoutDate;
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	public Reservation() {
		
	}

	public Reservation(Integer roomNumber, Date checkinDate, Date checkoutDate) {
		this.roomNumber = roomNumber;
		this.checkinDate = checkinDate;
		this.checkoutDate = checkoutDate;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckinDate() {
		return checkinDate;
	}

	public void setCheckinDate(Date checkinDate) {
		this.checkinDate = checkinDate;
	}

	public Date getCheckoutDate() {
		return checkoutDate;
	}

	public void setCheckoutDate(Date checkoutDate) {
		this.checkoutDate = checkoutDate;
	}
	
	public long duration() {
		long diff = checkoutDate.getTime() - checkinDate.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
   @Override
   public String toString() {
	   return "Reservation  :"+
               "Room :"+
			   getRoomNumber()+
			   ", "+
			   "check-in: "+
			    sdf.format(checkinDate)+
			    ", check-out: "+
			    sdf.format(checkoutDate)+
			    ", "+ 
			    duration()+
			    "  nights";

   }
}
