package ru.gb.learn.seminar2.classwork;

import java.util.Random;

public class Ex3
{
    public static void main (String[] args)
    {
        // из условия "дан массив" неясно, надо ли массив вводить или определять
        int[] array = new int[] {4, 2, 3, 5, 6, 3, 0, 9};
        Random rnd = new Random ();
        System.out.println ("countPair (array) = " + countPair (array));
    }
    
    /**
     * @param array массив целых чисел
     * @return результат
     * @apiNote определяет количество пар соседних элементов, где первый элемент вдвое больше второго
     */
    private static int countPair (int[] array)
    {
        int count = 0;
        for (int i = 1; i < array.length; i++)
        {
            if (array[i - 1] == 2 * array[i]) count++;
        }
        
        return count;
    }
}
