package com.example.store;

import com.example.model.Symbol;

import javax.inject.Singleton;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Singleton
public class InMemoryStore {

    private final List<Symbol> symbols;

    public InMemoryStore(List<Symbol> symbols) {
        this.symbols = Stream.of("AAPL", "AMZN", "FB", "GOOG", "MSFT", "NFLX", "TSLA")
            .map(Symbol::new)
            .collect(Collectors.toList());
    }

    public List<Symbol> getAllSymbols() {
        return symbols;
    }
}
