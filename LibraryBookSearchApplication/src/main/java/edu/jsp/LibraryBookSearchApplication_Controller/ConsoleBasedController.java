package edu.jsp.LibraryBookSearchApplication_Controller;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import edu.jsp.LibraryBookSearchApplication_Entity.Book;
import edu.jsp.LibraryBookSearchApplication_Services.BookService;

@Component
public class ConsoleBasedController implements CommandLineRunner{

	@Autowired
    private BookService bookService;

    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void run(String... args) {
        while (true) {
            System.out.println("\n--- Library Book Search Application ---");
            System.out.println("1. Add Book");
            System.out.println("2. Update Book");
            System.out.println("3. Delete Book");
            System.out.println("4. Search Books");
            System.out.println("5. View All Books");
            System.out.println("6. Exit");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); 
            
            switch (choice) {
                case 1 : addBook();
                case 2 : updateBook();
                case 3 : deleteBook();
                case 4 : searchBooks(scanner);
                case 5 : viewAllBooks();
                case 6 : {
                    System.out.println("Exiting...");
                    return;
                }
                default: System.out.println("Invalid choice..");
            }
        }
    }

    private void addBook() {
        Book book = new Book();
        
        System.out.print("Enter title: ");
        book.setTitle(scanner.nextLine());
        
        System.out.print("Enter author: ");
        book.setAuthor(scanner.nextLine());
        
        System.out.print("Enter genre: ");
        book.setGenre(scanner.nextLine());
        
        System.out.print("Enter published date (yyyy-mm-dd): ");
        book.setYearPublished(scanner.nextLine());
        
        bookService.addBook(book);
        System.out.println("Book added successfully!");
    }

    private void updateBook() {
        System.out.print("Enter book ID to update: ");
        Long id = scanner.nextLong();
        
        scanner.nextLine(); 
        
        Book book = new Book();
        
        System.out.print("Enter new title: ");
        book.setTitle(scanner.nextLine());
        
        System.out.print("Enter new author: ");
        book.setAuthor(scanner.nextLine());
        
        System.out.print("Enter new genre: ");
        book.setGenre(scanner.nextLine());
        
        System.out.print("Enter new published date (yyyy-mm-dd): ");
        book.setYearPublished(scanner.nextLine());
        
        bookService.updateBook(id, book);
    }

    private void deleteBook() {
        System.out.print("Enter book ID to delete: ");
        Long id = scanner.nextLong();
        scanner.nextLine();
        bookService.deleteBook(id);
        System.out.println("Book deleted successfully!");
    }

    private void searchBooks(Scanner scanner) {
        System.out.println("Search by:");
        System.out.println("1. Title");
        System.out.println("2. Author");
        System.out.println("3. Genre");
        System.out.print("Enter your choice: ");
        int searchChoice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        switch (searchChoice) {
            case 1 -> {
                System.out.print("Enter title to search: ");
                String title = scanner.nextLine();
                List<Book> books = bookService.searchBooks(title, null, null);
                displaySearchResults(books);
            }
            case 2 -> {
                System.out.print("Enter author to search: ");
                String author = scanner.nextLine();
                List<Book> books = bookService.searchBooks(null, author, null);
                displaySearchResults(books);
            }
            case 3 -> {
                System.out.print("Enter genre to search: ");
                String genre = scanner.nextLine();
                List<Book> books = bookService.searchBooks(null, null, genre);
                displaySearchResults(books);
            }
            default -> System.out.println("Invalid choice! Please try again.");}
        }
        
            private void displaySearchResults(List<Book> books) {
                if (books.isEmpty()) {
                    System.out.println("No matching books found.");
                } else {
                    books.forEach(System.out::println);
                }
            }
        
    
 

    private void viewAllBooks() {
        ((Iterable<Book>) bookService.getAllBooks()).forEach(System.out::println);
    }
}
