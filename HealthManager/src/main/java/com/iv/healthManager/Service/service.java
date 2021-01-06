package com.iv.healthManager.Service;

import com.iv.healthManager.Model.Bus;
import com.iv.healthManager.Model.Conductor;
import com.iv.healthManager.Model.Driver;
import com.iv.healthManager.Model.Health;
import com.iv.healthManager.Notify.Contact;
import com.iv.healthManager.Notify.Notification;
import com.iv.healthManager.Notify.Sms;
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
    private final Sms message;


    @Autowired
    public service(com.iv.healthManager.Repository.driverRepo driverRepo, Notification notification, Contact contact, Sms message) {
        this.driverRepo = driverRepo;
        this.notification = notification;
        this.contact = contact;
        this.message = message;
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
   public void sendSms(Sms sms){
        this.notification.sendNotification(sms.getNumber(),sms.getMessage());
   }
   private void addContact(Contact contact){
        this.contact.addContact(contact.getMynum());
   }
   private void sendMultipleSmS(Sms message){
        notification.sendMultiple(message.getMessage());
   }
   private ResponseEntity<Driver> updateDriverDetails(String id, Health health){
        Driver driver=driverRepo.findById(id).orElse(new Driver());
        driver.setHealth(health);
        final Driver updatedDriver=driverRepo.save(driver);
        return ResponseEntity.ok(updatedDriver);
   }

   public Health getHealth(String id){
        Optional<Driver> dr=getById(id);
        if (dr.isEmpty()){
            return null;
        }else {
            return dr.get().getHealth();
        }
   }


    public void update(Driver driver) {
        this.driverRepo.save(driver);
    }
    public void delete(String id){
        this.driverRepo.deleteById(id);
    }
    public void addRoute(String id,String route){
        Driver driver=driverRepo.findById(id).orElse(null);
        if (driver!=null){
            driver.getBus().addRoute(route);
        }
    }
    public void setBusDetails(String id, Bus bus){
        Driver driver=driverRepo.findById(id).orElse(new Driver());
        if (driver!=null){
            driver.setBus(bus);
        }
    }
    public List<String> getRoute(String id){
        Driver driver=driverRepo.findById(id).orElse(new Driver());
        if (driver!=null){
          return driver.getBus().getRoutes();
        }else {
            return null;
        }
    }
    public void setConductor(String id, Conductor conductor){
        Driver driver=driverRepo.findById(id).orElse(new Driver());
        if (driver!=null){
            driver.getBus().setConductor(conductor);
        }
    }
    public Conductor getConductor(String id ){
        Optional<Driver> dr=getById(id);
        if (dr.isEmpty()){
            return null;
        }else {
            return dr.get().getBus().getConductor();
        }
    }
    public void setConductorHealth(String id,Health health) {
        Conductor conductor = getConductor(id);
        if (conductor != null) {
            conductor.setHealth(health);
        }
    }

}
