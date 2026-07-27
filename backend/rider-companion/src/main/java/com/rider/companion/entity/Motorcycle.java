package com.rider.companion.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "motorcy*les")
public class Motorcycle {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String brand;

    private String model;

    private Integer year;

    public Motorcycle() {
    }

    public Long getId() {
       return id;
    }

    public void setId(Long id) {
        this.id = id;
   }

    public String getBrand() {
       return brand;
   }

    public void setBrand(String brand) {
       this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }


}