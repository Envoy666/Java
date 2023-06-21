package ru.gb.learn.seminar2.classwork;

import java.util.Scanner;

import static java.lang.Math.abs;

public class Ex2
{
    public static void main (String[] args)
    {
        Scanner scanner = new Scanner (System.in);
        System.out.print ("Введите количество чисел: ");
        int n = scanner.nextInt ();
        System.out.println ("сумма = " + countFivesAfterEvens (n, scanner));
        scanner.close ();
    }
    
    /**
     * @param n       количество всех чисел
     * @param scanner экземпляр класса Scanner
     * @return сумму
     * @apiNote возвращает сумму чисел, оканчивающихся на 5, перед которыми идёт четное число
     */
    private static int countFivesAfterEvens (int n, Scanner scanner)
    {
        System.out.println ("Введите числа: ");
        int a = 1, b, sum = 0;
        for (int i = 0; i < n; i++)
        {
            b = scanner.nextInt ();
            if ((a & 1) == 0 && abs (b % 10) == 5) sum += b;
            a = b;
        }
        return sum;
    }
}
