package com.iv.healthManager.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection ="Patients")
public class patients {
    @Id
    private String id;
    private String name;
    private labReport labReport;
    //private Contact contact;
    private Health health;

    public patients(String id, String name) {
        this.id = id;
        this.name = name;
    }


}
