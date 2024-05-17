package it.epicode.U4S5L5weeklyproject.services;

import it.epicode.U4S5L5weeklyproject.entities.Building;
import it.epicode.U4S5L5weeklyproject.exceptions.BuildingNotFoundException;
import it.epicode.U4S5L5weeklyproject.repositories.BuildingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuildingService {
    @Autowired
    BuildingRepository buildingRepository;

    public List<Building> findAllBuildings() {
        return buildingRepository.findAll();
    }

    public Building findBuildingById(long id) {
        return buildingRepository.findById(id).orElseThrow(()-> new BuildingNotFoundException(id));
    }

    public void saveBuilding(Building building) {
        buildingRepository.save(building);
    }

    public void deleteBuilding(long id) {
        buildingRepository.deleteById(id);
    }
}
