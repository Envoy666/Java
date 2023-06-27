package ru.gb.learn.seminar2.homework;

import java.util.ArrayList;
import java.util.Arrays;

import static java.lang.Math.sqrt;

public class Ex1
{
    public static void main (String[] args)
    {
//        testPrimeMethods ();
        // sum = 171, primes: 2, 3, 5, 7, 11, 17, 2, 23, 101
//        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 11, 17, -10, 0, 2, 23, 35, 101, 121, 999};
        int[] array = Utils.generateArray (20, -10, 100);
        System.out.println ("array = " + Arrays.toString (array));
        System.out.println ("primesList (array) = " + primesList (array));
        System.out.println ("primesSum (array) = " + primesSum (array));
    }
    
    /**
     * @param array массив целых чисел
     * @return результат
     * @apiNote вычисляет сумму простых чисел в массиве
     */
    private static int primesSum (int[] array)
    {
        int sum = 0;
        for (int item : array) if (isPrime (item)) sum += item;
        return sum;
    }
    
    /**
     * @param array массив целых чисел
     * @return список простых чисел
     * @apiNote вспомогательный метод. составляет список простых чисел в массиве. для удобства
     * проверки
     */
    private static ArrayList <Integer> primesList (int[] array)
    {
        ArrayList <Integer> list = new ArrayList <> ();
        for (int item : array) if (isPrime (item)) list.add (item);
        return list;
    }
    
    
    /**
     * сначала проверка на равенство 2 и 3, т.к. влияет на следующий этап.
     * в случае равенства возввращает <b>true</b>.
     * <p>
     * после исключаются числа:
     *     <ul>
     *     <li>меньшие 5, т.к. последовательность простых чисел начинается с 2,
     *     2 и 3 уже проверены, а 4 проверять нет смысла (четное)</li>
     *     <li>чётные, т.к. являются составными - делятся на 2</li>
     *     <li>делящиеся на 3, т.к. тоже являются составными</li>
     *     </ul>
     * в случае удовлетворения любому из указанных условий возввращает <b>false</b>.
     * <p>
     * после проверяются делители вида <b>6i±1</b>, где <b>i</b> - натуральное число<br>
     * <b>обоснование:</b><br>
     * предварительными проверками деления на 2 и 3 из каждой очередной шестерки чисел уже исключены
     * четные (3 значения из очередных 6), и делящееся на 3 (ещё 1 значение из очередных 6)
     * остаются только два числа вида <b>6i±1</b>
     * <p>
     * при этом предельным значением проверямых делителей будет целочисленное <b>n</b>,
     * равное корню квадратному проверяемого числа, либо ближайшее к корню в меньшую сторону<br>
     * <b>обоснование:</b><br>
     * при переборе потенциальных делителей устанавливаются такие пары чисел <b>n*m</b>, что
     * <b>n*m = number</b>, где <b>n > 1</b> и возрастает, а <b>m < number</b> и убывает<br>
     * очевидно, что при <b>n = m</b> или при <b>n = m - 1</b> все потенциальные
     * пары делителей проверены
     *
     * @param number проверяемое число
     * @return true, если число - простое, иначе - false
     * @apiNote проверяет число на простоту
     */
    public static boolean isPrime (int number)
    {
        if (number == 2 || number == 3) return true;
        if (number < 5 || (number & 1) == 0 || (number % 3) == 0) return false;
        int i = 1;
        int limit = (int) sqrt (number);
        while (true)
        {
            int divider1 = 6 * i - 1;
            if (divider1 > limit) break;
            if (number % divider1 == 0) return false;
            int divider2 = 6 * i + 1;
            if (divider2 > limit) break;
            if (number % divider2 == 0) return false;
            i++;
        }
        return true;
    }
    
    /*
    // это просто небольшие тесты
    private static boolean isPrimeStupid (int number)
    {
        if (number < 2) return false;
        if (number == 2 || number == 3) return true;
        for (int i = 2; i < number; i++)
        {
            if (number % i == 0)
            {
                return false;
            }
        }
        return true;
    }
    
    private static void testPrimeMethods ()
    {
        long t1 = System.currentTimeMillis ();
        for (int i = 0; i < 1000000; i++)
        {
//            isPrime (i); // ~40ms
//            isPrimeStupid (i); // ~48700ms
            if (isPrime (i) ^ isPrimeStupid (i))
            {
                System.out.println ("oops");
                break;
            }
        }
        long t2 = System.currentTimeMillis ();
        System.out.println ("t2 - t1 = " + (t2 - t1));
    }
     */
}
