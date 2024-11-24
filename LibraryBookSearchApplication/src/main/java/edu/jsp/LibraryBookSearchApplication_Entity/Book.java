package edu.jsp.LibraryBookSearchApplication_Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Data
@Table(name = "LibraryBooks")

public class Book {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;

	    @Column(nullable = false)
	    private String title;
	    
	    @Column(nullable = false)
	    private String author;
	    
	    private String genre;
	    
	    private String yearPublished;
}
