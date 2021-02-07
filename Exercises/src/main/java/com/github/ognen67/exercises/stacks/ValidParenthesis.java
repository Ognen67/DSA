package com.github.ognen67.exercises.stacks;

public class ValidParenthesis {

    public static boolean check(String s) {
        char[] zagradi = s.toCharArray();
        LinkedStack<Character> stack = new LinkedStack<>();

        for (char c : zagradi) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (c == ')') {
                    if (stack.peek() == '(') {
                        stack.pop();
                    }
                } else if (c == ']') {
                    if (stack.peek() == '[') {
                        stack.pop();
                    }
                } else if (c == '}') {
                    if (stack.peek() == '{') {
                        stack.pop();
                    }
                }
            }
        }
        return stack.isEmpty();
    }


    public static void main(String[] args) {

        String str = "s * (s – a) * (s – b + (s – c)";

        System.out.println(check(str));
    }
}
