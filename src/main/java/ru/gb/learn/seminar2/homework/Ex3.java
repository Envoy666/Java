package ru.gb.learn.seminar2.homework;

import java.util.Arrays;

public class Ex3
{
    public static void main (String[] args)
    {
        int[] array = Utils.generateArray (10, -50, 50);
        System.out.println ("исходный массив = " + Arrays.toString (array));
        int sum = twoDigitNumberIdxSum (array);
        System.out.println ("сумма индексов двузначных чисел = " + sum);
        replaceNegativeNumbers (array, sum);
        System.out.println ("результирующий массив = " + Arrays.toString (array));
    }
    
    /**
     * @param array  массив целых чисел
     * @param number число для замены
     * @apiNote заменяет отрицательные элементы массива на указанное число
     */
    private static void replaceNegativeNumbers (int[] array, int number)
    {
        for (int i = 0; i < array.length; i++)
        {
            if (array[i] < 0) array[i] = number;
        }
    }
    
    /**
     * @param array массив целых чисел
     * @return сумму
     * @apiNote вычисляет сумму индексов двузначных чисел
     */
    private static int twoDigitNumberIdxSum (int[] array)
    {
        int sum = 0;
        int number, digits;
        for (int i = 0; i < array.length; i++)
        {
            number = array[i];
            digits = 0;
            while (number != 0)
            {
                number /= 10;
                digits++;
            }
            if (digits == 2) sum += i;
        }
        return sum;
    }
}
