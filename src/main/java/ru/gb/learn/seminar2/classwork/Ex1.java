package ru.gb.learn.seminar2.classwork;

import java.util.Scanner;

public class Ex1
{
    public static void main (String[] args)
    {
/*
        try
        {
            myPow (0.0, 0);
        }
        catch (Exception e)
        {
            System.out.println (e.getMessage ());
        }
*/
        Scanner scanner = new Scanner (System.in);
        System.out.print ("Введите число: ");
        double x = scanner.nextDouble ();
        System.out.print ("Введите степень: ");
        int y = scanner.nextInt ();
        scanner.close ();
        System.out.printf ("%1$s в степени %2$s = %3$s", x, y, myPow (x, y));
    }
    
    /**
     * @param x число
     * @param y степень
     * @return результат
     * @apiNote возводит число в степень
     */
    private static double myPow (double x, int y)
    {
        if (x == 0.0)
        {
            if (y == 0)
                throw new IllegalArgumentException ("0\u00b0 - является математической неопределенностью");
            return 0.0;
        }
        
        if (y > 0) return x * myPow (x, y - 1);
        else if (y < 0) return myPow (x, y + 1) / x;
        
        return 1.0;
    }
}
