package ru.gb.learn.seminar1.classwork;

import java.util.Scanner;

public class Ex2
{
    public static void main (String[] args)
    {
        Scanner scanner = new Scanner (System.in);
        System.out.print ("Введите количество чисел: ");
        int n = scanner.nextInt ();
        System.out.println ("count = " + countNegativeAfterPositive (n, scanner));
        scanner.close ();
    }
    
    /**
     * @param n       количество всех чисел
     * @param scanner экземпляр класса Scanner
     * @return результат
     * @apiNote возвращает количество отрицательных чисел, следующих за положительными
     */
    private static int countNegativeAfterPositive (int n, Scanner scanner)
    {
        System.out.println ("Введите числа: ");
        int a = 0, b, count = 0;
        for (int i = 0; i < n; i++)
        {
            b = scanner.nextInt ();
            if (a > 0 && b < 0) count++;
            a = b;
        }
        return count;
    }
}
