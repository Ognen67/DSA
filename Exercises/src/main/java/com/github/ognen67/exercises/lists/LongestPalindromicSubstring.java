package com.github.ognen67.exercises.lists;

public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {

        char[] charArray = s.toCharArray();

        if(charArray.length == 2) {
            return String.valueOf(charArray[0]);
        }

        int left;
        int right;
        int middle;
        int count = 0;

        if (charArray.length % 2 == 0) {
            left = (charArray.length - 1) / 2;
            right = (charArray.length - 1) / 2 + 1;
        } else {
            left = (charArray.length - 1) / 2 - 1;
            right = (charArray.length - 1) / 2 + 1;
        }

        while (left >=0 && right < charArray.length) {
            if (charArray[left] == charArray[right]) {
                count++;
                left--;
                right++;
            } else {
                break;
            }
        }

        return s.substring(left+1, right);

    }

    public static void main(String[] args) {
        LongestPalindromicSubstring longestPalindromicSubstring = new LongestPalindromicSubstring();
        System.out.println(longestPalindromicSubstring.longestPalindrome("ac"));
    }
}
