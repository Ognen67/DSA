package com.github.ognen67.exercises.aipsExamEx.strings;

/*
* Даден е стринг. Треба да се најде најчестиот под-стринг кој е дел од него и да се испечати.
* Доколку два под-стринга се исто фреквентни, тогаш се печати подолгиот. Доколку и овој услов го исполнуваат тогаш се печати лексикографски помалиот.

Пример: За стрингот "abc" под-стрингови се "a", "b", "c", "ab", "bc", "abc". Сите имаат иста честота па затоа се печати најдолгиот "abc".

Име на класата (Java): MostFrequentSubstring.*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class MapEntry<K extends Comparable<K>, E> implements Comparable<K> {

    K key;
    E value;

    public MapEntry(K key, E val) {
        this.key = key;
        this.value = val;
    }

    public int compareTo(K that) {
        @SuppressWarnings("unchecked")
        MapEntry<K, E> other = (MapEntry<K, E>) that;
        return this.key.compareTo(other.key);
    }

    public String toString() {
        return "(" + key + "," + value + ")";
    }
}

class SLLNode<E> {
    protected E element;
    protected SLLNode<E> succ;

    public SLLNode(E elem, SLLNode<E> succ) {
        this.element = elem;
        this.succ = succ;
    }

    @Override
    public String toString() {
        return element.toString();
    }
}

class CBHT<K extends Comparable<K>, E> {

    private SLLNode<MapEntry<K, E>>[] buckets;

    @SuppressWarnings("unchecked")
    public CBHT(int m) {
        buckets = (SLLNode<MapEntry<K, E>>[]) new SLLNode[m];
    }

    private int hash(K key) {
        return Math.abs(key.hashCode()) % buckets.length;
    }

    public SLLNode<MapEntry<K, E>> search(K targetKey) {
        int b = hash(targetKey);
        for (SLLNode<MapEntry<K, E>> curr = buckets[b]; curr != null; curr = curr.succ) {
            if (targetKey.equals(((MapEntry<K, E>) curr.element).key))
                return curr;
        }
        return null;
    }

    public void insert(K key, E val) {        // Insert the entry <key, val> into this CBHT.
        MapEntry<K, E> newEntry = new MapEntry<K, E>(key, val);
        int b = hash(key);
        for (SLLNode<MapEntry<K, E>> curr = buckets[b]; curr != null; curr = curr.succ) {
            if (key.equals(((MapEntry<K, E>) curr.element).key)) {
                curr.element = newEntry;
                return;
            }
        }
        buckets[b] = new SLLNode<MapEntry<K, E>>(newEntry, buckets[b]);
    }

    public void delete(K key) {
        int b = hash(key);
        for (SLLNode<MapEntry<K, E>> pred = null, curr = buckets[b]; curr != null; pred = curr, curr = curr.succ) {
            if (key.equals(((MapEntry<K, E>) curr.element).key)) {
                if (pred == null)
                    buckets[b] = curr.succ;
                else
                    pred.succ = curr.succ;
                return;
            }
        }
    }

    public String toString() {
        String temp = "";
        for (int i = 0; i < buckets.length; i++) {
            temp += i + ":";
            for (SLLNode<MapEntry<K, E>> curr = buckets[i]; curr != null; curr = curr.succ) {
                temp += curr.element.toString() + " ";
            }
            temp += "\n";
        }
        return temp;
    }

    public String mostFrequentSubstring() {

        int max = 0;
        String s = "";

        for (int i=0; i<buckets.length; i++) {
            for(SLLNode<MapEntry<K, E>> p = buckets[i]; p != null; p = p.succ) {
                if ((Integer) p.element.value > max) {
                    max = (Integer) p.element.value;
                    s = (String) p.element.key;
                }
                else if((Integer) p.element.value == max) {
                    if(((String)p.element.key).length() > s.length()) {
                        s = (String)p.element.key;
                    }
                }
            }
        }

        return s;
    }
}

public class MostFrequentSubstring {
    public static void main(String[] args) throws IOException {
        CBHT<String, Integer> tabela = new CBHT<>(300);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String word = br.readLine().trim();

        char[] chars = word.toCharArray();


        for (int i = 0; i < word.length(); i++) {
            for (int j = i + 1; j <= word.length(); j++) {
                String substring = word.substring(i, j);
                if (tabela.search(substring) == null) {
                    tabela.insert(substring, 1);
                } else {
                    int occurence = tabela.search(substring).element.value;
                    tabela.insert(substring, occurence + 1);
                }
            }
        }

        System.out.println(tabela.mostFrequentSubstring());

    }
}
