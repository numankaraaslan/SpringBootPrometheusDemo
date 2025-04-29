package com.numankaraaslan.prometheusdemo.model;

import java.util.Objects;

public class Book
{
	private long id;
	private String name;
	private String isbn;
	private int year;
	private String author;

	public Book()
	{
	}

	public Book(long id, String name, String isbn, int year, String author)
	{
		this.id = id;
		this.name = name;
		this.isbn = isbn;
		this.year = year;
		this.author = author;
	}

	public Book(String name, String isbn, int year, String author)
	{
		this.name = name;
		this.isbn = isbn;
		this.year = year;
		this.author = author;
	}

	public long getId()
	{
		return id;
	}

	public void setId(long id)
	{
		this.id = id;
	}

	public String getIsbn()
	{
		return isbn;
	}

	public void setIsbn(String isbn)
	{
		this.isbn = isbn;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public int getYear()
	{
		return year;
	}

	public void setYear(int year)
	{
		this.year = year;
	}

	public String getAuthor()
	{
		return author;
	}

	public void setAuthor(String author)
	{
		this.author = author;
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(author, id, isbn, name, year);
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
		{
			return true;
		}
		if (obj == null)
		{
			return false;
		}
		if (getClass() != obj.getClass())
		{
			return false;
		}
		Book other = (Book) obj;
		return Objects.equals(author, other.author) && id == other.id && Objects.equals(isbn, other.isbn) && Objects.equals(name, other.name) && year == other.year;
	}

}