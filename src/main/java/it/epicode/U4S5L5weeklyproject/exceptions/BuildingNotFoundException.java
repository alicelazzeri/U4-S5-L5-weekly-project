package it.epicode.U4S5L5weeklyproject.exceptions;

public class BuildingNotFoundException extends RuntimeException {
    public BuildingNotFoundException (long id) {
        super("Building with the following id: " + id + " not found.");
    }
}
