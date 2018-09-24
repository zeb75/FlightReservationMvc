package se.lexicon.FlightReservationMvc.data_access;

import java.util.List;

import se.lexicon.FlightReservationMvc.models.Reservation;

public interface ReservationDao {

	Reservation save(Reservation reservation);

	Reservation update(Reservation reservation);

	Reservation findById(int id);

	void deleteReservation(int id);

	List<Reservation> findAll();

}