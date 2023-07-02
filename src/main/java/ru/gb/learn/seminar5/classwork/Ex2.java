package ru.gb.learn.seminar5.classwork;

import java.util.HashMap;

public class Ex2
{
    public static void main (String[] args)
    {
        int[] dupArray = {1, 2, 3, 4, 5, 1, 6, 7, 3, 6};
        System.out.println ("containsDubs (dupArray) = " + containsDubs (dupArray));
        int[] noDupArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        System.out.println ("containsDubs (noDupArray) = " + containsDubs (noDupArray));
    }
    
    /**
     * @param array целочисленный массив
     * @return возвращает <b>true</b>, если в массиве есть дубликаты, иначе возвращает <b>false</b>
     * @apiNote определяет наличие дубликатов в массиве
     */
    private static boolean containsDubs (int[] array)
    {
        // тут больше подойдет HashSet, но коль уж занятие посвящено HashMap
        HashMap <Integer, Object> map = new HashMap <> ();
        Object val = new Object ();
        for (int i : array)
        {
            if (map.containsKey (i)) return true;
            else map.put (i, val);
        }
        return false;
    }
}
