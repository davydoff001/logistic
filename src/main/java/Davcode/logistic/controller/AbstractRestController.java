/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Davcode.logistic.controller;

import Davcode.logistic.domain.ComboListItem;
import Davcode.logistic.dto.ListItemDto;
import java.util.List;
import java.util.stream.Collectors;
import javafx.print.Collation;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author a.davydov
 */
public abstract class AbstractRestController<T extends ComboListItem, R extends JpaRepository<T, ?>> {
    
    protected R repo;

    public AbstractRestController(R repo) {
        this.repo = repo;
    }
    
    @GetMapping
    public Page<T> list(@PageableDefault Pageable pageable){
        return repo.findAll(pageable);
    }
    
    @GetMapping("{id}")
    public T getOne(@PathVariable("id") T obj){
        return obj;
    }
    
    @PostMapping
    public T add(@RequestBody T obj){
        return repo.save(obj);
    }
    
    @PutMapping("{id}")
    public T update(@PathVariable("id") T dbObj, @RequestBody T obj){
        BeanUtils.copyProperties(obj, dbObj, "id");
        return repo.save(dbObj);
    }
    
    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") T dbObj){
        repo.delete(dbObj);
    }
    
    @GetMapping("list")
    public List<ListItemDto> list(){
        return repo.findAll()
                .stream()
                .map(entity -> new ListItemDto(entity.getId(), entity.getName()))
                .collect(Collectors.toList());
    }
}
