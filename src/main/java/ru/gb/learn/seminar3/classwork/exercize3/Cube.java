package ru.gb.learn.seminar3.classwork.exercize3;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.awt.Color;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Cube
{
    private Integer size;
    private Color color;
    private String material;
    
    public int getVolume ()
    {
        return size * size * size;
    }
}
