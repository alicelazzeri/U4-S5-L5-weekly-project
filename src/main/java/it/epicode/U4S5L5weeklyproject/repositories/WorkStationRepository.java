package it.epicode.U4S5L5weeklyproject.repositories;

import it.epicode.U4S5L5weeklyproject.entities.WorkStation;
import it.epicode.U4S5L5weeklyproject.entities.enums.WorkStationType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkStationRepository extends JpaRepository<WorkStation, Long> {
    @Query("SELECT ws FROM WorkStation ws INNER JOIN ws.building b WHERE ws.workStationType = ?1 AND b.city = ?2")
    List<WorkStation> findByWorkStationTypeAndCity(WorkStationType workStationType, String city);
}
