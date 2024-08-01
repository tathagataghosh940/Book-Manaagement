package book_management_system;

import java.util.ArrayList;
import java.util.Scanner;

// BookManagement class to manage a collection of books
public class BookManagement {
    private ArrayList<Book> books;

    public BookManagement() {
        books = new ArrayList<>();
    }

    // Method to add a book
    public void addBook(String title, String author, String isbn) {
        Book newBook = new Book(title, author, isbn);
        if (!books.contains(newBook)) {
            books.add(newBook);
            System.out.println("Book added successfully.");
        } else {
            System.out.println("Book with this ISBN already exists.");
        }
    }

    // Method to delete a book by ISBN
    public void deleteBook(String isbn) {
        Book bookToDelete = null;
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                bookToDelete = book;
                break;
            }
        }
        if (bookToDelete != null) {
            books.remove(bookToDelete);
            System.out.println("Book deleted successfully.");
        } else {
            System.out.println("Book with this ISBN not found.");
        }
    }

    // Method to view all books
    public void viewBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
        } else {
            System.out.println("List of books:");
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }

    // Method to exit the program
    public void exit() {
        System.out.println("Exiting the program. Goodbye!");
        System.exit(0);
    }

    public static void main(String[] args) {
        BookManagement bookManagement = new BookManagement();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nBook Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Delete Book");
            System.out.println("3. View Books");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter book author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter book ISBN: ");
                    String isbn = scanner.nextLine();
                    bookManagement.addBook(title, author, isbn);
                    break;
                case 2:
                    System.out.print("Enter book ISBN to delete: ");
                    String isbnToDelete = scanner.nextLine();
                    bookManagement.deleteBook(isbnToDelete);
                    break;
                case 3:
                    bookManagement.viewBooks();
                    break;
                case 4:
                    bookManagement.exit();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}