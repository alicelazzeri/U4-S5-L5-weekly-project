package it.epicode.U4S5L5weeklyproject.exceptions;

public class BookingNotFoundException extends RuntimeException {
    public BookingNotFoundException(long id) {
        super("Booking with the following id: " + id + " not found.");
    }
}
