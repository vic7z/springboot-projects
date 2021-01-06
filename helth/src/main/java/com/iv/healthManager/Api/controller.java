package com.iv.healthManager.Api;

import com.iv.healthManager.Model.patients;
import com.iv.healthManager.Model.Health;
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
    public final com.iv.healthManager.Repository.PatientsRepo patientsRepo;

    @Autowired
    public controller(service service, com.iv.healthManager.Repository.PatientsRepo patientsRepo) {
        this.service = service;
        this.patientsRepo = patientsRepo;
    }

    @GetMapping("/all")
    @ApiOperation(
            value = "get all stud details from the database"
    )
    public List<patients> getAll(){
        return this.service.getAll();
    }

    @PostMapping("/add")
    public void add(@RequestBody patients patients){
        this.service.add(patients);
    }

    @GetMapping("/{id}")
    public Optional<patients> getById(@PathVariable  String id){
        return  this.service.getById(id);
    }
    @GetMapping("/getHealth/{id}")
    public Health getHealth(@PathVariable String id){
        return this.service.getHealth(id);
    }
    @PutMapping("/patients/{id}")
    public void update(@PathVariable String id,@RequestBody patients patients){
        this.service.update(patients);
    }



}
