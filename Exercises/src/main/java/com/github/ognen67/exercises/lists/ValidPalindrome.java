package com.github.ognen67.exercises.lists;

import java.util.Arrays;
import java.util.stream.Stream;

public class ValidPalindrome {

    public boolean isPalindrome(String s) {

        s=s.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");
        System.out.println(s);

        char[] charArray = s.toCharArray();

        char[] reversedCharArray = new char[charArray.length];

        int j= charArray.length-1;
        for (int i = 0; i < charArray.length; i++) {
            reversedCharArray[i] = charArray[j--];
        }

        System.out.println(Arrays.toString(charArray));
        System.out.println(Arrays.toString(reversedCharArray));

        return Arrays.toString(charArray).equals(Arrays.toString(reversedCharArray));
    }

    public static void main(String[] args) {
        ValidPalindrome p = new ValidPalindrome();
        System.out.println(p.isPalindrome("A man, a plan, a canal: Panama"));
    }
}
