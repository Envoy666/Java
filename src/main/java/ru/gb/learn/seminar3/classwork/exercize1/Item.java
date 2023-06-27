package ru.gb.learn.seminar3.classwork.exercize1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Item
{
    private String name;
    private String country;
    private int volume;
}
