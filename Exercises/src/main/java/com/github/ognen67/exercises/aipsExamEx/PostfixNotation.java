package com.github.ognen67.exercises.aipsExamEx;

import com.github.ognen67.exercises.stacks.LinkedStack;

public class PostfixNotation {

    public static void main(String[] args) {
        String expression = "60 80 * 20 40 * /";
        String[] chars = expression.split("\\s");
        LinkedStack<Integer> stack = new LinkedStack<>();

        for (String c : chars) {
            switch (c) {
                case "+" -> stack.push(stack.pop() + stack.pop());
                case "-" -> {
                    int s1 = stack.pop();
                    int s2 = stack.pop();
                    stack.push(s2-s1);
                }
                case "*" -> stack.push(stack.pop() * stack.pop());
                case "/" -> {
                    int s1 = stack.pop();
                    int s2 = stack.pop();
                    stack.push(s2/s1);
                }
                default -> stack.push(Integer.parseInt(c));
            }
        }

        System.out.println(stack.pop());

    }
}

