package se.lexicon.FlightReservationMvc.controllers;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import se.lexicon.FlightReservationMvc.data_access.FlightDaoImpl;
import se.lexicon.FlightReservationMvc.data_access.FoodDaoImpl;
import se.lexicon.FlightReservationMvc.data_access.PassengerDaoImpl;
import se.lexicon.FlightReservationMvc.data_access.ReservationDaoImpl;
import se.lexicon.FlightReservationMvc.data_access.SeatDaoImpl;
import se.lexicon.FlightReservationMvc.models.Reservation;
import se.lexicon.FlightReservationMvc.models.ReservationViewModel;
import se.lexicon.FlightReservationMvc.models.Seat;

@Controller
public class FlightReservationController {

@Autowired
private PassengerDaoImpl passengerDao;

@Autowired
private FlightDaoImpl flightDao;

@Autowired
private FoodDaoImpl foodDao;

@Autowired
private ReservationDaoImpl reservationDao;

@Autowired
private SeatDaoImpl seatDao;

@GetMapping("/index")
public String index()
{
return "index";
}

@GetMapping("/passenger")
public String choosePassenger(Model model) {
	
model.addAttribute("reservationViewModel", new ReservationViewModel());
model.addAttribute("allPassengers", passengerDao.findAll());
return "passenger";
}

@PostMapping("/flight")
public String flightRes(@ModelAttribute ReservationViewModel reservationViewModel, Model model ) {
	
	model.addAttribute("reservationViewModel", reservationViewModel);
	model.addAttribute("allFlights", flightDao.findAll());
	return "flight";
}
@PostMapping("/seat")
public String seatRes(@ModelAttribute ReservationViewModel reservationViewModel, Model model  ) {

	model.addAttribute("reservationViewModel", reservationViewModel);
	model.addAttribute("allSeats", seatDao.findAll());
	
	List<Seat> flightSeats = flightDao.findById(reservationViewModel.getFlightID()).getSeats();
	
	List<Seat> availableSeats = new ArrayList<>();
	
	for (Seat seat : flightSeats) {
		if (!seat.isReserved()) {
			availableSeats.add(seat);
		}
	}
	model.addAttribute("allSeats", availableSeats);
	
	return "seat";
}

@PostMapping("/food")
public String foodRes(@ModelAttribute ReservationViewModel reservationViewModel, Model model  ) {
	
	model.addAttribute("reservationViewModel", reservationViewModel);
	model.addAttribute("allFood", foodDao.findAll());
	

	return "food";
}

@PostMapping("/receipt")
public String resultObj(@ModelAttribute ReservationViewModel reservationViewModel, 
		Model model )
{
	Reservation reservation = new Reservation();
	reservation.setPassenger(passengerDao.findById(reservationViewModel.getPassengerID()));
	reservation.setFlight(flightDao.findById(reservationViewModel.getFlightID()));
	reservation.setSeat(seatDao.findById(reservationViewModel.getSeatID()));
	reservation.setFood(foodDao.findById(reservationViewModel.getFoodID()));
	reservation.setTotalCost();
	seatDao.findById(reservationViewModel.getSeatID()).setIsReserved(true);
	
	reservationDao.save(reservation);
	model.addAttribute("reservation", reservation);
	return "receipt";
}


}


