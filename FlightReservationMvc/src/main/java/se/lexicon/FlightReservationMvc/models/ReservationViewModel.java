package se.lexicon.FlightReservationMvc.models;



public class ReservationViewModel {

	private int passengerID;
	private int flightID;	
	private int seatID; 
	private int foodID;
	
	public int getPassengerID() {
		return passengerID;
	}
	public void setPassengerID(int passengerID) {
		this.passengerID = passengerID;
	}
	public int getFlightID() {
		return flightID;
	}
	public void setFlightID(int flightID) {
		this.flightID = flightID;
	}
	public int getSeatID() {
		return seatID;
	}
	public void setSeatID(int seatID) {
		this.seatID = seatID;
	}
	public int getFoodID() {
		return foodID;
	}
	public void setFoodID(int foodID) {
		this.foodID = foodID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + flightID;
		result = prime * result + foodID;
		result = prime * result + passengerID;
		result = prime * result + seatID;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReservationViewModel other = (ReservationViewModel) obj;
		if (flightID != other.flightID)
			return false;
		if (foodID != other.foodID)
			return false;
		if (passengerID != other.passengerID)
			return false;
		if (seatID != other.seatID)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "ReservationViewModel [passengerID=" + passengerID + ", flightID=" + flightID + ", seatID=" + seatID
				+ ", foodID=" + foodID + "]";
	}
	
	
	




}




