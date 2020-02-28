/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Davcode.logistic.domain;

import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.Data;

/**
 *
 * @author a.davydov
 */
@Entity
@Data
public class Car implements ComboListItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    
    @ManyToOne
    @JsonIdentityReference
    @JsonSerialize(as=ComboListItem.class)
    private Model model;
}
