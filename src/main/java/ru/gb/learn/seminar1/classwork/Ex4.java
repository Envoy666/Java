package ru.gb.learn.seminar1.classwork;

import java.util.Scanner;

public class Ex4
{
    public static void main (String[] args)
    {
        Scanner scanner = new Scanner (System.in);
        System.out.print ("Введите строки: ");
        String str1 = scanner.nextLine ();
        String str2 = scanner.nextLine ();
        scanner.close ();
        System.out.println ("stringBinarySum(str1, str2) = " + stringBinarySum (str1, str2));
    }
    
    /**
     * @param str1 первая строка
     * @param str2 вторая строка
     * @return результат сложения
     * @apiNote возвращает сумму бинарных строк
     */
    private static String stringBinarySum (String str1, String str2)
    {
        if (str1.length () < str2.length ()) return stringBinarySum (str2, str1);
        StringBuilder sb = new StringBuilder ();
        int carriage = 0;
        for (int i = str1.length () - 1, j = str2.length () - 1; i >= 0; i--, j--)
        {
            if (str1.charAt (i) == '1') carriage++;
            if (j >= 0 && str2.charAt (j) == '1') carriage++;
            sb.insert (0, carriage % 2);
            carriage /= 2;
        }
        if (carriage > 0) sb.insert (0, '1');
        return sb.toString ();
    }
}
