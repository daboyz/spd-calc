package com.calculatoria.testdata;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class TestData{

    public static Stream<Arguments> additionTestDataProvider() {
            return Stream.of(
            Arguments.of("1", "2", "3"),
            Arguments.of("2.1", "3.4", "5.5"),
            Arguments.of("-4.3","2.1","-2.2")
            );
    }

    public static Stream<Arguments> subtractionTestDataProvider() {
        return Stream.of(
                Arguments.of("1", "2", "-1"),
                Arguments.of("-2.1", "(-3.4)", "1.3"),
                Arguments.of("-4.3","2.1","-6.4")
        );
    }

    public static Stream<Arguments> multiplicationTestDataProvider() {
        return Stream.of(
                Arguments.of("3", "2", "6"),
                Arguments.of("2.1", "3.4", "7.14"),
                Arguments.of("-4.3","2.1","-9.03")
        );
    }

    public static Stream<Arguments> divisionTestDataProvider() {
        return Stream.of(
                Arguments.of("1", "2", "0.5"),
                Arguments.of("2.5", "3.25", "0.769"),
                Arguments.of("-4.3","2.1","-2.048")
        );
    }
}
