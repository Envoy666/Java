package ru.gb.learn.seminar6.classwork.converter;

public class Main
{
    public static void main (String[] args)
    {
        double temp0 = 0.0;
        double temp100 = 100.0;
        double absZero = -273.15;
        double veryClose = 0.000000000000001;
        
        System.out.println ("0°C in celsius = " + new Celsius ().convertValue (temp0));
        System.out.println ("0°C in kelvin = " + new Kelvin ().convertValue (temp0));
        System.out.println ("0°C in fahrenheit = " + new Fahrenheit ().convertValue (temp0));
        
        System.out.println ("100°C in celsius = " + new Celsius ().convertValue (temp100));
        System.out.println ("100°C in kelvin = " + new Kelvin ().convertValue (temp100));
        System.out.println ("100°C in fahrenheit = " + new Fahrenheit ().convertValue (temp100));
        
        System.out.println ("absolute zero in celsius = " + new Celsius ().convertValue (absZero));
        System.out.println ("absolute zero in kelvin = " + new Kelvin ().convertValue (absZero));
        System.out.println ("absolute zero in fahrenheit = " + new Fahrenheit ().convertValue (absZero));
        
        System.out.println ("close to 0 in celsius = " + new Celsius ().convertValue (veryClose));
        System.out.println ("close to 0 in kelvin = " + new Kelvin ().convertValue (veryClose));
        System.out.println ("close to 0 in fahrenheit = " + new Fahrenheit ().convertValue (veryClose));
        
    }
}
