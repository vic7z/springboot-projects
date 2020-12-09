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
    private String id;
    private String name;
    private Location location;
    //private Contact contact;
    private Health health;

    public Driver(String id, String name) {
        this.id = id;
        this.name = name;
    }


}
