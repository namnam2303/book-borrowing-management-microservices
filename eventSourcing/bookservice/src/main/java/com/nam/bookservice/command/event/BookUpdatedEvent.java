package com.nam.bookservice.command.event;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.checkerframework.checker.units.qual.N;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookUpdatedEvent {
    private String id;
    private String name;
    private String author;
    private Boolean isReady;
}
