package com.maksimkaxxl.springsecurityapp.services;

import com.github.javafaker.Faker;
import com.maksimkaxxl.springsecurityapp.models.Application;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.IntStream;

@Service
public class AppService {

    private List<Application> applications;

    @PostConstruct
    public void loadAppInDB() {
        Faker faker = new Faker();
        applications = IntStream.rangeClosed(1, 100)
                .mapToObj(i -> Application.builder()
                        .id(i)
                        .name(faker.app().name())
                        .author(faker.app().author())
                        .version(faker.app().version())
                        .build())
                .toList();
    }

    public List<Application> allApplications() {
        return applications;
    }


    public Application applicationById(int id) {
        return applications.stream()
                .filter(app -> app.getId() == id)
                .findFirst()
                .orElse(null);
    }

}
