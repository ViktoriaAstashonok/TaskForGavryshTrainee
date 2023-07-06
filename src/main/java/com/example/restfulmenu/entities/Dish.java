package com.example.restfulmenu.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "menu")
public class Dish {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private double price;

    public Dish(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return id + "\t" + name + "\t" + price + "\n";
    }
}
