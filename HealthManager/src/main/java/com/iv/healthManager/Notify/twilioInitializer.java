package com.iv.healthManager.Notify;

import com.twilio.Twilio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
public class twilioInitializer {
    private final static Logger logger= LoggerFactory.getLogger(twilioInitializer.class);
    private static final String ACCOUNT_SID = "ACce2346b5e6d1aa47edb7fb70ce46df0e";
    private static final String AUTH_TOKEN ="ca04c949d3439e11712dc1e70be95d8d";
    private static final String myNumber="";

    public twilioInitializer() {
        Twilio.init(
                ACCOUNT_SID,
                AUTH_TOKEN
        );
        logger.info("Twilio init....");
    }
}
