package ru.gb.learn.seminar2.homework;

import java.util.Random;

public class Utils
{
    /**
     * @param size размер массива
     * @param min  минимальное значение элемента (включительно)
     * @param max  максимальное значение элемента (включительно)
     * @return массив целых чисел
     * @apiNote возвращает массив целых чисел указанного размера, заполненный значениями в заданном
     * диапазоне (включительно как для минимума, так и для максимума)
     */
    public static int[] generateArray (int size, int min, int max)
    {
        int[] array = new int[size];
        Random rnd = new Random ();
        int range = max - min + 1;
        for (int i = 0; i < array.length; i++)
        {
            array[i] = rnd.nextInt (range) + min;
        }
        return array;
    }
}