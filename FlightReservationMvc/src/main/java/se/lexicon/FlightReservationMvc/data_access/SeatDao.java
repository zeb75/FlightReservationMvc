package se.lexicon.FlightReservationMvc.data_access;

import java.util.List;

import se.lexicon.FlightReservationMvc.models.Seat;

public interface SeatDao {

	Seat save(Seat seat);

	Seat update(Seat seat);

	Seat findById(int id);

	void deleteSeat(int id);

	List<Seat> findAll();

}