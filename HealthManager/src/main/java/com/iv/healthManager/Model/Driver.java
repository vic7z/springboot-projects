package com.iv.healthManager.Model;

import com.iv.healthManager.Notify.Contact;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection ="Drivers")
public class Driver {
    @Id
    private String DriverId;
    private String name;
    private Location location;
    //private Contact contact;
    private Health health;
    private Bus bus;

    public Driver(String id, String name) {
        this.DriverId = id;
        this.name = name;
    }


}
