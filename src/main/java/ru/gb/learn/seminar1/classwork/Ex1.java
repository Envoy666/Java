package ru.gb.learn.seminar1.classwork;

import java.util.Scanner;

public class Ex1
{
    public static void main (String[] args)
    {
        Scanner scanner = new Scanner (System.in);
        System.out.print ("Введите число: ");
        int n = scanner.nextInt ();
        scanner.close ();
        System.out.println ("subtractProductAndSum (n) = " + subtractProductAndSum (n));
    }
    
    /**
     * @param n заданное число
     * @return результат
     * @apiNote возвращает разность между произведением и суммой цифр числа
     */
    private static int subtractProductAndSum (int n)
    {
        int sum = 0, pr = 1;
        while (n != 0)
        {
            int digit = n % 10;
            sum += digit;
            pr *= digit;
            n /= 10;
        }
        return pr - sum;
    }
}