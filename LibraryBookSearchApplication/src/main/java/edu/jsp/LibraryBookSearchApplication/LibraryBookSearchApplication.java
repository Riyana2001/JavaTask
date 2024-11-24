package edu.jsp.LibraryBookSearchApplication;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import edu.jsp.LibraryBookSearchApplication_Entity.Book;
import edu.jsp.LibraryBookSearchApplication_Services.BookService;

@EntityScan(basePackages = " edu.jsp.LibraryBookSearchApplication_Entity") 
@ComponentScan("edu.jsp.LibraryBookSearchApplication_Services")
@EnableJpaRepositories(basePackages = "edu.jsp.LibraryBookSearchApplication_Repository")
@SpringBootApplication
public class LibraryBookSearchApplication {

	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(LibraryBookSearchApplication.class, args);
	
	}

}
