package edu.miu.cse.garden;

import edu.miu.cse.garden.model.Garden;
import edu.miu.cse.garden.model.Plant;
import edu.miu.cse.garden.service.GardenService;
import edu.miu.cse.garden.service.PlantService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
@RequiredArgsConstructor
public class GardenApplication {

    private final GardenService gardenService;
    private final PlantService plantService;


    public static void main(String[] args) {
        SpringApplication.run(GardenApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner() {
        return args -> {
            //create garden
           Garden garden1 = new Garden("Vegetable Patch",50.0);
           Garden garden2 = new Garden("Herb Garden",20.0);

            gardenService.addGarden(garden1);
            gardenService.addGarden(garden2);

            System.out.println("Display All Garden: " );
            System.out.println("Gardens:");
                    gardenService.getAllGardens().forEach(System.out::println);

            //create plants
            Plant plant1 = new Plant("Tomato","Vegatable",LocalDate.parse("2024-03-01"),garden1);Plant plant2=new Plant("Carrot","Vegatable",LocalDate.parse("2024-02-20"),garden1);
           Plant plant3=new Plant("Basil","Herb",LocalDate.parse("2024-04-05"),garden2);
           plantService.addPlant(plant1);
           plantService.addPlant(plant2);
           plantService.addPlant(plant3);
           
           System.out.println("Display All Plants (Sorted By Name) " );
           System.out.println("Plants( sorted By Name):");
           plantService.getPlantsByNameASC().forEach(System.out::println);

           System.out.println("Display All Plants (Sorted By Plant date " );
           System.out.println("Plants( sorted By Plant Date):");
           plantService.getPlantsByPlantDateASC().forEach(System.out::println);

        };
    }

}
