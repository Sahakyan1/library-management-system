package com.library.service;
import com.library.model.Book;
import com.library.repository.FileRepository;
import com.library.exception.BookNotFoundException;
import java.util.*;
public class LibraryService {
    private Map<String, Book> books;
   public LibraryService() {
      this.books = FileRepository.loadBooks();  }
 public void addBook(String isbn, String title, String author) {
        Book book = new Book(isbn, title, author, true);
        books.put(isbn, book);
        FileRepository.saveBooks(books.values());
        System.out.println("Success: Book added!"); }

   public void borrowBook(String isbn) throws BookNotFoundException {
        Book book = books.get(isbn);
        if (book == null) {
            throw new BookNotFoundException("Book with ISBN " + isbn + " does not exist.");
        }
        if (!book.isAvailable()) {
            System.out.println("Sorry, this book is already borrowed.");
            return;
        }
        book.setAvailable(false);
        FileRepository.saveBooks(books.values()); 
        System.out.println("Success: You borrowed " + book.getTitle());
    }

    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("The library is empty.");
            return;
        }
        System.out.println("\n--- Library Catalog ---");
        books.values().forEach(System.out.println);
    }
}
