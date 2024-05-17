package it.epicode.U4S5L5weeklyproject.services;

import it.epicode.U4S5L5weeklyproject.entities.Booking;
import it.epicode.U4S5L5weeklyproject.entities.User;
import it.epicode.U4S5L5weeklyproject.entities.WorkStation;
import it.epicode.U4S5L5weeklyproject.exceptions.BookingNotFoundException;
import it.epicode.U4S5L5weeklyproject.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {
    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    WorkStationService workStationService;

    public List<Booking> findAllBookings() {
        return bookingRepository.findAll();
    }

    public Booking findBookingById(long id) {
        return bookingRepository.findById(id).orElseThrow(() -> new BookingNotFoundException(id));
    }

    public void saveBooking(Booking booking) {
        List<Booking> existingBookings = bookingRepository.findByWorkStationAndBookingDate(booking.getWorkStation(), booking.getBookingDate());
        List<Booking> userBookings = bookingRepository.findByUserAndBookingDate(booking.getUser(), booking.getBookingDate());
        WorkStation workStation = booking.getWorkStation();
        User user = booking.getUser();
        if (!existingBookings.isEmpty()) {
            throw new IllegalStateException("It is impossible to book a reservation. The work station was already booked on this date.");
        } else if (!userBookings.isEmpty()) {
            throw new IllegalStateException("It is impossible to book a reservation. The user has already booked another work station for this date.");
        } else if (workStation != null && user != null) {
            workStation.setUser(user);
            workStationService.saveWorkStation(workStation);
        } else {
            bookingRepository.save(booking);
        }
    }

    public void deleteBooking(long id) {
        bookingRepository.deleteById(id);
    }
}
