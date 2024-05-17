package it.epicode.U4S5L5weeklyproject.entities;

import it.epicode.U4S5L5weeklyproject.entities.enums.WorkStationType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table (name = "work_stations")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder (setterPrefix = "with")

public class WorkStation {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private long id;

    @Column
    private String description;
    @Enumerated (EnumType.STRING)
    private WorkStationType workStationType;
    @Column
    private int maxOccupants;

    @ManyToOne
    @JoinColumn (name = "building_id")
    private Building building;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;


}
