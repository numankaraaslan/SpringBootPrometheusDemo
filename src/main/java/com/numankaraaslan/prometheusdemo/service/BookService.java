package com.numankaraaslan.prometheusdemo.service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import com.numankaraaslan.prometheusdemo.events.BookCreatedEvent;
import com.numankaraaslan.prometheusdemo.model.Book;
import com.numankaraaslan.prometheusdemo.repository.BookRepo;

@Service
public class BookService
{
	@Autowired
	public BookRepo bookRepo;
	@Autowired
	public ApplicationEventPublisher eventPublisher;

	public List<Book> findByNameLike(String name)
	{
		return bookRepo.searchBynameIgnoreCase(name);
	}

	public List<Book> findByAuthorName(String authorName)
	{
		return bookRepo.findByAuthorNameIgnoreCase(authorName);
	}

	public Book findById(long id)
	{
		return bookRepo.findById(id).orElse(null);
	}

	public Book save(Book newBook)
	{
		newBook.setId(new Random().nextLong(10000000000L));
		eventPublisher.publishEvent(new BookCreatedEvent(newBook.getId()));
		return bookRepo.save(newBook);
	}

	public void deleteByID(long id)
	{
		bookRepo.deleteById(id);
	}

	public List<Book> findAll()
	{
		return bookRepo.findAll();
	}
}