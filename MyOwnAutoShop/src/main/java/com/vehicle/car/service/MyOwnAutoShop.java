package com.vehicle.car.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vehicle.car.model.Car;

@Service
public class MyOwnAutoShop {

    @Autowired
    private CarService carService;

    public void processUserData() {
        List<Car> allCars = carService.getAllCars(); 
        CarProcessor processor = new CarProcessor();
        processor.processCars(allCars);
    }
}

