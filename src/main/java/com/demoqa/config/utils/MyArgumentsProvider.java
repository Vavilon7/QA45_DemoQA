package com.demoqa.config.utils;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;
// Класс реализует интерфейс ArgumentsProvider для параметризации тестов в JUnit
public class MyArgumentsProvider implements ArgumentsProvider {
    // Метод предоставляет аргументы для параметрических тестов
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
        return Stream.of(arguments("Robert1", "Weide", "weide@gml.com", "1234567890"),
                arguments("Robert2", "Weide", "weide@gml.com", "1234567890"),
                arguments("Robert3", "Weide", "weide@gml.com", "1234567890"));
    }
}
