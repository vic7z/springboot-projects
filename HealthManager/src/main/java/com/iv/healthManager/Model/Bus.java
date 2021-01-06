package com.iv.healthManager.Model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@ApiModel(description = "Bus module")
public class Bus {
    @ApiModelProperty(notes = "id of the bus")
    private String BusId;
    private int no;
    private Conductor conductor;
    private List<String> routes;

    public Bus() {
        routes=new ArrayList();
    }
    public void addRoute(String route){
        routes.add(route);
    }

}
