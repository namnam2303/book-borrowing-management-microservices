package com.nam.bookservice.command.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class BookRequestModel {
    private String id;
    private String name;
    private String author;
    private Boolean isReady;
}
