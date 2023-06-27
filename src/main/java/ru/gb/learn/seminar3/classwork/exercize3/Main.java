package ru.gb.learn.seminar3.classwork.exercize3;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class Main
{
    public static void main (String[] args)
    {
        List <Cube> cubeList = fillCubeList (new ArrayList <> ());
        System.out.println ("cubeList = " + cubeList);
        
        int count = 0;
        int volumeSum = 0;
        int countWood = 0;
        
        for (Cube cube : cubeList)
        {
            if (cube.getColor ().equals (Color.YELLOW))
            {
                count++;
                volumeSum += cube.getVolume ();
            }
            
            if (cube.getMaterial ().equals ("дерево") && cube.getSize () == 3) countWood++;
        }
        System.out.println ("count = " + count);
        System.out.println ("volumeSum = " + volumeSum);
        System.out.println ("countWood = " + countWood);
        
        System.out.println ("uniqueCubeCollection (cubeList) = " + uniqueCubeCollection (cubeList));
    }
    
    /**
     * @apiNote заполняет список данными
     * @param list - список для заоъполнения
     * @return список
     */
    private static List <Cube> fillCubeList (List <Cube> list)
    {
        list.add (new Cube (3, Color.YELLOW, "дерево"));
        list.add (new Cube (3, Color.RED, "металл"));
        list.add (new Cube (4, Color.BLUE, "металл"));
        list.add (new Cube (2, Color.YELLOW, "полимер"));
        list.add (new Cube (3, Color.RED, "металл"));
        
        return list;
    }
    
    /**
     * @apiNote возвращает коллекцию с уникальными данными из исходного списка
     * @param list исходный список
     * @return коллекция
     */
    private static Collection <Cube> uniqueCubeCollection (List <Cube> list)
    {
        return new HashSet <Cube> (list);
    }
}
