package edu.jsp.LibraryBookSearchApplication_Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import edu.jsp.LibraryBookSearchApplication_Entity.Book;
import edu.jsp.LibraryBookSearchApplication_Repository.BookRepository;

@Service
public class BookService {

	    @Autowired
	    private BookRepository bookRepository;

	    public Book getAllBooks() {
	        return (Book) bookRepository.findAll();
	    }

	    public Book addBook(Book book) {
	        return bookRepository.save(book);
	    }

	    public Book updateBook(Long id, Book updatedBook) {
	    	Optional<Book> optional= bookRepository.findById(id);
	    	 boolean status =  optional.isPresent();
			    if(status) {
			    	// get object of book
			    	 Book book =  optional.get();
			    	 System.out.println(book);
			    	
			    }else {
			    	System.err.println("no data found");
			    }
				return updatedBook;
	    }

	    public void deleteBook(Long id) {
	        bookRepository.deleteById(id);
	    }

	    public List<Book> searchBooks(String title, String author, String genre) {
	        if (title != null) {
	            return bookRepository.findByTitleContainingIgnoreCase(title);
	        } else if (author != null) {
	            return bookRepository.findByAuthorContainingIgnoreCase(author);
	        } else if (genre != null) {
	            return bookRepository.findByGenreContainingIgnoreCase(genre);
	        }
	        return bookRepository.findAll();
	    }
}

