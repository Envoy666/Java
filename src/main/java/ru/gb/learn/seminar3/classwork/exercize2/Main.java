package ru.gb.learn.seminar3.classwork.exercize2;

import java.util.ArrayList;
import java.util.List;

public class Main
{
    public static void main (String[] args)
    {
        List <Student> studList = fillStudList (new ArrayList <> ());
        
        for (Student student : studList)
            if (student.getName ().endsWith ("ова") &&
                        (scoreSum (student.getScoresList ()) & 1) == 0)
                System.out.println ("salary = " + student.getSalary ());
    }
    
    /**
     * @param scoresList - список баллов
     * @return результат
     * @apiNote вычисляет сумму баллов в списке
     */
    private static int scoreSum (List <Integer> scoresList)
    {
        int sum = 0;
        for (int score : scoresList) sum += score;
        return sum;
    }
    
    /**
     * вынес отдельно, чтобы "разгрузить" мэйн
     *
     * @param studList - список для заполнения
     * @return список
     * @apiNote заполняет список данными
     */
    private static List <Student> fillStudList (List <Student> studList)
    {
        studList.add (new Student ("Иванов", 11, 1100, List.of (3, 4, 4)));
        studList.add (new Student ("Петрова", 12, 1200, List.of (3, 4, 5)));
        studList.add (new Student ("Сидорова", 13, 1300, List.of (5, 4, 3)));
        return studList;
    }
}
