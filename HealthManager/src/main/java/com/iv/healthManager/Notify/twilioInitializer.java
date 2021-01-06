package com.iv.healthManager.Notify;

import com.twilio.Twilio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
public class twilioInitializer {
    private final static Logger logger= LoggerFactory.getLogger(twilioInitializer.class);
    private static final String ACCOUNT_SID = "ACd1cf5be9fbb98bde54baba93cbe5e4e9";
    private static final String AUTH_TOKEN ="b3f03622a21a5f6212fe4af086e334e5";
    private static final String myNumber="+12512573853";

    public twilioInitializer() {
        Twilio.init(
                ACCOUNT_SID,
                AUTH_TOKEN
        );
        logger.info("Twilio init....");
    }
}
