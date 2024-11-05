package edu.miu.cse.garden.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Garden {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="garden_id")
    private Integer id;
    private String name;
    private Double size;

//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    private List<Plant> plants;

    public Garden(String name, Double size) {
        this.name = name;
        this.size = size;
    }


    @Override
    public String toString() {
        return "Garden{" +
                "name='" + name + '\'' +
                ", size=" + size +
                '}';
    }
}
