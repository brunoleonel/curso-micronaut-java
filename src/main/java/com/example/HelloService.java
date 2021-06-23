package com.example;

import javax.inject.Singleton;

@Singleton
public class HelloService {

    public String sayHi() {
        return "Hi";
    }
}
