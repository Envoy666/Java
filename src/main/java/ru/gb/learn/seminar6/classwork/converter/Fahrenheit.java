package ru.gb.learn.seminar6.classwork.converter;

public class Fahrenheit implements Converter
{
    @Override
    public double convertValue (double value)
    {
        if (value < -273.15) throw new IllegalArgumentException ("value below absolute zero");
        // столкнулся с извечной проблемой представления double: артефакты после запятой
        // частичное решение...
        double temp = value;
        double order = 1;
        while (temp - (int) temp != 0 && order < 1000000000)
        {
            temp *= 10;
            order *= 10;
        }
        return temp * 1.8 / order + 32;
    }
}
