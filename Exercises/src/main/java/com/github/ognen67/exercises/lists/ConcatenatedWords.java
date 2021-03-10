package com.github.ognen67.exercises.lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConcatenatedWords {

    public List<String> findAllConcatenatedWordsInADict(String[] words) {

        int count = 0;
        List<String> resultList = new ArrayList<>();

        for (String s : words) {
            count = 0;
            for (String word : words) {
                if (!s.equals(word) && s.contains(word)) {
                    count++;
                }
            }
            if (count >= 2) {
                resultList.add(s);
            }
        }
        return resultList;
    }


    public static void main(String[] args) {
        String[] words = new String[]{"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"};

        ConcatenatedWords concatenatedWords = new ConcatenatedWords();
        List<String> list = concatenatedWords.findAllConcatenatedWordsInADict(words);
        System.out.println(list.toString());

    }
}
