package com.iv.healthManager.Notify;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Data
@Service
public class Contact {
    private final String mynum="+12512573853";
    private List<String> contacts;

    public Contact() {
        contacts=new ArrayList<>();
    }
    public void addContact(String contact){
        contacts.add(contact);
    }
}
