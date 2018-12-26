package com.codeonblue.cars.service;

import com.codeonblue.cars.model.Car;

import java.util.List;

public interface CarService {

    List<Car> findAll();

    Car save(Car car);
}
