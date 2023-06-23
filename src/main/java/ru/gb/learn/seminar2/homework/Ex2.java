package ru.gb.learn.seminar2.homework;

import java.util.Arrays;

public class Ex2
{
    public static void main (String[] args)
    {
//        int[] array = {0, 1, 2, 3, 4, 5, 6, 7};
//        int[] array = {0, 1, 2, 3, 4, 5, 6, 7, 7};
        int[] array = Utils.generateArray (10, 0, 10);
        System.out.println (Arrays.toString (array));
        if (isIncreasing (array)) System.out.println ("является возрастающей");
        else System.out.println ("не является возрастающей");
    }
    
    private static boolean isIncreasing (int[] array)
    {
        if (array.length < 2) return false;
        int prev = array[0];
        for (int i = 1; i < array.length; i++)
        {
            if (array[i] <= prev) return false;
            prev = array[i];
        }
        return true;
    }
}
