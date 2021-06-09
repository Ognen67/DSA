package com.github.ognen67.exercises.aipsExamEx;

import java.util.*;

public class Statistika {

    static class Person {
        private String name;
        private String sport;

        public Person(String name, String sport) {
            this.name = name;
            this.sport = sport;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSport() {
            return sport;
        }

        public void setSport(String sport) {
            this.sport = sport;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Person person = (Person) o;
            return Objects.equals(name, person.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", sport='" + sport + '\'' +
                    '}';
        }
    }

    class Sport {
        private String name;
        private int num;

        public Sport(String name) {
            this.name = name;
            this.num = 0;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }


    }

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        int n = input.nextInt();

        String name;
        String sport;

        HashMap<String, Person> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            name = input.next();
            sport = input.next();

            if (!map.containsKey(name)) {
                map.put(name, new Person(name, sport));
            }
        }

        System.out.println(Collections.singletonList(map));

    }
}
