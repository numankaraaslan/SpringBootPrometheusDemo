package com.numankaraaslan.prometheusdemo.controller;

import java.util.List;
import java.util.Random;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.numankaraaslan.prometheusdemo.model.Book;
import com.numankaraaslan.prometheusdemo.service.BookService;

// randomly throws errors so that you can catch them in restcontrolleradvice and return 500 codes and see them in grafana
@RestController
@RequestMapping("/books")
public class BookController
{
	private final BookService bookService;

	public BookController(BookService bookService)
	{
		this.bookService = bookService;
	}

	@GetMapping(path = { "/", "" })
	public List<Book> getAllBooks()
	{
		// localhost:8080/books
		if (new Random().nextBoolean())
		{
			throw new NullPointerException("some random error for simulation");
		}
		return bookService.findAll();
	}

	@GetMapping("/{id}")
	public Book getBookById(@PathVariable long id)
	{
		// localhost:8080/books/3
		if (new Random().nextBoolean())
		{
			throw new NullPointerException("some random error for simulation");
		}
		return bookService.findById(id);
	}

	@GetMapping("/findByName")
	public List<Book> findByName(@RequestParam String name)
	{
		// localhost:8080/books/findByName?name=a
		if (new Random().nextBoolean())
		{
			throw new NullPointerException("some random error for simulation");
		}
		return bookService.findByNameLike(name);
	}

	@GetMapping("/findByAuthor")
	public List<Book> findByAuthor(@RequestParam String author)
	{
		// localhost:8080/books/findByAuthor?author=a
		if (new Random().nextBoolean())
		{
			throw new NullPointerException("some random error for simulation");
		}
		return bookService.findByAuthorName(author);
	}

	@PostMapping(path = "/save")
	public Book createOrUpdateBook(@RequestBody Book book)
	{
		// localhost:8080/books/save
		// { "id": 22, "name": "The Name of the Wind", "isbn": "978-0000000022", "year": 2007, "author": "Patrick Rothfuss" }
		if (new Random().nextBoolean())
		{
			throw new NullPointerException("some random error for simulation");
		}
		return bookService.save(book);
	}

	@DeleteMapping("/delete/{id}")
	public void deleteBookById(@PathVariable long id)
	{
		// localhost:8080/books/delete/1
		if (new Random().nextBoolean())
		{
			throw new NullPointerException("some random error for simulation");
		}
		bookService.deleteByID(id);
	}
}
