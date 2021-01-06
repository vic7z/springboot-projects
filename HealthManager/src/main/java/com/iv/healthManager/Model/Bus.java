package com.iv.healthManager.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class Bus {
    private String id;
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
