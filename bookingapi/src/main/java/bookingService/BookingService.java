package bookingService;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import bookingModel.Booking;
import bookingRepository.BookingRepository;

public class BookingService {

	private BookingRepository bookingRepository;

	public ResponseEntity<Booking> addBooking(Booking booking) {
		final Booking savedBooking = bookingRepository.save(booking);
		final URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedBooking.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
}
