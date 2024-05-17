package it.epicode.U4S5L5weeklyproject.repositories;

import it.epicode.U4S5L5weeklyproject.entities.WorkStation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkStationRepository extends JpaRepository<WorkStation, Long> {
}
