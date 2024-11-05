package edu.miu.cse.garden.service;

import edu.miu.cse.garden.model.Garden;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface GardenService {
    Optional<Garden> addGarden(Garden garden);
    List<Garden> getAllGardens();
    Optional<Garden> getGardenByName(String name);
    Optional<Garden> updateGarden(Garden garden);
    void deleteGarden(String name);

}
