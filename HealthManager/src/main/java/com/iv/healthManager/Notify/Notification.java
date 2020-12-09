package com.iv.healthManager.Notify;

import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Notification {

    @Autowired
    private final Contact contact;

    public Notification(Contact contact) {
        this.contact = contact;
    }

    public void sendNotification(String number,String message){

        Message message1=Message.creator(
                new PhoneNumber(number),
                new PhoneNumber(this.contact.getMynum()), message)
                .create();

        System.out.println(message1.getSid());

    }
    public void sendMultiple(String message){
        for (String t : this.contact.getContacts()) {
            sendNotification(t, message);
        }
    }


}
