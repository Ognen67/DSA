package com.github.ognen67.exercises.lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.*;

public class FridayTheThirteenth {

    public static List<String> readInput() {
        final Scanner scan = new Scanner(System.in);
        final List<String> items = new ArrayList<>();
        while(scan.hasNextLine()){
            items.add(scan.nextLine());
        }
        return items;
    }

    public static void main(String[] args) {
        final List<String> lines = readInput();

        long[] numbers = lines.stream().mapToLong(Long::parseLong).toArray();

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i+1; j < numbers.length; j++) {
                for (int k = j+1; k < numbers.length; k++) {
                    if(numbers[i] + numbers[j] + numbers[k] == 2021) {
                        System.out.println(numbers[i] * numbers[j] * numbers[k]);
                        return;
                    }
                }
            }
        }
    }
}