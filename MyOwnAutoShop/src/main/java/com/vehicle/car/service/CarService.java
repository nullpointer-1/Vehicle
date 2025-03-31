package com.vehicle.car.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vehicle.car.model.Car;
import com.vehicle.car.model.SUV;
import com.vehicle.car.model.Sedan;
import com.vehicle.car.repository.CarRepository;
import com.vehicle.car.repository.SedanRepository;
import com.vehicle.car.repository.SuvRepository;

@Service
public class CarService {
@Autowired
private CarRepository carRepository;

@Autowired
private SuvRepository suvRepository;

@Autowired
private SedanRepository sedanRepository;

public List<Car> getAllCars() {
return carRepository.findAll();
}

public Car saveCar(Car car) {
return carRepository.save(car);
}

public List<SUV> getAllSuvs() {
return suvRepository.findAll();
}

public List<Sedan> getAllSedans() {
return sedanRepository.findAll();
}
}
