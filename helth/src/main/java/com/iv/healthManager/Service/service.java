package com.iv.healthManager.Service;

import com.iv.healthManager.Model.patients;
import com.iv.healthManager.Model.Health;
import com.iv.healthManager.Notify.Contact;
import com.iv.healthManager.Notify.Notification;
import com.iv.healthManager.Repository.PatientsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class service {
    public final PatientsRepo patientsRepo;
    private final Notification notification;
    private final Contact contact;


    @Autowired
    public service(com.iv.healthManager.Repository.PatientsRepo patientsRepo, Notification notification, Contact contact) {
        this.patientsRepo = patientsRepo;
        this.notification = notification;
        this.contact = contact;
    }


    public Optional<patients> getDetails(String id){
        Optional<patients> patients=this.patientsRepo.findById(id);
        return patients;
    }
    public List<patients> getAll(){
        return this.patientsRepo.findAll();
    }

    public void add(patients patients){
        if(patients.getHealth().getTemperature()>=42 ){
            this.notification.sendMultiple("temperature of "+ patients.getName()+"is above "+ patients.getHealth().getTemperature());
        }
        this.patientsRepo.save(patients);
    }
   public Optional<patients> getById(String id){
        return this.patientsRepo.findById(id);
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
   private ResponseEntity<patients> updateDriverDetails(String id, Health health){
        patients patients = patientsRepo.findById(id).orElse(new patients());
        patients.setHealth(health);
        final patients updatedPatients = patientsRepo.save(patients);
        return ResponseEntity.ok(updatedPatients);
   }

   public Health getHealth(String id){
        Optional<patients> dr=getById(id);
        if (dr.isEmpty()){
            return null;
        }else {
            return dr.get().getHealth();
        }
   }


    public void update(patients patients) {
        this.patientsRepo.save(patients);
    }
}
