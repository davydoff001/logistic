/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Davcode.logistic.controller;

import Davcode.logistic.domain.Car;
import Davcode.logistic.repo.CarRepo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author a.davydov
 */
@RestController
@RequestMapping("api/car")
public class CarController extends AbstractRestController<Car, CarRepo>{

    public CarController(CarRepo repo) {
        super(repo);
    }
    
}
