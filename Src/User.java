import java.util.*;

public class User {
    private String username;
    private List<Book> borrowedBooks;
    private Date lastBorrowDate;

    public User(String username) {
        this.username = username;
        this.borrowedBooks = new ArrayList<>();
        this.lastBorrowDate = null;
    }

    public String getUsername() {
        return username;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public Date getLastBorrowDate() {
        return lastBorrowDate;
    }

    public void borrowBook(Book book) {
        if (book.isAvailable()) {
            borrowedBooks.add(book);
            book.setAvailable(false);
            lastBorrowDate = new Date();
            System.out.println("Book '" + book.getTitle() + "' borrowed successfully.");
        } else {
            System.out.println("Book '" + book.getTitle() + "' is not available for borrowing.");
        }
    }

    public void returnBook(Book book) {
        if (borrowedBooks.contains(book)) {
            borrowedBooks.remove(book);
            book.setAvailable(true);
            System.out.println("Book '" + book.getTitle() + "' returned successfully.");
        } else {
            System.out.println("You did not borrow the book '" + book.getTitle() + "'.");
        }
    }

    public double calculateFee() {
        if (lastBorrowDate == null) {
            return 0.0;
        }

        // Calculate the difference in days
        long diffInMillies = new Date().getTime() - lastBorrowDate.getTime();
        long diffInDays = diffInMillies / (24 * 60 * 60 * 1000);

        // Assuming a fee of $0.50 per day
        double fee = 0.50 * diffInDays;
        return fee;
    }
}
