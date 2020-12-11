package com.vi.mongodbDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@SpringBootApplication
@EnableSwagger2
public class StudentManager {

    public static void main(String[] args) {
        SpringApplication.run(StudentManager.class, args);
    }

    @Bean
    public Docket swaggerConfiguration(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .paths(PathSelectors.ant("/student/*"))
                .apis(RequestHandlerSelectors.basePackage("com.vi"))
                .build()
                .apiInfo(apiDetails());
    }

    private ApiInfo apiDetails(){
        return new ApiInfo(
                "Timetable Manager Api",
                "Sample Api for timetable Management",
                "1.2",
                "free to use",
                new springfox.documentation.service.Contact("vic","http://github.com/vic7z","touchwithvictor@gmail.com"),
                "API Licence",
                "http://github.com/vic7z",
                Collections.emptyList()
        );
    }



}
