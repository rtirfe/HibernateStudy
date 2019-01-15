package com.robel.hibernatedemo;

import com.robel.hibernatedemo.Repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HibernatedemoApplication {

    @Autowired
    private static AccountRepository repository;
    public static void main(String[] args) {
        SpringApplication.run(HibernatedemoApplication.class, args);
    }

}

