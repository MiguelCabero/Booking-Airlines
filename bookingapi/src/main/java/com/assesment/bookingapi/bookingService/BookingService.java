package com.assesment.bookingapi.bookingService;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.assesment.bookingapi.bookingModel.Booking;
import com.assesment.bookingapi.bookingRepository.BookingRepository;

@Component
public class BookingService {

	@Autowired
	private BookingRepository bookingRepository;

	public ResponseEntity<Booking> addBooking(Booking booking) {
		final Booking savedBooking = bookingRepository.save(booking);
		final URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedBooking.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
}
