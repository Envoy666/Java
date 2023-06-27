package ru.gb.learn.seminar3.homework.exercize1;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Product
{
    public static final int SORT1 = 1;
    public static final int SORT2 = 2;
    public static final int SORT3 = 3;
    
    private String name;
    private String country;
    private int sort;
    private int price;
    private int weight;
}
