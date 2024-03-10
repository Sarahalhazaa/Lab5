package com.example.lab5q3.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class Event {

    private String ID ;
    private int capacity ;
    private String description ;
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate startDate ;
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate endDate ;
}
