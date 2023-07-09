package ru.gb.learn.seminar6.classwork;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Ex3
{
    public static void main (String[] args)
    {
        List <String> list1 = Arrays.asList ("qwe", "asd", "qwe", "x");
        List <String> list2 = Arrays.asList ("qwe", "x");
        
        HashSet <String> set1 = new HashSet <> (list1);
        HashSet <String> set2 = new HashSet <> (list2);
        HashSet <String> intersection = new HashSet <> (set1);
        intersection.retainAll (set2);
        
        System.out.println ("list1 = " + list1);
        System.out.println ("list2 = " + list2);
        System.out.println ("intersection = " + intersection);
        
        HashMap <String, Integer> result = new HashMap <> (intersection.size ());
        countIntersections (intersection, list1, result);
        countIntersections (intersection, list2, result);
        System.out.println ("result = " + result);
    }
    
    /**
     * @param intersect множество, содержащее пересечения
     * @param list      список
     * @param result    словарь пересечений, где ключ-значение - это пересечение-количество
     * @apiNote считает количество вхождений каждого пересечения в списке
     */
    private static void countIntersections (HashSet <String> intersect,
                                            List <String> list,
                                            HashMap <String, Integer> result)
    {
        for (String s : list)
            if (intersect.contains (s)) result.put (s, result.getOrDefault (s, 0) + 1);
    }
}
