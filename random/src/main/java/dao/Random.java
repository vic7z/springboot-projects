package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class Random {
    List<person> personList = new ArrayList<>();


    private List<person> random(int num) {
        java.util.Random random = new java.util.Random();
        String name = "name" + random.nextInt(10);
        for (int i = 0; i < num; i++) {
            personList.add(new person(UUID.randomUUID(), name));
        }
        return personList;
    }

    public List<person> ran() {
        java.util.Random random = new java.util.Random();
        String name = "name" + random.nextInt(10);
        for (int i = 0; i < 5; i++) {
            personList.add(new person(UUID.randomUUID(), name));
        }
        return personList;
    }


}
