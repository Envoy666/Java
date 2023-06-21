package ru.gb.learn.seminar1.homework;

import java.util.Scanner;

public class Ex5
{
    public static void main (String[] args)
    {
        System.out.println ("sumPositiveBeforeNegative () = " + sumPositiveBeforeNegative ());
    }
    
    /**
     * @return результат
     * @apiNote возвращает сумму положительных чисел, после которых следует отрицательное число
     */
    private static int sumPositiveBeforeNegative ()
    {
        System.out.println ("Введите числа (для завершения введите 0):");
        Scanner scanner = new Scanner (System.in);
        int a = 0;
        int b;
        int sum = 0;
        while ((b = scanner.nextInt ()) != 0)
        {
            if (a > 0 && b < 0) sum += a;
            a = b;
        }
        scanner.close ();
        return sum;
    }
}
