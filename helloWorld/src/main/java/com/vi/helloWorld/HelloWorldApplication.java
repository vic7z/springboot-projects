package com.vi.helloWorld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.UUID;

@SpringBootApplication
public class HelloWorldApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(HelloWorldApplication.class, args);

        person p1 = context.getBean(person.class);
        p1.setId(UUID.randomUUID());
        p1.setAdress(new Adress());
        System.out.println(p1.getAdress().getAdress());
        System.out.println(p1.getId());

        person p2 = context.getBean(person.class);
        p2.setId(UUID.randomUUID());
        System.out.println(p1.getId());
    }

}
