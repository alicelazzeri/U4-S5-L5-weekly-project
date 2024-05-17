package it.epicode.U4S5L5weeklyproject.repositories;

import it.epicode.U4S5L5weeklyproject.entities.Booking;
import it.epicode.U4S5L5weeklyproject.entities.User;
import it.epicode.U4S5L5weeklyproject.entities.WorkStation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByWorkStationAndBookingDate (WorkStation workStation, LocalDate bookingDate);
    List<Booking> findByUserAndBookingDate (User user, LocalDate bookingDate);
}
