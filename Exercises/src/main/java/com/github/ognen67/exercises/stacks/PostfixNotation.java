package com.github.ognen67.exercises.stacks;

public class PostfixNotation {

    public static void main(String[] args) {
        String phrase = "28 72 * 13 + 20 67 * +";
        String[] expression = phrase.split("\\s");
        LinkedStack<Integer> stack = new LinkedStack<>();

        for (String s : expression) {
            switch (s) {
                case "+" -> stack.push(stack.pop() + stack.pop());
                case "-" -> stack.push(stack.pop() - stack.pop());
                case "*" -> stack.push(stack.pop() * stack.pop());
                case "/" -> stack.push(stack.pop() / stack.pop());
                default -> stack.push(Integer.parseInt(s));
            }
        }
        System.out.println(stack.peek());
    }
}
