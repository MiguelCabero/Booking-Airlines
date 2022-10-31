package bookingController;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import bookingModel.Booking;
import bookingService.BookingService;

@CrossOrigin
@RestController
public class BookingController {

	private BookingService bookingService;

	@PostMapping(path = "/api/bookings")
	public ResponseEntity<Booking> addBooking(Booking booking) {
		return bookingService.addBooking(booking);
	}
}
