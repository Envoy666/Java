package ru.gb.learn.seminar3.homework.exercize4;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main
{
    public static void main (String[] args)
    {
        List <Integer> list = generateList (20, -10, 10);
        System.out.println ("list = " + list);
        soutMinMaxAvg (list);
    }
    
    /**
     * @param list список
     * @apiNote выводит минимальное, максимальное и среднее значение элементов списка
     */
    private static void soutMinMaxAvg (List <Integer> list)
    {
        int min = list.get (0);
        int max = list.get (0);
        int sum = 0;
        for (int i : list)
        {
            if (i < min) min = i;
            else if (i > max) max = i;
            sum += i;
        }
        
        System.out.println ("min = " + min);
        System.out.println ("max = " + max);
        System.out.println ("avg = " + (double) sum / list.size ());
    }
    
    
    /**
     * @param size размер списка
     * @param min  минимальное значение элемента
     * @param max  максимальное значение элемента
     * @return список
     * @apiNote генерирует целочисленный список указанного размера,
     * заполненный значениями в заданных пределах (включительно)
     */
    private static List <Integer> generateList (int size, int min, int max)
    {
        List <Integer> list = new ArrayList <> (size);
        Random random = new Random ();
        int bound = max - min + 1;
        for (int i = 0; i < size; i++) list.add (random.nextInt (bound) + min);
        return list;
    }
}
