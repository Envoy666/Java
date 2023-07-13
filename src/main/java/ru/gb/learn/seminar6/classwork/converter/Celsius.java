package ru.gb.learn.seminar6.classwork.converter;

public class Celsius implements Converter
{
    @Override
    public double convertValue (double value)
    {
        if (value < -273.15) throw new IllegalArgumentException ("value below absolute zero");
        return value;
    }
}
