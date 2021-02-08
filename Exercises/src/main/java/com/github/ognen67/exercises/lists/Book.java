package com.github.ognen67.exercises.lists;

import java.util.*;

public class Book {

    private final String title;
    private final int lines;

    Book(String title, int lines) {
        this.title = title;
        this.lines = lines;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return lines == book.lines && Objects.equals(title, book.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, lines);
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + title + '\'' +
                ", lines=" + lines +
                '}';
    }

    public static Book parse(String inputline) {
        String[] ins = inputline.split(",");
        return new Book(ins[0], Integer.parseInt(ins[1].trim()));
    }

    public List<String> getTitleWords() {
        return List.of(this.title.split(" "));
    }

    public static void main(String[] args) {
        List<Book> storedBooks = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        while (true) {
            String ins = input.nextLine();
            if (!ins.equals("#")) {
                storedBooks.add(Book.parse(ins));
            } else {
                break;
            }
        }

        int n = Integer.parseInt(input.nextLine());
        String[] searches = new String[n];

        for (int i = 0; i < n; i++) {
            searches[i] = input.nextLine();
        }

        for (String search : searches) {
            List<Book> result = new ArrayList<>();
            for (Book book : storedBooks) {
                if (book.title.toLowerCase().contains(search.toLowerCase())) {
                    result.add(book);
                }
            }
            if (result.isEmpty()) {
                System.out.println("Not found");
            } else {
                System.out.println(result.stream().mapToInt(b -> b.lines).sum());
            }
        }
        input.close();
    }
}
