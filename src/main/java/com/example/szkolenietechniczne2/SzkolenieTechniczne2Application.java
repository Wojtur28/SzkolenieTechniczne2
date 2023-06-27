package com.example.szkolenietechniczne2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = {
        org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class,}
)
public class SzkolenieTechniczne2Application {

    public static void main(String[] args) {
        SpringApplication.run(SzkolenieTechniczne2Application.class, args);
    }

}
