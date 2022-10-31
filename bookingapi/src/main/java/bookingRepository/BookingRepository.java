package bookingRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import bookingModel.Booking;

public interface BookingRepository extends JpaRepository<Booking, Integer> {

}
