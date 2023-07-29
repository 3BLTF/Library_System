import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Library {
    private int capacity;
    private Map<Integer, Book> books;
    private Scanner scanner;

    public Library(int capacity) {
        this.capacity = capacity;
        this.books = new HashMap<>(capacity);
        this.scanner = new Scanner(System.in);
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public void addBook() {
        if (books.size() >= capacity) {
            System.out.println("Library is full. Cannot add more books.");
            return;
        } else {
            System.out.print("Enter the name of the book: ");
            String bookName = scanner.next();

            System.out.print("Enter the category of the book: ");
            String bookCategory = scanner.next();

            Book book = new Book(bookName, bookCategory);
            books.put(book.getId(), book);
            System.out.println("Book added successfully. ID: " + book.getId());
        }
    }

    public void removeBook() {
        System.out.print("Enter the ID of the book to remove: ");
        int bookId = scanner.nextInt();

        Book book = books.get(bookId);
        if (book == null) {
            System.out.println("Book not found.");
        } else if (book.isBorrowed()) {
            System.out.println("This book is currently borrowed. Expected return date: " +
                    book.getBorrowingDate().plusDays(book.getBorrowingPeriod()));
        } else {
            books.remove(bookId);
            System.out.println("Book removed successfully.");
        }
    }

    public void borrowBook() {
        System.out.print("Enter the ID of the book to borrow: ");
        int bookId = scanner.nextInt();

        Book book = books.get(bookId);
        if (book == null) {
            System.out.println("Book not found.");
        } else if (book.isBorrowed()) {
            System.out.println("This book is already borrowed. Expected return date: " +
                    book.getBorrowingDate().plusDays(book.getBorrowingPeriod()));
        } else {
            System.out.print("Enter the borrowing period (in days): ");
            int borrowingPeriod = scanner.nextInt();
            book.borrow(borrowingPeriod);
            System.out.println("Book borrowed successfully. Return date: " +
                    book.getBorrowingDate().plusDays(book.getBorrowingPeriod()));
        }
    }

    public void returnBook() {
        System.out.print("Enter the ID of the book to return: ");
        int bookId = scanner.nextInt();

        Book book = books.get(bookId);
        if (book == null) {
            System.out.println("Book not found.");
        } else if (!book.isBorrowed()) {
            System.out.println("This book is not currently borrowed.");
        } else {
            book.returnBook();
            System.out.println("Book returned successfully.");
        }
    }

    public void viewLibraryStatus() {
        System.out.println("Library Status:");
        if (books.isEmpty()) {
            System.out.println("No books in the library.");
        } else {
            for (Book book : books.values()) {
                System.out.println("Book ID: " + book.getId());
                System.out.println("Book Name: " + book.getName());
                System.out.println("Book Category: " + book.getCategory());
                if (book.isBorrowed()) {
                    System.out.println("Borrowed: Yes");
                    System.out.println("Borrowing Date: " + book.getBorrowingDate());
                    System.out.println("Expected Return Date: " +
                            book.getBorrowingDate().plusDays(book.getBorrowingPeriod()));
                } else {
                    System.out.println("Borrowed: No");
                }
                System.out.println();
            }
        }
    }
}