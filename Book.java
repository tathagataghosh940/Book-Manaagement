package book_management_system;

import java.util.Objects;

class Book {
    private String title;
    private String author;
    private String isbn;

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    @Override
    public String toString() {
        return ("Title: " + title + ", Author: " + author + ", ISBN: " + isbn);
    }

    // Override equals and hashCode methods to compare books by their ISBN
    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if (obj == null || getClass() != obj.getClass()){
            return false;
        }
        Book book = (Book) obj;
        return Objects.equals(isbn, book.isbn);
    }

    @Override
    public int hashCode() {
        int result = 17; // Start with a non-zero constant
        result = 31 * result + (isbn == null ? 0 : isbn.hashCode());
        return result;
    }
}
