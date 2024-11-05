package edu.miu.cse.garden.service.impl;

import edu.miu.cse.garden.model.Garden;
import edu.miu.cse.garden.repository.GardenRepository;
import edu.miu.cse.garden.service.GardenService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GardenServiceImpl implements GardenService {

    private final GardenRepository gardenRepository;

    @Override
    public Optional<Garden> addGarden(Garden garden) {
        Garden savedGarden=gardenRepository.save(garden);
        return Optional.of(savedGarden);
    }

    @Override
    public List<Garden> getAllGardens() {
        return gardenRepository.findAll();
    }

    @Override
    public Optional<Garden> getGardenByName(String name) {
        return gardenRepository.findByName(name);

    }

    @Override
    public Optional<Garden> updateGarden(Garden garden) {
        Optional<Garden> foundGarden=gardenRepository.findByName(garden.getName());
        foundGarden.ifPresent(gardenRepository::save);
        return foundGarden;
    }

    @Override
    public void deleteGarden(String name) {
        gardenRepository.findByName(name).ifPresent(garden -> gardenRepository.delete(garden));
    }


}
