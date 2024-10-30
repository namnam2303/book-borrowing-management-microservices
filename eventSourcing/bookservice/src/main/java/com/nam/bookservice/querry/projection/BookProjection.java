package com.nam.bookservice.querry.projection;

import com.nam.bookservice.command.data.Book;
import com.nam.bookservice.command.data.BookRepository;
import com.nam.bookservice.querry.model.BookResponseModel;
import com.nam.bookservice.querry.querries.GetAllBookQuery;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BookProjection {

    @Autowired
    private BookRepository bookRepository;

    @QueryHandler
    public List<BookResponseModel> handle(GetAllBookQuery query) {
        List<Book> books = bookRepository.findAll();
        List<BookResponseModel> bookResponseModels = new ArrayList<>();
        books.forEach(book -> {
            BookResponseModel bookResponseModel = new BookResponseModel();
            BeanUtils.copyProperties(book, bookResponseModel);
            bookResponseModels.add(bookResponseModel);
        });
        return bookResponseModels;
    }
}
