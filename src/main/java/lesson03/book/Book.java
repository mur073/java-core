package lesson03.book;

public class Book {
    final private long id;
    final private String isbn;
    final private String name;
    final private String author;
    final private int year;
    private String status;

    public Book(long id, String isbn, String name, String author, int year, String status) {
        this.id = id;
        this.isbn = isbn;
        this.name = name;
        this.author = author;
        this.year = year;
        this.status = status;
    }

    public void getBookInfo() {
        System.out.println("Book information:");
        System.out.printf("\t- Id: %d\n", id);
        System.out.printf("\t- ISBN: %s\n", isbn);
        System.out.printf("\t- Name: %s\n", name);
        System.out.printf("\t- Author: %s\n", author);
        System.out.printf("\t- Year: %d\n", year);
        System.out.printf("\t- Status: %s\n", status);
    }

    public void setStatus(String newStatus) {
        this.status = newStatus;
    }

    public long getId() {
        return id;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public String getStatus() {
        return status;
    }
}
