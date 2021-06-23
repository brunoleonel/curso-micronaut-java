package com.example.controller;

import com.example.model.Symbol;
import com.example.store.InMemoryStore;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

import java.util.ArrayList;
import java.util.List;

@Controller("/markets")
public class MarketsController {

    private InMemoryStore store;

    public MarketsController(InMemoryStore store) {
        this.store = store;
    }

    @Get("/")
    public List<Symbol> all() {
        return store.getAllSymbols();
    }
}
