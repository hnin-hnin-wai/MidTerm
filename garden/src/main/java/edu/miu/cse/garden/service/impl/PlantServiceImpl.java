package edu.miu.cse.garden.service.impl;

import edu.miu.cse.garden.model.Plant;
import edu.miu.cse.garden.repository.PlantRepository;
import edu.miu.cse.garden.service.PlantService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlantServiceImpl implements PlantService {
    private PlantRepository plantRepository;

    @Override
    public Optional<Plant> addPlant(Plant plant) {
        Plant savedPlant =plantRepository.save(plant);
        return Optional.of(savedPlant);
    }

    @Override
    public Optional<Plant> getPlant(String plantName) {

        return plantRepository.findByName(plantName);
    }

    @Override
    public void deletePlant(String plantName) {
        plantRepository.findByName(plantName).ifPresent(plantRepository::delete);
    }

    @Override
    public List<Plant> getAllPlants() {
        return plantRepository.findAll();
    }

    @Override
    public Optional<Plant> updatePlant(Plant plant) {
        Optional<Plant> foundplant=plantRepository.findByName(plant.getName());
        foundplant.ifPresent(plantRepository::save);
        return foundplant;
    }

    @Override
    public List<Plant> getPlantsByNameASC() {
        return plantRepository.findPlantOrderByNameAsc();
    }

    @Override
    public List<Plant> getPlantsByPlantDateASC() {
        return plantRepository.findPlantOrderByPlantDateAsc();
    }

}
