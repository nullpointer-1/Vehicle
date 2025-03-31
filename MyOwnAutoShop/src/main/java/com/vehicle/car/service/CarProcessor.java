package com.vehicle.car.service;

import java.util.List;

import com.vehicle.car.model.Car;
import com.vehicle.car.model.SUV;
import com.vehicle.car.model.Sedan;

public class CarProcessor {
    public void processCars(List<Car> cars) {
    for (Car car : cars) {
    // Polymorphic call - the correct getSalePrice() will be called based on actual type
    double salePrice = car.getSalePrice();
    String description = car.getDescription();
    
    System.out.println(description + " - Sale Price: " + salePrice);
    
    // You can add type-specific processing
    if (car instanceof SUV) {
    SUV suv = (SUV) car;
    System.out.println("This is an SUV with weight: " + suv.getWeight());
    } else if (car instanceof Sedan) {
    Sedan sedan = (Sedan) car;
    System.out.println("This is a Sedan from year: " + sedan.getYear());
    }
    }
    }
    }
