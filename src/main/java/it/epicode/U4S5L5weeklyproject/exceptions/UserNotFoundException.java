package it.epicode.U4S5L5weeklyproject.exceptions;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException (String username) {
        super ("User with the following username: " + username + " not found.");
    }
}
