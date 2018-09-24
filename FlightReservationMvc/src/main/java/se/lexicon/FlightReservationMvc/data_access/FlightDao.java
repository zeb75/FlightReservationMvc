package se.lexicon.FlightReservationMvc.data_access;

import java.util.List;

import se.lexicon.FlightReservationMvc.models.Flight;

public interface FlightDao {

	Flight save(Flight flight);

	Flight update(Flight flight);

	Flight findById(int id);

	void deleteFlight(int id);

	List<Flight> findAll();

}