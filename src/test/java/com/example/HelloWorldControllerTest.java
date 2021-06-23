package com.example;

import io.micronaut.http.client.RxHttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;

@MicronautTest
public class HelloWorldControllerTest {

    @Inject
    @Client("/")
    RxHttpClient client;

    @Test
    public void testHelloResponse() {
        final String result = client.toBlocking().retrieve("/hello");
        assertEquals("Hi", result);
    }
}
