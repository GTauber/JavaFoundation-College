package com.tauber.atfundbarber;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AtFundBarberApplication {

    public static void main(String[] args) {
        SpringApplication.run(AtFundBarberApplication.class, args);
    }

}
