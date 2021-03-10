package com.github.ognen67.exercises.streams;

import java.io.Serializable;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FizzBuzzStreams {

    public static void fizzBuzzStream(int n) {
        IntStream.range(1, n + 1)
                .mapToObj(FizzBuzzStreams::action)
                .forEach(System.out::println);

    }

    private static String action(int e) {
        if (e % 15 == 0) {
            return "FizzBuzz";
        } else if (e % 3 == 0) {
            return "Fizz";
        } else if (e % 5 == 0) {
            return "Buzz";
        } else {
            return Integer.toString(e);
        }
    }

    public static void main(String[] args) {
        fizzBuzzStream(15);
    }

}
