package edu.jsp.LibraryBookSearchApplication_Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.jsp.LibraryBookSearchApplication_Entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

	    List<Book> findByTitleContainingIgnoreCase(String title);
	    List<Book> findByAuthorContainingIgnoreCase(String author);
	    List<Book> findByGenreContainingIgnoreCase(String genre);
}
