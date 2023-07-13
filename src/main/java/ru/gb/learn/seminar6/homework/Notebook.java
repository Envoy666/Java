package ru.gb.learn.seminar6.homework;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Notebook
{
    private String vendor;
    private int CPU; //GHz
    private int cores;
    private int memory; //Gb
    private int volume; //Gb
    private double diagonal; // inches
    private int price;
    
    static public String[] getAttrs ()
    {
        return new String[] {
                "Vendor",
                "CPU (GHz)",
                "Cores",
                "Memory (Gb)",
                "Volume (Gb)",
                "Diagonal (\")",
                "Price (rub)",
        };
    }
}
