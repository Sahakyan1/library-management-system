package com.library.repository;
import com.library.model.Book;
import java.io.*;
import java.util.*;
public class FileRepository {
    private static final String FILE_PATH = "books.txt";

    public static void saveBooks(Collection<Book> books) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Book book : books) {
                writer.write(book.toCsvString());
                writer.newLine();
            }} catch (IOException e) {
            System.err.println("Error saving books to file: " + e.getMessage());
        }}

    public static Map<String, Book> loadBooks() {
        Map<String, Book> books = new HashMap<>();
        File file = new File(FILE_PATH);
        
        if (!file.exists()) return books; 

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    String isbn = parts[0];
                    String title = parts[1];
                    String author = parts[2];
                    boolean isAvailable = Boolean.parseBoolean(parts[3]);
                    books.put(isbn, new Book(isbn, title, author, isAvailable));
                }
            }
        } catch (IOException e) {
            System.err.println("Error loading books from file: " + e.getMessage());
        }
        return books;
    }
}
