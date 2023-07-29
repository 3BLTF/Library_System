import java.util.Random;
import java.time.LocalDate;


public class Book {
    private static int nextId = 1;
    private int id;
    private String name;
    private String category;
    private boolean borrowed;
    private LocalDate borrowingDate;
    private int borrowingPeriod;

    public Book() {
        this.id = nextId++;
        this.borrowed = false;
    }

    public Book(String name, String category) {
        this.id = nextId++;
        this.name = name;
        this.category = category;
        this.borrowed = false;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public boolean isBorrowed() {
        return borrowed;
    }

    public LocalDate getBorrowingDate() {
        return borrowingDate;
    }

    public int getBorrowingPeriod() {
        return borrowingPeriod;
    }

    public void borrow(int borrowingPeriod) {
        this.borrowed = true;
        this.borrowingDate = LocalDate.now();
        this.borrowingPeriod = borrowingPeriod;
    }

    public void returnBook() {
        this.borrowed = false;
        this.borrowingDate = null;
        this.borrowingPeriod = 0;
    }
}
