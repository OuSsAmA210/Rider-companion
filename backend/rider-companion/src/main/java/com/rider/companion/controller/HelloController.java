package com.rider.companion.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //indique que la classe gère des requêtes REST.
public class HelloController {

    @GetMapping("/hello") //permet de créer une URL accessible en GET http://localhost:8081/hello
    public String hello() {
        return "Hello Rider Companion!";
    }
}