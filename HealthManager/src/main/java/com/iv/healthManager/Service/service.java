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
       checkHealth(driver);

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
        checkHealth(driver);
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
        checkHealth(driver);
        this.driverRepo.save(driver);
    }
    public void delete(String id){
        this.driverRepo.deleteById(id);
    }
    public void addRoute(String id,String route){
        Driver driver=driverRepo.findById(id).orElse(null);
        if (driver!=null){
            driver.getBus().addRoute(route);
            this.driverRepo.save(driver);
        }
    }
    public void setBusDetails(String id, Bus bus){
        Driver driver=driverRepo.findById(id).orElse(new Driver());
        if (driver!=null){
            driver.setBus(bus);
        }
        this.driverRepo.save(driver);
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
            this.driverRepo.save(driver);
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
        Optional<Driver> dr=getById(id);
        if (dr.isEmpty()){

        }else {
            dr.get().getBus().getConductor().setHealth(health);
            this.driverRepo.save(dr.orElse(null));
        }
       
    }
    public void checkHealth(Driver driver){
        if(driver.getHealth().getHeartRate()<60 ||
                driver.getHealth().getHeartRate()>100 ||
                driver.getHealth().getTemperature()>38 ||
                driver.getHealth().getTemperature()<36 ||
                driver.getHealth().getSpo2Level()<90){
            this.notification.sendNotification(this.contact.getEmgnum(),"The recorded vitals of the driver" +
                    " indicates unusal signs \n" +
                    "Bus module :"+driver.getBus().getBusId()+
                    "\nDriver name :"+driver.getName()+
                    "\nLocation :"+driver.getLocation().toString()+
                    "\nTemperature :"+driver.getHealth().getTemperature()+
                    "\nSpo2 :"+driver.getHealth().getSpo2Level()+
                    "\nHeartRate :"+driver.getHealth().getHeartRate());
        }
    }

}
