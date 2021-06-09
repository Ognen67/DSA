package com.github.ognen67.exercises.aipsExamEx;

import com.github.ognen67.exercises.stacks.ArrayStack;

public class BalancedParentheses {


    public static void main(String[] args) {
        String phrase = "[](){}";

        ArrayStack<Character> stack = new ArrayStack<>(phrase.length());

        char[] chars = phrase.toCharArray();


        for (char aChar : chars) {
            if (aChar == '(' || aChar == '{' || aChar == '[') {
                stack.push(aChar);
            } else {
                if (stack.peek() == '(') {
                    stack.pop();
                } else if (aChar == '}') {
                    if (stack.peek() == '{') {
                        stack.pop();
                    }
                } else if (aChar == ']') {
                    if (stack.peek() == '[') {
                        stack.pop();
                    }
                }
            }
        }

        if (stack.isEmpty()) {
            System.out.println("Balanced");
        } else {
            System.out.println("Not balanced");
        }


    }
}
