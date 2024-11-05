package edu.miu.cse.garden.service;

import edu.miu.cse.garden.model.Plant;

import java.util.List;
import java.util.Optional;

public interface PlantService {

    Optional<Plant> addPlant(Plant plant);
    Optional<Plant> getPlant(String plantName);
    void deletePlant(String plantName);
    List<Plant> getAllPlants();
    Optional<Plant> updatePlant(Plant plant); //change

    List<Plant> getPlantsByNameASC();

    List<Plant> getPlantsByPlantDateASC();



}
