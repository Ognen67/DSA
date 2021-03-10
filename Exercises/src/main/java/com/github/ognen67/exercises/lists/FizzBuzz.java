package com.github.ognen67.exercises.lists;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {

    public List<String> fizzBuzz(int n) {

        ArrayList<String> list = new ArrayList<>();

        int i=1;
        while (i <= n) {
            if (i % 3 == 0 && i % 5 == 0)
                list.add("FizzBuzz");
            else if (i % 3 == 0)
                list.add("Fizz");
             else if (i % 5 == 0)
                list.add("Buzz");
             else
                list.add(Integer.toString(i));
            i++;
        }

    return list;
}

    public static void main(String[] args) {
        FizzBuzz fb = new FizzBuzz();
        List<String> list = fb.fizzBuzz(1);

        for (String s : list) {
            System.out.println(s);
        }
    }
}
