package com.github.ognen67.exercises.lists;

import java.util.*;

public class BookStreams {

    static class Book {
        String name;
        int pages;

        public Book(String name, int pages) {
            this.name = name;
            this.pages = pages;
        }

        public void printBook() {
            System.out.println("Name: " + name + " Pages: " + pages);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        processSearches(enterBooks(input), enterSearches(input));
    }

    private static void processSearches(List<Book> books, String[] searches) {
        for (String search : searches) {
            List<Book> result = new ArrayList<>();
            for (Book book : books) {
                if (book.name.toLowerCase().contains(search.toLowerCase())) {
                    result.add(book);
                }
            }
            if (result.isEmpty()) {
                System.out.println("Not found");
            } else {
                System.out.println(result.stream().mapToInt(b -> b.pages).sum());
            }
        }
    }

    private static String[] enterSearches(Scanner input) {
        int n = Integer.parseInt(input.nextLine());
        String[] searches = new String[n];
        for (int i = 0; i < n; i++) {
            searches[i] = input.nextLine();
        }
        return searches;
    }

    private static List<Book> enterBooks(Scanner input) {
        ArrayList<Book> books = new ArrayList<>();
        while (true) {
            String ins = input.nextLine();
            if (ins.equals("#")) {
                break;
            } else {
                books.add(parse(ins));
            }
        }
        return books;
    }

    private static Book parse(String input) {
        String[] ins = input.split(",");
        return new Book(ins[0], Integer.parseInt(ins[1].trim()));
    }
}
