package ru.gb.learn.seminar4.classwork;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

// внезапно для себя вдруг обратил внимание, что есть exercize и exercise
// причем в разных источниках к первому варианту разное отношение...
public class ListExercizes
{
    public static void main (String[] args)
    {
        System.out.print ("Введите количество элементов: ");
        Scanner scanner = new Scanner (System.in);
        int n = scanner.nextInt ();
        scanner.close ();
//        int n = 10;
        LinkedList <Integer> list = generateList (n, -10, 10);
        // разнообразия ради, чтобы работало в том числе с учетом null
        // 3 - наобум, просто если коллекция слишком уж маленькая, то вобще ничего не останется
        if (n > 3) list.set (n / 2, null);
        list.add (null);
        System.out.println ("list = " + list);
        System.out.println ("reversedList (list) = " + reversedList (list));
        System.out.println ("evenIdxSum (list) = " + evenIdxSum (list));
        System.out.println ("evenItemsSum (list) = " + evenItemsSum (list));
        int oddSum = oddItemsSum (list);
        System.out.println ("oddItemsSum (list) = " + oddSum);
        System.out.println ("replacedList (list, evenSum) = " + replacedList (list, oddSum));
        removeNegative (list);
        System.out.println ("list with no negative = " + list);
    }
    
    /**
     * @param size размер списка
     * @param min  минимальное значение элемента
     * @param max  максимальное значение элемента
     * @return список
     * @apiNote генерирует целочисленный связанный список указанного размера,
     * заполненный значениями в заданных пределах (включительно)
     */
    private static LinkedList <Integer> generateList (int size, int min, int max)
    {
        LinkedList <Integer> list = new LinkedList <> ();
        Random random = new Random ();
        int bound = max - min + 1;
        for (int i = 0; i < size; i++) list.add (random.nextInt (bound) + min);
        return list;
    }
    
    /**
     * на семинаре это делали на leetcode.com, но пока разбирали задачу, я уже успел набросать код
     *
     * @param list исходный список
     * @return результирующий список
     * @apiNote возвращает список с обратным порядком элементов
     */
    private static LinkedList <Integer> reversedList (LinkedList <Integer> list)
    {
        LinkedList <Integer> newList = new LinkedList <> ();
        for (Integer i : list) newList.push (i);
        return newList;
    }
    
    /**
     * я сначала решил, что "сумму четных элементов" - имелось в виду по индексу
     *
     * @param list список
     * @return сумма
     * @apiNote вычисляет сумму элементов с чётным индексом
     */
    private static int evenIdxSum (LinkedList <Integer> list)
    {
        int sum = 0;
        // метод get будет работать немного дольше, т.к. он каждый раз перебирает все элементы,
        // начиная с первого и до требуемого индекса
        Iterator <Integer> iterator = list.listIterator ();
        int idx = 0;
        while (iterator.hasNext ())
        {
            Integer i = iterator.next ();
            if (i != null && (idx & 1) == 0) sum += i;
            idx++;
        }
        return sum;
    }
    
    /**
     * @param list список
     * @return сумма
     * @apiNote вычисляет сумму элементов с чётным значением
     */
    private static int evenItemsSum (LinkedList <Integer> list)
    {
        int sum = 0;
        for (Integer i : list) if (i != null && (i & 1) == 0) sum += i;
        return sum;
    }
    
    /**
     * @param list список
     * @return сумма
     * @apiNote вычисляет сумму элементов с нечётным значением
     */
    private static int oddItemsSum (LinkedList <Integer> list)
    {
        int sum = 0;
        for (Integer i : list) if (i != null && (i & 1) != 0) sum += i;
        return sum;
    }
    
    // это решил не исполльзовать
//    private static void replaceItem (LinkedList <Integer> list, int value)
//    {
//        for (int i = 0; i < list.size (); i++)
//        {
//            Integer item = list.get (i);
//            if (item !=null && item % 3 != 0) list.set (i, value);
//        }
//    }
    
    /**
     * сделал такую реащизацию, чтобы использовать исходную коллекцию до упора
     *
     * @param list  исходный список
     * @param value значение, которым заменяются требуемые элементы
     * @return результирующий список
     * @apiNote возвращает список, в котором элементы, некратные 3 заменены указанным значением
     */
    private static LinkedList <Integer> replacedList (LinkedList <Integer> list, int value)
    {
        LinkedList <Integer> newList = new LinkedList <> ();
        for (Integer item : list)
        {
            if (item != null && item % 3 != 0) item = value;
            newList.add (item);
        }
        return newList;
    }
    
    /**
     * @param list список
     * @apiNote удаляет отрицательные элементы из списка
     */
    private static void removeNegative (LinkedList <Integer> list)
    {
        Iterator <Integer> iterator = list.listIterator ();
        while (iterator.hasNext ())
        {
            Integer item = iterator.next ();
            if (item != null && item < 0) iterator.remove ();
        }
        // или так...
//        list.removeIf (item -> item != null && item < 0);
    }
}
