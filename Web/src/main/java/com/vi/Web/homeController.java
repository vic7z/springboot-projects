package com.vi.Web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class homeController {
    @RequestMapping("/")
    public String home(@RequestParam("name") String name) {
        System.out.println("hello" + name);
        return "home";
    }

    @RequestMapping("/home")
    public String h1(@RequestParam("name") String MyName) {
        System.out.println(MyName);
        return "home";
    }

    @RequestMapping("/person")
    public void person(person person) {
        System.out.println("homeController.person");
        System.out.println("person = " + person.getName());
        System.out.println("person id= " + person.getId());
    }
}
