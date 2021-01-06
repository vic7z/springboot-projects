package com.iv.healthManager.Model;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "Conductor Details")
public class Conductor {
    private String ConductorId;
    private String name;
    private Health health;


}
