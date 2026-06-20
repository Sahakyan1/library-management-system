package com.library;
import com.library.service.LibraryService;
import com.library.exception.BookNotFoundException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        LibraryService library = new LibraryService();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. List Books | 2. Add Book | 3. Borrow Book | 4. Exit");
            System.out.print("Choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            try {
                switch (choice) {
                    case 1:
                        library.displayBooks();
                        break;
                    case 2:
                        System.out.print("Enter ISBN: "); String isbn = scanner.nextLine();
                        System.out.print("Enter Title: "); String title = scanner.nextLine();
                        System.out.print("Enter Author: "); String author = scanner.nextLine();
                        library.addBook(isbn, title, author);
                        break;
                    case 3:
                        System.out.print("Enter ISBN to borrow: ");
                        String borrowIsbn = scanner.nextLine();
                        library.borrowBook(borrowIsbn);
                        break;
                    case 4:
                        System.out.println("Goodbye!");
                        return;
                    default:
                        System.out.println("Invalid choice.");
                }
            } catch (BookNotFoundException e) {
                System.out.println("Error: " + e.getMessage());
            }}}}
