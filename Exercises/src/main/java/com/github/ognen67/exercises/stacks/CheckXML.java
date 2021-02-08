package com.github.ognen67.exercises.stacks;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.NoSuchElementException;


public class CheckXML {

    public static int valid(String[] redovi, ArrayStack<String> tagStack) {
        for(int i =0 ; i< redovi.length; i++){
            if(redovi[i].charAt(0) == '[' && redovi[i].charAt(redovi[i].length()-1) == ']' && redovi[i].charAt(1) != '/'){
                tagStack.push(redovi[i]);
            }
            else if (redovi[i].charAt(0) == '[' && redovi[i].charAt(redovi[i].length()-1) == ']' && redovi[i].charAt(1) == '/') {
                String top = tagStack.peek();
                if(redovi[i].substring(2, redovi[i].length() - 1).equals(top.substring(1, top.length() - 1))) {
                    tagStack.pop();
                }
            }
        }
        if(tagStack.isEmpty()) return 1;
        return 0;
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int n = Integer.parseInt(s);
        String[] redovi = new String[n];

        for (int i = 0; i < n; i++) {
            redovi[i] = br.readLine();
        }

        int valid;
        ArrayStack<String> tagStack = new ArrayStack<>(1000);

        // Your code here
        // You can use additional functions

        valid = valid(redovi, tagStack);
        System.out.println(valid);

        br.close();
    }
}
