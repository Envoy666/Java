package ru.gb.learn.seminar5.homework;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ex2
{
    public static void main (String[] args)
    {
        List <String> staffList = staffList ();
        HashMap <String, Integer> nameCountMap = countNames (staffList);
        List <Map.Entry <String, Integer>> entryList = new ArrayList <> (nameCountMap.entrySet ());
        entryList.sort (new ValueComparator ());
        outputPopularNames (entryList);
    }
    
    /**
     * @apiNote выводит только повторяющиеся имена из списка
     * @param entryList список сотрудников
     */
    private static void outputPopularNames (List <Map.Entry <String, Integer>> entryList)
    {
        for (Map.Entry <String, Integer> entry : entryList)
        {
            int count = entry.getValue ();
            if (count > 1) System.out.println ("Имя \"" + entry.getKey () + "\" повторяется "
                                                       + count + " раз(а)");
        }
    }
    
    /**
     * @param staffList список персонала
     * @return экземпляр HashMap &lt;String, Integer&gt; с данными
     * @apiNote подсчитывает повторы имён в списке персонала
     */
    private static HashMap <String, Integer> countNames (List <String> staffList)
    {
        HashMap <String, Integer> map = new HashMap <> ();
        for (String employee : staffList)
        {
            String name = employee.split ("\\s")[0];
            Integer count = map.get (name);
            map.put (name, count == null ? 1 : ++count);
        }
        return map;
    }
    
    /**
     * вынес, чтобы "разгрузить" main
     *
     * @return список
     * @apiNote создает список персонала
     */
    private static List <String> staffList ()
    {
        List <String> staff = new ArrayList <> ();
        staff.add ("Иван Иванов");
        staff.add ("Светлана Петрова");
        staff.add ("Кристина Белова");
        staff.add ("Анна Мусина");
        staff.add ("Анна Крутова");
        staff.add ("Иван Юрин");
        staff.add ("Петр Лыков");
        staff.add ("Павел Чернов");
        staff.add ("Петр Чернышов");
        staff.add ("Мария Федорова");
        staff.add ("Марина Светлова");
        staff.add ("Мария Савина");
        staff.add ("Мария Рыкова");
        staff.add ("Марина Лугова");
        staff.add ("Анна Владимирова");
        staff.add ("Иван Мечников");
        staff.add ("Петр Петин");
        staff.add ("Иван Ежов");
        return staff;
    }
    
    /**
     * компаратор, сравнивающий entry по убыванию значения
     */
    private static class ValueComparator implements Comparator<Map.Entry<String, Integer>>
    {
        @Override
        public int compare (Map.Entry <String, Integer> e1, Map.Entry <String, Integer> e2)
        {
            return e2.getValue ().compareTo (e1.getValue ());
        }
    }
}
