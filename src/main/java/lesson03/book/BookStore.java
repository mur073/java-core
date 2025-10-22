package lesson03.book;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookStore {

    private long nextBookId = 0;
    final private Map<Long, Book> books = new HashMap<>();

    public BookStore() {
    }

    public void getBookInfo(long bookId) {
        Book book = books.get(bookId);

        if (book == null) {
            System.out.printf("Book %d not found\n", bookId);
        } else {
            book.getBookInfo();
        }
    }

    public List<Book> getBooks() {
        return books.values().stream().toList();
    }

    public void addNewBook(String isbn, String name, String author, int year) {
        nextBookId += 1;

        long newBookId = nextBookId;
        Book newBook = new Book(newBookId, isbn, name, author, year, "available");

        books.put(nextBookId, newBook);
    }

    public boolean reserveBook(long bookId) {
        Book book = books.get(bookId);

        if (book == null || book.getStatus().equals("reserved")) {
            return false;
        }

        book.setStatus("reserved");
        return true;
    }
}
