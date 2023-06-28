package ru.gb.learn.seminar4.homework;

import java.util.Scanner;
import java.util.Stack;

public class Ex1
{
    public static void main (String[] args)
    {
        Stack <Integer> stack = new Stack <> ();
        fillStack (stack);
        System.out.println ("stack = " + stack);
        reversedOutput (stack);
    }
    
    /**
     * @param stack стек
     * @apiNote выводит содержимое стека
     */
    private static void reversedOutput (Stack <Integer> stack)
    {
        // т.к. задачи сохранить коллекцию нетронутой не было, то примерно так
        while (!stack.isEmpty ()) System.out.printf ("%s ", stack.pop ());
    }
    
    /**
     * @param stack стек
     * @apiNote организовывает ввод стека пользователем
     */
    private static void fillStack (Stack <Integer> stack)
    {
        System.out.print ("Введите количество элементов: ");
        Scanner scanner = new Scanner (System.in);
        int n = scanner.nextInt ();
        System.out.println ("Введите элементы: ");
        for (int i = 0; i < n; i++)
        {
            stack.push (scanner.nextInt ());
        }
        scanner.close ();
    }
}
