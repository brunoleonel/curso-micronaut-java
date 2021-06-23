package com.example;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

@Controller("${hello.controller.path}")
public class HelloWorldController {

    private final HelloService service;

    public HelloWorldController(final HelloService service) {
        this.service = service;
    }

    @Get("/")
    public String index() {
        return service.sayHi();
    }
}
