package ru.gb.learn.seminar1.homework;

import java.util.Arrays;

public class Ex8
{
    public static void main (String[] args)
    {
        int[] input = new int[] {1, 2, 3, 4, 5};
        System.out.println ("runningSum (input) = " + Arrays.toString (runningSum (input)));
    }
    
    /**
     * @param array массив элементов
     * @return массив сумм
     * @apiNote возвращает массив со значениями текущей суммы элементов
     */
    private static int[] runningSum (int[] array)
    {
        int[] result = new int[array.length];
        int sum = 0;
        for (int i = 0; i < array.length; i++)
        {
            sum += array[i];
            result[i] = sum;
        }
        return result;
    }
}
