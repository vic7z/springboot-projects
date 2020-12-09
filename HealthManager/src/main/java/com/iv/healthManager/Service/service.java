package com.iv.healthManager.Service;

import com.iv.healthManager.Model.Driver;
import com.iv.healthManager.Model.Health;
import com.iv.healthManager.Notify.Contact;
import com.iv.healthManager.Notify.Notification;
import com.iv.healthManager.Repository.driverRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class service {
    public final driverRepo driverRepo;
    private final Notification notification;
    private final Contact contact;


    @Autowired
    public service(com.iv.healthManager.Repository.driverRepo driverRepo, Notification notification, Contact contact) {
        this.driverRepo = driverRepo;
        this.notification = notification;
        this.contact = contact;
    }


    public Optional<Driver> getDetails(String id){
        Optional<Driver> driver=this.driverRepo.findById(id);
        return driver;
    }
    public List<Driver> getAll(){
        return this.driverRepo.findAll();
    }

    public void add(Driver driver){
        if(driver.getHealth().getTemperature()>=42 ){
            this.notification.sendMultiple("temperature of "+driver.getName()+"is above "+driver.getHealth().getTemperature());
        }
        this.driverRepo.save(driver);
    }
   public Optional< Driver> getById(String id){
        return this.driverRepo.findById(id);
   }
   private void sendSms(String number,String message){
        this.notification.sendNotification(number,message);
   }
   private void addContact(String contact){
        this.contact.addContact(contact);
   }
   private void sendMultipleSmS(String message){
        notification.sendMultiple(message);
   }
   private ResponseEntity<Driver> updateDriverDetails(String id, Health health){
        Driver driver=driverRepo.findById(id).orElse(new Driver());
        driver.setHealth(health);
        final Driver updatedDriver=driverRepo.save(driver);
        return ResponseEntity.ok(updatedDriver);
   }


}
