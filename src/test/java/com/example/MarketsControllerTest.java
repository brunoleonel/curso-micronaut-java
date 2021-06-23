package com.example;

import io.micronaut.http.client.RxHttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import java.util.LinkedHashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@MicronautTest
public class MarketsControllerTest {

    @Inject
    @Client("/")
    RxHttpClient client;

    @Test
    public void testGetAllMarkets() {
        final List<LinkedHashMap> result = client.toBlocking().retrieve("/markets", List.class);
        assertEquals(7, result.size());
        assertThat(result)
            .extracting(entry -> entry.get("value"))
            .containsExactlyInAnyOrder("AAPL", "AMZN", "FB", "GOOG", "MSFT", "NFLX", "TSLA");
    }
}
