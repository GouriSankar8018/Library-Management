public class LabManagement{
    public static void main(String[] args) {
            Library library = new Library();    
            // Add books
            Book book1 = new Book("My World 2.0", "Justin");
            Book book2 = new Book("Slow Down", "Selena");
            library.addBook(book1);
            library.addBook(book2);
    
            // Add users
            User user1 = new User("Justice");
            User user2 = new User("Varun");
            library.addUser(user1);
            library.addUser(user2);

             // User borrows a book
             user1.borrowBook(book1);
             user2.borrowBook(book2);
     
             // User returns a book
             user1.returnBook(book1);
             user2.returnBook(book2);
     
             // Calculate and display the fee for the user
             double fee = user1.calculateFee();
             System.out.println("Fee for " + user1.getUsername() + ": 25.00" + fee);
             double fee1 = user2.calculateFee();
             System.out.println("Fee for " + user2.getUsername() + ": 35.00" + fee1);
    }
}