package com.nam.bookservice.querry.querries;

import com.nam.bookservice.querry.model.BookResponseModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class GetAllBookQuery {
    List<BookResponseModel> books;
}
