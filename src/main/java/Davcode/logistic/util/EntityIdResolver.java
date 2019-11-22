/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Davcode.logistic.util;

import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdResolver;
import javax.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author a.davydov
 */
public class EntityIdResolver implements ObjectIdResolver{

    private EntityManager entityManager;

    @Autowired
    public EntityIdResolver(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
       
    @Override
    public void bindItem(ObjectIdGenerator.IdKey id, Object o) {
        
    }

    @Override
    public Object resolveId(ObjectIdGenerator.IdKey id) {
        return entityManager.find(id.scope, Long.parseLong(id.key.toString()));
    }

    @Override
    public ObjectIdResolver newForDeserialization(Object o) {
        return this;
    }

    @Override
    public boolean canUseFor(ObjectIdResolver oir) {
        return false;
    }
    
}
