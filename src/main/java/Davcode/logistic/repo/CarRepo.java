/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Davcode.logistic.repo;

import Davcode.logistic.domain.Car;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author a.davydov
 */
public interface CarRepo extends JpaRepository<Car, Long>{
    
    @Override
    @EntityGraph(attributePaths = {"model.mark"})
    Page<Car> findAll(Pageable pageable);
    
}
