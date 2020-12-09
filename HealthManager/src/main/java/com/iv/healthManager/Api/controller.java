package com.iv.healthManager.Api;

import com.iv.healthManager.Model.Driver;
import com.iv.healthManager.Service.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/healthcare")
public class controller {
    public final service service;
    public final com.iv.healthManager.Repository.driverRepo driverRepo;

    @Autowired
    public controller(service service, com.iv.healthManager.Repository.driverRepo driverRepo) {
        this.service = service;
        this.driverRepo = driverRepo;
    }

    @GetMapping("/all")
    public List<Driver> getAll(){
        return this.service.getAll();
    }

    @PostMapping("/add")
    public void add(@RequestBody Driver driver){
        this.service.add(driver);
    }

    @GetMapping("/{id}")
    public Optional<Driver> getById(@PathVariable  String id){
        return  this.service.getById(id);
    }




}
