package com.numankaraaslan.prometheusdemo.events;

public class BookCreatedEvent
{
	private final Long bookId;

	public BookCreatedEvent(Long bookId)
	{
		this.bookId = bookId;
	}

	public Long getBookId()
	{
		return bookId;
	}
}
