package com.codeonblue.cars.resource;

import com.codeonblue.cars.model.Car;
import com.codeonblue.cars.service.CarService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("/api/cars")
public class CarResource {

    Logger logger = LoggerFactory.getLogger(CarResource.class);

    private final CarService carService;

    public CarResource(CarService carService) {
        this.carService = carService;
    }

    @GetMapping({"","/"})
    public ResponseEntity<List<Car>> getAllCars(){
        List<Car> list = carService.findAll().stream()
                .filter(this::isCool)
                .collect(Collectors.toList());
        logger.info(" >>> Application endpoint accessed - Request: GET - 200");
        return ResponseEntity.ok().body(list);
    }

    private boolean isCool(Car car) {
        return !car.getName().equals("AMC Gremlin") &&
                !car.getName().equals("Triumph Stag") &&
                !car.getName().equals("Ford Pinto") &&
                !car.getName().equals("Yugo GV");
    }
}
