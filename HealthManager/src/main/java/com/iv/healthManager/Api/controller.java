package com.iv.healthManager.Api;

import com.iv.healthManager.Model.Driver;
import com.iv.healthManager.Model.Health;
import com.iv.healthManager.Notify.Sms;
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
    @GetMapping("/getHealth/{id}")
    public Health getHealth(@PathVariable String id){
        return this.service.getHealth(id);
    }
    @PutMapping("/Driver/{id}")
    public void update(@PathVariable String id,@RequestBody Driver driver){
        this.service.update(driver);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id){
        this.service.delete(id);
    }
    @PostMapping("/notify")
    public void notify(@RequestBody Sms sms){
        this.service.sendSms(sms);
    }

}
