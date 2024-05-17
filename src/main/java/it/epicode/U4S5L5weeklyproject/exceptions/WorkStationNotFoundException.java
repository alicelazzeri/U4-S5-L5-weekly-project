package it.epicode.U4S5L5weeklyproject.exceptions;

public class WorkStationNotFoundException extends RuntimeException {
    public WorkStationNotFoundException(long id) {
        super("Work station with the following id: " + id + " not found.");
    }
}
