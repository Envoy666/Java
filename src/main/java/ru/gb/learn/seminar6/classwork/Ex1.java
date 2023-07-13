package ru.gb.learn.seminar6.classwork;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Ex1
{
    public static void main (String[] args)
    {
        List <Integer> list = Arrays.asList (1, 2, 3, 1, 8, 9, 0, 1, 3, 4);
        HashSet <Integer> set = new HashSet <> (list);
        System.out.println ("list = " + list);
        System.out.println ("set = " + set);
        System.out.println ("unique % = "
                                    + (double) (list.size () - set.size ()) * 100 / list.size ());
    }
}
