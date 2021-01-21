package com.iv.healthManager.Notify;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "twilio")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class twillioconfig {
    private String AUTH_TOKEN;
    private String ACCOUNT_SID;
    private String myNumber;
}
