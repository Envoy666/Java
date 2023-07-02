package ru.gb.learn.seminar5.homework;

import java.util.HashMap;

public class Ex1
{
    // а тут больше подошли бы Pattern или Matcher
    public static void main (String[] args)
    {
        String word = "слова";
        String str = "Подсчитать количество искомого слова, через map (наполнением значение," +
                              " где искомое слово будет являться ключом), вносить все Слова не нужно";
        System.out.println ("countWord (word, str, false) = " + countWord (word, str, false));
        System.out.println ("countWord (word, str, true) = " + countWord (word, str, true));
        System.out.println ("countWord (\"строка\", str, true) = "
                                    + countWord ("строка", str, true));
    }
    
    /**
     * @apiNote считает количество вхождений искомого слова в строке
     * @param word искомое слово
     * @param str строка
     * @param ignoreCase <b>true</b>, если нужно игнорировать регистр, иначе <b>false</b>
     * @return количество вхождений
     */
    private static int countWord (String word, String str, boolean ignoreCase)
    {
        if (ignoreCase)
        {
            word = word.toLowerCase ();
            str = str.toLowerCase ();
        }
        String[] words = str.split ("[\\p{Punct}\\s]+");
        HashMap <String, Integer> map = new HashMap <> ();
        /*
         по условию все слова вносить не нужно, тогда есть смысл вносить только искомое,
         но тогда тем более не ясен смысл использования Map
         */
        for (String w : words)
        {
            if (word.equals (w))
            {
                /*
                 можно использовать метод contains(), но тогда получение элемента будет
                 осуществляться дважды: первый раз при вызове contains(), второй - при get()
                 */
                Integer count = map.get (word);
                map.put (word, count == null ? 1 : ++count);
            }
        }
        Integer count = map.get (word);
        return count == null ? 0 : count;
    }
}
