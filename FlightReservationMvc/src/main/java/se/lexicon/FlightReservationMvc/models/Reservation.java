package se.lexicon.FlightReservationMvc.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Reservation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID;
	
	private int totalCost;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "seatID")
	private Seat seat;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "foodID")
	private Food food;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "passengerID")
	private Passenger passenger;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "flightID")
	private Flight flight;

	public int getTotalCost() {
		return totalCost;
	}

	public void setTotalCost() {
		this.totalCost = seat.getPrice() + food.getPrice();

	}

	public Seat getSeat() {
		return seat;
	}

	public void setSeat(Seat seat) {
		this.seat = seat;
	}

	public Food getFood() {
		return food;
	}

	public void setFood(Food food) {
		this.food = food;
	}

	public Passenger getPassenger() {
		return passenger;
	}

	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public int getID() {
		return ID;
	}

	@Override
	public String toString() {
		return "Reservation [ID=" + ID + ", totalCost=" + totalCost + ", seat=" + seat + ", food=" + food
				+ ", passenger=" + passenger + ", flight=" + flight + "]";
	}
	
	


	
}
