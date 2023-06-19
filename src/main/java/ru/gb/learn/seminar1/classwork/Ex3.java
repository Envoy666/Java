package ru.gb.learn.seminar1.classwork;

import java.util.Scanner;

public class Ex3
{
    public static void main (String[] args)
    {
        Scanner scanner = new Scanner (System.in);
        System.out.print ("Введите строку: ");
        String str = scanner.nextLine ();
        scanner.close ();
        System.out.println ("swapped word = " + swapWordHalves (str));
    }
    
    /**
     * @param str исходная строка
     * @return результирующая строка
     * @apiNote меняет половины строки местами
     */
    private static String swapWordHalves (String str)
    {
        int center = str.length () / 2;
        return str.substring (center) + str.substring (0, center);
    }
}
