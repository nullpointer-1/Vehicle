package com.vehicle.car.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vehicle.car.service.CarService;

@Controller
@RequestMapping("/")
public class MarketPlaceController {
@Autowired
private CarService carService;

@GetMapping
public String showMarketplace(Model model) {
model.addAttribute("cars", carService.getAllCars());
return "marketplace";
}

@GetMapping("/suvs")
public String showSuvs(Model model) {
model.addAttribute("cars", carService.getAllSuvs());
model.addAttribute("title", "SUVs");
return "marketplace";
}

@GetMapping("/sedans")
public String showSedans(Model model) {
model.addAttribute("cars", carService.getAllSedans());
model.addAttribute("title", "Sedans");
return "marketplace";
}
}
