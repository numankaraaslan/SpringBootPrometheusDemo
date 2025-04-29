package com.numankaraaslan.prometheusdemo.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.numankaraaslan.prometheusdemo.model.Book;

@Component
public class BookRepo
{
	private ArrayList<Book> books;

	public BookRepo()
	{
		books = new ArrayList<Book>();
		books.add(new Book(1L, "The Silent World", "978-0000000001", 2001, "Jacques Cousteau"));
		books.add(new Book(2L, "Into the Wild", "978-0000000002", 1996, "Jon Krakauer"));
		books.add(new Book(3L, "The Alchemist", "978-0000000003", 1988, "Paulo Coelho"));
		books.add(new Book(4L, "Brave New World", "978-0000000004", 1932, "Aldous Huxley"));
		books.add(new Book(5L, "To Kill a Mockingbird", "978-0000000005", 1960, "Harper Lee"));
		books.add(new Book(6L, "1984", "978-0000000006", 1949, "George Orwell"));
		books.add(new Book(7L, "Moby-Dick", "978-0000000007", 1851, "Herman Melville"));
		books.add(new Book(8L, "Pride and Prejudice", "978-0000000008", 1813, "Jane Austen"));
		books.add(new Book(9L, "The Great Gatsby", "978-0000000009", 1925, "F. Scott Fitzgerald"));
		books.add(new Book(10L, "The Hobbit", "978-0000000010", 1937, "J.R.R. Tolkien"));
		books.add(new Book(11L, "The Catcher in the Rye", "978-0000000011", 1951, "J.D. Salinger"));
		books.add(new Book(12L, "War and Peace", "978-0000000012", 1869, "Leo Tolstoy"));
		books.add(new Book(13L, "Crime and Punishment", "978-0000000013", 1866, "Fyodor Dostoevsky"));
		books.add(new Book(14L, "The Little Prince", "978-0000000014", 1943, "Antoine de Saint-Exupéry"));
		books.add(new Book(15L, "Les Misérables", "978-0000000015", 1862, "Victor Hugo"));
		books.add(new Book(16L, "Don Quixote", "978-0000000016", 1605, "Miguel de Cervantes"));
		books.add(new Book(17L, "Frankenstein", "978-0000000017", 1818, "Mary Shelley"));
		books.add(new Book(18L, "Jane Eyre", "978-0000000018", 1847, "Charlotte Brontë"));
		books.add(new Book(19L, "The Odyssey", "978-0000000019", -700, "Homer"));
		books.add(new Book(20L, "The Divine Comedy", "978-0000000020", 1320, "Dante Alighieri"));
	}

	public List<Book> findAll()
	{
		return this.books;
	}

	public Book save(Book newBook)
	{
		this.books.add(newBook);
		return newBook;
	}

	public Optional<Book> findById(long id)
	{
		return books.stream().filter(item -> item.getId() == id).map(item -> Optional.of(item)).findFirst().get();
	}

	public void deleteById(long id)
	{
		books.removeIf(item -> item.getId() == id);
	}

	public List<Book> searchBynameIgnoreCase(String name)
	{
		return books.stream().filter(item -> item.getName().toLowerCase().contains(name)).toList();
	}

	public List<Book> findByAuthorNameIgnoreCase(String authorName)
	{
		return books.stream().filter(item -> item.getAuthor().toLowerCase().contains(authorName)).toList();
	}
}
