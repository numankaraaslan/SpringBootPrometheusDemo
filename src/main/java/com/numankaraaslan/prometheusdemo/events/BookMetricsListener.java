package com.numankaraaslan.prometheusdemo.events;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;

@Component
public class BookMetricsListener
{
	private final Counter booksCreatedCounter;

	public BookMetricsListener(MeterRegistry meterRegistry)
	{
		this.booksCreatedCounter = Counter.builder("app_books_created_total").description("Books created total").tags("source", "app").register(meterRegistry);
	}

	@Async
	@EventListener
	public void handleBookCreated(BookCreatedEvent event)
	{
		booksCreatedCounter.increment();
	}
}
