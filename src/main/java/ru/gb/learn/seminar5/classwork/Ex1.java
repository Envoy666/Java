package ru.gb.learn.seminar5.classwork;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.HashMap;
import java.util.Map;

public class Ex1
{
    public static void main (String[] args)
    {
        String str = "qwrewt tirutri vmdkvdfj wrerwqeq";
//        System.out.println ("countCharacters (str) = " + countCharacters (str));
        HashMap <Character, Integer> charCountMap = countCharacters (str);
        outputMap (charCountMap);
    }
    
    /**
     * @param str строка
     * @return экземпляр HashMap &lt;Character, Integer&gt; с данными
     * @apiNote считает количество вхождений каждого символа в текст.
     * при этом символ является ключом, количество вхождений - значением
     */
    private static HashMap <Character, Integer> countCharacters (String str)
    {
        HashMap <Character, Integer> charCountMap = new HashMap <> ();
        
        CharacterIterator iterator = new StringCharacterIterator (str);
        while (iterator.current () != CharacterIterator.DONE)
        {
            char c = iterator.current ();
            // если пробелы не нужно считать за символы, то можно добавить соответствующее условие,
            // используя методы isSpaceChar() или isWhiteSpace(), например:
//            if (!Character.isSpaceChar (c))
//            {
            Integer count = charCountMap.get (c);
            count = count == null ? 1 : count + 1;
            charCountMap.put (c, count);
//            }
            iterator.next ();
        }
        
        return charCountMap;
    }
    
    /**
     * @param charCountMap экземпляр HashMap &lt;Character, Integer&gt; с данными
     * @apiNote выводит информацию о символах и количестве их вхождений из HashMap
     */
    private static void outputMap (HashMap <Character, Integer> charCountMap)
    {
        for (Map.Entry <Character, Integer> entry : charCountMap.entrySet ())
        {
            System.out.printf ("'%s' встретился %s раз(а)%n", entry.getKey (), entry.getValue ());
        }
    }
}
