package com.assesment.bookingapi.bookingRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.assesment.bookingapi.bookingModel.Booking;
import com.assesment.bookingapi.credentialmodel.Credential;

@Component
public interface BookingRepository
		extends JpaRepository<Booking, Integer> {

	public Credential findByEmailAndPassWord(String email,
			String password);

}
