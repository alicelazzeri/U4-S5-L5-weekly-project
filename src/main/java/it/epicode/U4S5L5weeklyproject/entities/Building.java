package it.epicode.U4S5L5weeklyproject.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "buildings")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder (setterPrefix = "with")

public class Building {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private long id;

    @Column
    private String buildingName;
    @Column
    private String buildingAddress;
    @Column
    private String City;

    @OneToMany (mappedBy = "building")
    private List<WorkStation> workStations = new ArrayList<>();
}
