/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Davcode.logistic.repo;

import Davcode.logistic.domain.Mark;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author a.davydov
 */
public interface MarkRepo extends JpaRepository<Mark, Long> {
    
}
