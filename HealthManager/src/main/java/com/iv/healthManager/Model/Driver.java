package com.iv.healthManager.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection ="Drivers")
public class Driver {
    @Id
    private String id;
    private String name;
    private Location location;
    //private Contact contact;
    private Health health;
    private Bus bus;

    public Driver(String DriverID, String name) {
        this.id = DriverID;
        this.name = name;
    }


}
