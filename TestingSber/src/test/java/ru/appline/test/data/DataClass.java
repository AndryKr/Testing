package ru.appline.test.data;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class DataClass {

    public static Stream<Arguments> getData() {
        return Stream.of(
                Arguments.of("Иванов", "Николай", "Петрович", "NIKOLAI IVANOV"),
                Arguments.of("Петров", "Иван", "Николаевич", "IVAN PETROV"),
                Arguments.of("Николаев", "Пётр", "Иванович", "PETR NIKOLAEV"));
    }
}
