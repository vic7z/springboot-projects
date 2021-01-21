package com.iv.healthManager.Notify;

import com.twilio.Twilio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class twilioInitializer {
    private final static Logger logger= LoggerFactory.getLogger(twilioInitializer.class);
    private final twillioconfig configuration;
//    private  final String ACCOUNT_SID=configuration.getACCOUNT_SID();
//    private  final String AUTH_TOKEN= configuration.getAUTH_TOKEN(); ;
//    private  final String myNumber= configuration.getMyNumber();
    @Autowired
    public twilioInitializer(twillioconfig configuration) {
        this.configuration = configuration;
        Twilio.init(
                configuration.getACCOUNT_SID(),
                configuration.getAUTH_TOKEN()
        );
        logger.info("Twilio init....");
    }
}
