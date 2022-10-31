package com.assesment.bookingapi.bookingController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.assesment.bookingapi.bookingModel.Booking;
import com.assesment.bookingapi.bookingService.BookingService;

import jakarta.validation.Valid;

@CrossOrigin
@RestController
public class BookingController {

	@Autowired
	private BookingService bookingService;

	@PostMapping(path = "/api/bookings")
	public ResponseEntity<Booking> addBooking(@Valid @RequestBody Booking booking) {
		return bookingService.addBooking(booking);
	}
}
