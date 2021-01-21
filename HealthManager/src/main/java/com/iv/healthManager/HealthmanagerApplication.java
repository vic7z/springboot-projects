package com.iv.healthManager;

import com.iv.healthManager.Notify.twillioconfig;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@SpringBootApplication
@EnableSwagger2
public class HealthmanagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(HealthmanagerApplication.class, args);
    }
    @Bean
    public Docket swaggerConfiguration(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
               // .paths(PathSelectors.ant("/healthcare/*"))
                .build()
                .apiInfo(appDetails());
    }


    private ApiInfo appDetails() {
        return new ApiInfo(
                "Health Management Api",
                "sample Api for health management",
                "1.1",
                "free of use",
                new Contact("dev","http://google.com","abc@xyz.com"),
                "API Licence",
                "http://google.com",
                Collections.emptyList()
        );
    }

}
