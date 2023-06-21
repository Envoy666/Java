package ru.gb.learn.seminar1.homework;

import java.util.Scanner;
import java.util.StringJoiner;
import java.util.regex.Pattern;

public class Ex6
{
    public static void main (String[] args)
    {
        Scanner scanner = new Scanner (System.in);
        System.out.print ("Введите строку: ");
        String inputStr = scanner.nextLine ();
        System.out.println ("reverseWordOrder (inputStr) = " + reverseWordOrder (inputStr));
    }
    
    
    /**
     * @param str исходная строка
     * @return результирующая строка
     * @apiNote обращает порядок слов в строке
     */
    private static String reverseWordOrder (String str)
    {
        Pattern spaces = Pattern.compile ("\\s+");
        String[] words = spaces.split (str);
        StringJoiner stringJoiner = new StringJoiner (" ");
        int end = words[0].isEmpty () ? 1 : 0;
        for (int i = words.length - 1; i >= end; i--)
        {
            stringJoiner.add (words[i]);
        }
        return stringJoiner.toString ();
    }
}
