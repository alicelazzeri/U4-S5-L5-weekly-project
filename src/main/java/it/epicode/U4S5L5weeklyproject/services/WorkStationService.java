package it.epicode.U4S5L5weeklyproject.services;

import it.epicode.U4S5L5weeklyproject.entities.enums.WorkStationType;
import it.epicode.U4S5L5weeklyproject.exceptions.WorkStationNotFoundException;
import it.epicode.U4S5L5weeklyproject.entities.WorkStation;
import it.epicode.U4S5L5weeklyproject.repositories.WorkStationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkStationService {
    @Autowired
    WorkStationRepository workStationRepository;

    public List<WorkStation> findAllWorkStations() {
        return workStationRepository.findAll();
    }

    public WorkStation findWorkStationById(long id) {
        return workStationRepository.findById(id).orElseThrow(() -> new WorkStationNotFoundException(id));
    }

    public void saveWorkStation(WorkStation workStation) {
        workStationRepository.save(workStation);
    }

    public void deleteWorkStation(long id) {
        workStationRepository.deleteById(id);
    }

    public List<WorkStation> findWorkStationsByWorkStationTypeAndCity(WorkStationType workStationType, String city) {
        return workStationRepository.findByWorkStationTypeAndCity(workStationType, city);
    }
}
