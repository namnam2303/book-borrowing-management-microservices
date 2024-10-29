package com.nam.bookservice.command.event;

import com.nam.bookservice.command.data.Book;
import com.nam.bookservice.command.data.BookRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
public class BookEventHandler {
    private final BookRepository bookRepository;

    @Autowired
    public BookEventHandler(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @EventHandler
    public void on(BookCreatedEvent event) {
        Book book = new Book();
        BeanUtils.copyProperties(event, book);
        bookRepository.save(book);
    }
    @EventHandler
    public void on(BookUpdatedEvent event) {
        Optional<Book> oldBook = bookRepository.findById(event.getId());
        if (oldBook.isPresent()) {
            Book book = oldBook.get();
            BeanUtils.copyProperties(event, book);
            bookRepository.save(book);
        }
    }

    @EventHandler
    public void on(BookDeletedEvent event){
        Optional<Book> oldBook = bookRepository.findById(event.getId());
        oldBook.ifPresent(book -> bookRepository.delete((book)));
    }

//    @EventHandler
//    public void on(BookRollBackStatusEvent event){
//        Optional<Book> oldBook = bookRepository.findById(event.getBookId());
//        oldBook.ifPresent(book -> {
//            book.setIsReady(event.getIsReady());
//            bookRepository.save(book);
//        });
//    }
}
