package com.github.ognen67.exercises.lists;

import java.util.*;
import java.util.function.Predicate;

public class PasswordsPolicy {

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

        long wrongPasswords = lines.stream().filter(Predicate.not(PasswordsPolicy::passwordIsValid)).count();
        System.out.println(wrongPasswords);

    }

    private static boolean passwordIsValid(String policyWithPassword) {
        String[] split1 = policyWithPassword.split(":");
        if (split1.length != 2) {
            throw new IllegalArgumentException("The password policy should be separated by a ':' but it was: " + policyWithPassword);
        }
        String policy = split1[0].trim();
        String password = split1[1].trim();

        String[] numberOfOccurrences = policy.split(" ");
        String repeatingChar = numberOfOccurrences[0];
        String occurrences = numberOfOccurrences[1];
        String[] numbers = occurrences.split("-");

        int num1 = Integer.parseInt(numbers[0]);
        int num2 = Integer.parseInt(numbers[1]);

        String passwordWithoutRepeatingChar = password.replaceAll(repeatingChar, "");

        int differenceOfLengths = password.length() - passwordWithoutRepeatingChar.length();

        return differenceOfLengths == num1 || differenceOfLengths == num2;
    }
}