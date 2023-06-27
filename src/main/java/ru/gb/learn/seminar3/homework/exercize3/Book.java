package ru.gb.learn.seminar3.homework.exercize3;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Book
{
    private String name;
    private String author;
    private int price;
    private int year;
    private int pages;
}
