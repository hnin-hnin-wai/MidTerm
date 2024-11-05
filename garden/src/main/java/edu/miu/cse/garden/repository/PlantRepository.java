package edu.miu.cse.garden.repository;

import edu.miu.cse.garden.model.Plant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlantRepository extends JpaRepository<Plant, Integer> {

    Optional<Plant> findByName(String plantName);
    Optional<Plant> findByType(String plantType);

    @Query("select p from Plant p order by p.name asc")
    List<Plant> findPlantOrderByNameAsc();

    @Query("select p from Plant p order by p.plantDate asc")
    List<Plant> findPlantOrderByPlantDateAsc();



}
