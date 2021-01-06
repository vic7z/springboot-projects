package com.iv.healthManager.Api;

import com.iv.healthManager.Model.Bus;
import com.iv.healthManager.Model.Conductor;
import com.iv.healthManager.Model.Driver;
import com.iv.healthManager.Model.Health;
import com.iv.healthManager.Notify.Sms;
import com.iv.healthManager.Service.service;
import io.swagger.annotations.ApiOperation;
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
    @ApiOperation(
            value = "get all driver details from the database"
    )
    public List<Driver> getAll(){
        return this.service.getAll();
    }

    @PostMapping("/add")
    @ApiOperation(
            value = "add new driver to the database"
    )
    public void add(@RequestBody Driver driver){
        this.service.add(driver);
    }

    @GetMapping("/{id}")
    @ApiOperation(
            value = "get  driver details for a particular driver from the database"
    )
    public Optional<Driver> getById(@PathVariable  String id){
        return  this.service.getById(id);
    }
    @GetMapping("/getHealth/{id}")
    @ApiOperation(
            value = "get health  details of the driver from the database"
    )
    public Health getHealth(@PathVariable String id){
        return this.service.getHealth(id);
    }
    @PutMapping("/Driver/{id}")
    @ApiOperation(
            value = "update the driver details "
    )
    public void update(@PathVariable String id,@RequestBody Driver driver){
        this.service.update(driver);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(
            value = "Delete the driver with the id"
    )
    public void delete(@PathVariable String id){
        this.service.delete(id);
    }
    @PostMapping("/notify")
    @ApiOperation(
            value = "send alert notification to the contats "
    )
    public void notify(@RequestBody Sms sms){
        this.service.sendSms(sms);
    }
    @PutMapping("/Driver/bus/{id}")
    @ApiOperation(
            value = "set  the bus details for a driver"
    )
    public void setBusDetails(@PathVariable String id,@RequestBody Bus bus){
        this.service.setBusDetails(id,bus);
    }
    @GetMapping("/Driver/bus/{id}")
    @ApiOperation(
            value = "get tyhe bus details from the database"
    )
    public Bus getBusDetails(@PathVariable String id){
        Bus bus = this.service.getById(id).orElse(null).getBus();
        return bus;
    }
    @PutMapping("/Driver/bus/conductor/{id}")
    @ApiOperation(
            value = "set the conductor details"
    )
    public void setConductor(@PathVariable String id,@RequestBody Conductor conductor){
        this.service.setConductor(id,conductor);
    }
    @GetMapping("/Driver/bus/conductor/{id}")
    public Conductor getDetails(@PathVariable  String id){
        return this.service.getConductor(id);
    }
//    @PutMapping("/Driver/bus/conductor/{id}")
//    public void setHealth(@PathVariable String id,@RequestBody Health health){
//        this.service.setConductorHealth(id,health);
//    }
//    @PutMapping("/Driver/bus/route/{id}/{route}")
//    public void addRoute(@PathVariable String id,@PathVariable String route){
//        this.service.addRoute(id,route);
//    }
//    @GetMapping("/Driver/bus/route/{id}")
//    public List<String> getRoute(@PathVariable String id){
//        return this.service.getRoute(id);
//    }



}
