package com.github.ognen67.exercises.lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LargestNumber {


    public static List<String> readInput() {
        final Scanner scan = new Scanner(System.in);
        final List<String> items = new ArrayList<>();
        while (scan.hasNextLine()) {
            items.add(scan.nextLine());
        }
        return items;
    }

    public static void main(String[] args) {
        final List<String> lines = readInput();

        int max = Integer.parseInt(lines.get(0));
        for (String line : lines) {
            int num = Integer.parseInt(line);
            if(num > max) {
                max = num;
            }
        }

        System.out.println(max);
    }
}