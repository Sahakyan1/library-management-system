# Library Management System

A lightweight, console-based Library Management System built with Java Core, demonstrating clean object-oriented design, effective data structure utilization, and robust file operations. 

This project was developed to showcase core backend engineering principles, specifically focused on layered architecture, efficient data retrieval, and custom exception handling.


## Key Features

- Add New Books:Seamlessly insert books into the system with a unique ISBN, title, and author.
- Borrow & Return System: Tracks the availability status of books in real-time.
- Persistent Storage: Data is automatically saved to and loaded from a flat-file (`books.txt`), ensuring persistence across application restarts.
- Interactive Console UI: Simple and intuitive command-line interface for user interaction.


##  Architecture & Design Principles

The project strictly follows the **Separation of Concerns (SoC)** principle, separating the codebase into distinct functional layers:

1.Model Layer (`com.library.model`):Defines the core domain entities (e.g., `Book`) utilizing encapsulation.
2.Repository Layer (`com.library.repository`): Handles data persistence via Java File I/O (`BufferedReader`/`BufferedWriter`).
3.Service Layer (`com.library.service`): Contains the core business logic, validation rules, and handles data flows.
4.Exception Layer (`com.library.exception`): Implements domain-specific checked exceptions (`BookNotFoundException`).
5.UI/Presentation Layer (`com.library`): Contains the `Main` entry point and manages console interactions.


## Technical Highlights & OOP Concepts

-Data Structures (Օ(1) Search):Used a `HashMap<String, Book>` where the ISBN acts as the unique key. This ensures that book lookup, borrowing, and returning operations run in constant time (O(1)), optimizing performance even as the catalog grows.
- Encapsulation: All fields within the domain models are kept `private` and exposed strictly through public getters and setters to ensure data integrity.
- Robust Exception Handling: Implemented custom checked exceptions to separate error-handling logic from core business logic, preventing unexpected crashes and handling invalid inputs gracefully.
-Resource Management։Utilized `try-with-resources` blocks for file streams to guarantee proper closure of I/O resources and prevent memory leaks.

## Prerequisites & How to Run

### Prerequisites
- Java Development Kit (JDK): Version 8 or higher.
- IDE (Optional):IntelliJ IDEA, Eclipse, or VS Code.

### Running via Terminal
1. Clone the repository:
   ```bash
   git clone [https://github.com/yourusername/library-management-system.git](https://github.com/yourusername/library-management-system.git)
2. Bash
   
 cd library-management-system/src
 javac com/library/Main.java
 java com.library.Main

   
