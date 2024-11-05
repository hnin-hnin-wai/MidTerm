package edu.miu.cse.garden.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name="Plants")
public class Plant {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="plant_id")
    private Integer id;
    private String name;
    private String type;
    private LocalDate plantDate;

    @ManyToOne
    @JoinColumn(name="garden_id")
    Garden garden;

    public Plant(String name, String type, LocalDate plantDate) {
        this.name = name;
        this.type = type;
        this.plantDate = plantDate;
    }

    public Plant(String name, String type, LocalDate plantDate, Garden garden) {
        this.name = name;
        this.type = type;
        this.plantDate = plantDate;
        this.garden = garden;
    }

    @Override
    public String toString() {
        return "Plant{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", plantDate=" + plantDate +
                '}';
    }
}
