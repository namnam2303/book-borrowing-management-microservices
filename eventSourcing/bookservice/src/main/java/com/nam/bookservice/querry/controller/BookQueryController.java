package com.nam.bookservice.querry.controller;

import com.nam.bookservice.querry.model.BookResponseModel;
import com.nam.bookservice.querry.querries.GetAllBookQuery;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
public class BookQueryController {

    @Autowired
    private QueryGateway queryGateway;

    @GetMapping
    public List<BookResponseModel> getAllBooks() {
        GetAllBookQuery query = new GetAllBookQuery();
        return   queryGateway.query(query, ResponseTypes.multipleInstancesOf(BookResponseModel.class)).join();
    }


}
