package it.epicode.U4S5L5weeklyproject.repositories;

import it.epicode.U4S5L5weeklyproject.entities.User;
import it.epicode.U4S5L5weeklyproject.entities.WorkStation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
}
