package ru.gb.learn.seminar6.classwork;

import java.util.Arrays;
import java.util.HashSet;

public class Ex2
{
    public static void main (String[] args)
    {
        HashSet <Integer> set1 = new HashSet <> (Arrays.asList (1, 2, 3, 4));
        HashSet <Integer> set2 = new HashSet <> (Arrays.asList (3, 5, 6, 7));
        System.out.println ("set1 = " + set1);
        System.out.println ("set2 = " + set2);
        set1.retainAll (set2);
        System.out.println ("intersection = " + set1);
    }
}
