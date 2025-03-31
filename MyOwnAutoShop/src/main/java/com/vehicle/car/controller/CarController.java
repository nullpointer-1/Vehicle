package com.vehicle.car.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.vehicle.car.model.Car;
import com.vehicle.car.model.SUV;
import com.vehicle.car.model.Sedan;
import com.vehicle.car.service.CarService;

@Controller
@RequestMapping("/api/cars")
public class CarController {
    @Autowired
    private CarService carService;

    @PostMapping("/add")
    public String addCar(@RequestParam Map<String, String> params, RedirectAttributes redirectAttributes) {
        try {
            String type = params.get("type");
            Car car;

            if ("SUV".equalsIgnoreCase(type)) {
                SUV suv = new SUV();
                suv.setModel(params.get("model"));
                suv.setColor(params.get("color"));
                suv.setSpeed(Integer.parseInt(params.get("speed")));
                suv.setRegularPrice(Double.parseDouble(params.get("regularPrice")));
                suv.setFuelType(params.get("fuelType"));
                suv.setTransmission(params.get("transmission"));
                suv.setWeight(Integer.parseInt(params.getOrDefault("weight", "0")));
                suv.setIs4wd(params.containsKey("is4wd"));
                suv.setHasThirdRowSeat(params.containsKey("hasThirdRowSeat"));
                car = suv;
            } else if ("Sedan".equalsIgnoreCase(type)) {
                Sedan sedan = new Sedan();
                sedan.setModel(params.get("model"));
                sedan.setColor(params.get("color"));
                sedan.setSpeed(Integer.parseInt(params.get("speed")));
                sedan.setRegularPrice(Double.parseDouble(params.get("regularPrice")));
                sedan.setFuelType(params.get("fuelType"));
                sedan.setTransmission(params.get("transmission"));
                sedan.setYear(Integer.parseInt(params.getOrDefault("year", "0")));
                sedan.setManufacturerDiscount(Double.parseDouble(params.getOrDefault("manufacturerDiscount", "0")));
                sedan.setHasSunroof(params.containsKey("hasSunroof"));
                car = sedan;
            } else {
                redirectAttributes.addFlashAttribute("error", "Invalid car type selected!");
                return "redirect:/marketplace";
            }

            carService.saveCar(car);
            redirectAttributes.addFlashAttribute("success", "Car added successfully!");

        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Failed to add car. Please try again.");
        }

        return "redirect:/marketplace"; // Redirect to the marketplace page with success/error messages
    }

    @GetMapping("/marketplace")
    public String showMarketplace(Model model) {
        model.addAttribute("cars", carService.getAllCars());
        return "marketplace";
    }
}
