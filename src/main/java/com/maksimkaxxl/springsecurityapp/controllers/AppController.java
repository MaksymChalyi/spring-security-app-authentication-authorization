package com.maksimkaxxl.springsecurityapp.controllers;

import com.maksimkaxxl.springsecurityapp.models.Application;
import com.maksimkaxxl.springsecurityapp.services.AppService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/apps")
@AllArgsConstructor
public class AppController {

    private AppService service;

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to the unprotected page";
    }

    @GetMapping("/all-app")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public List<Application> allApplications() {
        return service.allApplications();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public Application applicationByID(@PathVariable int id) {
        return service.applicationById(id);
    }

}
