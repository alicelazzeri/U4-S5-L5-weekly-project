package it.epicode.U4S5L5weeklyproject.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder (setterPrefix = "with")

public class User {
    @Id
    private String username;

    @Column
    private String fullName;
    @Column
    private String userEmail;

    @OneToOne (mappedBy = "user")
    private WorkStation workStation;

    @OneToMany (mappedBy = "user")
    private List<Booking> bookings = new ArrayList<>();
}
