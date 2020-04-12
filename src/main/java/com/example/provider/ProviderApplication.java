package com.example.provider;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProviderApplication.class, args);
    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Person {
    int id;
    String first;
    String last;
    int age;
    String[] likes;
}
