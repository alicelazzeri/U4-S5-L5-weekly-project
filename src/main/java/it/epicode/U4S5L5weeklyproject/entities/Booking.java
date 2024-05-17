package it.epicode.U4S5L5weeklyproject.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table (name = "bookings")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder (setterPrefix = "with")

public class Booking {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private long id;

    @Column
    private LocalDate bookingDate;

    @ManyToOne
    @JoinColumn (name = "work_station_id")
    private WorkStation workStation;

    @ManyToOne
    @JoinColumn (name = "user_id")
    private User user;
}
