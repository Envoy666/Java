package ru.gb.learn.seminar5.classwork;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.HashMap;
import java.util.HashSet;

public class Ex3
{
    /*
     посмотрел, что есть классическое и упрощенное представление
     упрощенное имеет ряд допущений и вычислять проще, но классическое реализовать интереснее,
     т.е. записи типа MIM - 1999 будут считаться некорректными.
     а в целом - тут напрашивается enum, imho
     */
    
    /**
     * см. {@link #createRomanMap() createRomanMap}
     */
    static HashMap <Character, Integer> romanMap;
    static HashMap <Integer, Integer> orderMap;
    static HashSet <Integer> substrSet;
    
    static
    {
        romanMap = new HashMap <> ();
        romanMap.put ('I', 1);
        romanMap.put ('V', 5);
        romanMap.put ('X', 10);
        romanMap.put ('L', 50);
        romanMap.put ('C', 100);
        romanMap.put ('D', 500);
        romanMap.put ('M', 1000);
        
        orderMap = new HashMap <> ();
        orderMap.put (1, 1);
        orderMap.put (4, 1);
        orderMap.put (5, 1);
        orderMap.put (9, 1);
        orderMap.put (10, 10);
        orderMap.put (40, 10);
        orderMap.put (50, 10);
        orderMap.put (90, 10);
        orderMap.put (100, 100);
        orderMap.put (400, 100);
        orderMap.put (500, 100);
        orderMap.put (900, 100);
        orderMap.put (1000, 1000);
        
        substrSet = new HashSet <> ();
        substrSet.add (4);
        substrSet.add (9);
        substrSet.add (40);
        substrSet.add (90);
        substrSet.add (400);
        substrSet.add (900);
    }
    
    public static void main (String[] args)
    {
        String[] testRomanStrs = {
                "I",
                "XC",
                "MDCLXVI",
                "MMMDCCCLXXXVIII",
                " ",
                "XXV",
                "XXA",
                "LLIX",
                "MCM",
                "MIM",
                "XIX",
                "XIIX",
                "IXCD",
                "CCCC",
                "XXXIX",
                "XXIXX",
                "IVI",
                "XXIXIX",
                "IXIV",
                "MMMCMXCIX",
        };
        
        for (String s : testRomanStrs)
        {
            try
            {
                System.out.println ("convertRomanToDecimal (\"" + s + "\") = "
                                            + convertRomanToDecimal (s));
            }
            catch (IllegalArgumentException iae)
            {
                System.out.println ("convertRomanToDecimal (\"" + s + "\") = " + iae);
            }
        }
    }
    
    /**
     * правила:
     * <ul>
     *     <li>строка не должна содержать пробелы или другие символы,
     *     кроме I, V, X, L, C, D, M</li>
     *     <li>сначала указываются большие порядки, потом меньшие, т.е. цифры меньших значений
     *     должны следовать после цифр больших значений, за исключением случаев вычитания</li>
     *     <li>значения меньших цифр, следующих после больших, суммируются к общему значению</li>
     *     <li>значение меньшей цифры, предшествующей большей, вычитается из значения большей</li>
     *     <li>существует только 6 вариантов вычитания: IV, IX, XL, XC, CD, CM</li>
     *     <li>цифры M, C, X, I могут повторяться до 3 раз в качестве слагаемых,
     *     и еще один раз после этого в составе вычитания</li>
     *     <li>цифры V, L, D не должны повторяться, т.е. или используются однократно в качестве
     *     слагаемого, или однократно в составе вычитания</li>
     *     <li>вычитания и цифры, соответствующие большим порядкам, не должны следовать
     *     после вычитаний, соответствующих меньшим порядкам</li>
     *     <li>повтор вычитания или последовательность вычитаний одного порядка не допускаются</li>
     * </ul>
     * <p>
     *
     * @param str конвертируемая строка
     * @return десятичное число
     * @throws IllegalArgumentException если строка не соответствует правилам
     * @apiNote конвертирует строку, представляющую число, записанное римскими цифрами,
     * в десятичное значение в соответствии со словарем и правилами
     */
    private static int convertRomanToDecimal (String str)
    {
        if (str.isBlank ()) throw new IllegalArgumentException ("пустая строка");
        
        HashMap <Integer, Boolean> singletonMap = createSingletonMap ();
        CharacterIterator iterator = new StringCharacterIterator (str);
        
        char prev = iterator.current ();
        int prevVal = getValue (prev);
        int count = 1;
        int decimal = prevVal;
        int order = orderMap.get (prevVal);
        boolean orderBySubstr = false;
        
        // сразу проверяем, является ли цифрой однократного использования: V, L, D
        if (singletonMap.get (prevVal) != null) singletonMap.put (prevVal, true);
        
        char cur;
        while ((cur = iterator.next ()) != CharacterIterator.DONE)
        {
            /*
             тут я, в первом приближении, смотрел сразу последующий символ, но
             это опять приводило к усложнению кода всевозможными вложенными проверками
             до состояния "хадукен", а их и так хватает, поэтому рефакторнул немного
             */
            int curVal = getValue (cur);
            int curOrder;
            // сразу проверяем на повтор цифры однократного использования
            Boolean isSingletonRepeat = singletonMap.get (curVal);
            if (isSingletonRepeat != null && isSingletonRepeat)
                throw new IllegalArgumentException ("повтор цифры " + cur);
            if (prevVal < curVal)
            {
                /*
                 в этом случае должны выполняться условия:
                 1) только вычитание и только из разрешенных вариантов
                 2) вычитание не должно повторяться
                 3) предыдущий символ (вычитаемый) не более 1 раза
                 4) следование порядков
                 частично они перекрываются проверками в других ветках
                 */
                int substrVal = curVal - prevVal;
                if (!substrSet.contains (substrVal))
                    throw new IllegalArgumentException ("неверное вычитание " + prev + cur);
                if (count > 1)
                    throw new IllegalArgumentException ("вычитание более одного " + prev + " из " + cur);
                curOrder = orderMap.get (substrVal);
                if (curOrder > order)
                    throw new IllegalArgumentException ("переход от меньшего порядка к большему на " + prev + cur);
                orderBySubstr = true;
                count = 1;
                decimal = decimal - prevVal + substrVal;
            }
            else if (cur == prev)
            {
                /*
                 в этом случае должны выполняться условия:
                 1) повтор только символов M, C, X, I (но V, L, D уже исключены ранее)
                 2) повтор указанных символов не более 3 раз
                 3) следование порядков
                 */
                if (++count > 3)
                    throw new IllegalArgumentException ("повтор цифры " + cur + " более 3 раз");
                /*
                 следующая ситуация может возникнуть только после вычитания,
                 где в качестве уменьшаемого была текущая цифра
                 */
                curOrder = orderMap.get (curVal);
                if (order < curOrder)
                    throw new IllegalArgumentException ("повтор цифры " + cur + " после вычитания");
                orderBySubstr = false;
                decimal += curVal;
            }
            else
            {
                curOrder = orderMap.get (curVal);
                if (curOrder == order && orderBySubstr)
                {
                    /*
                     тут, для большей информативности, разделить несколько случаев, т.к.
                     всё равно уже выбрасываем исключение
                     */
                    char next = iterator.next ();
                    if (next == CharacterIterator.DONE || !substrSet.contains (getValue (next) - curVal))
                        throw new IllegalArgumentException ("цифра " + cur + " после вычитания того же порядка");
                    else if (prev == next)
                        throw new IllegalArgumentException ("повтор вычитания " + cur + next);
                    else
                        throw new IllegalArgumentException ("использование вычитания того же порядка на " + cur + next);
                }
                orderBySubstr = false;
                count = 1;
                decimal += curVal;
            }
            order = curOrder;
            prevVal = curVal;
            prev = cur;
        }
        return decimal;
    }
    
    /**
     * применяется для определения повторного использования цифр
     *
     * @return словарь цифр однократного использования
     * @apiNote создает словарь цифр однократного использования: V, L, D
     * <p>
     * где парой <b>ключ-значение</b>
     * является <b>цифра - признак повторного использования</b>
     * <p>
     * (<b>false</b> - ещё не использовалась, <b>true</b> - уже использовалась)
     */
    private static HashMap <Integer, Boolean> createSingletonMap ()
    {
        HashMap <Integer, Boolean> map = new HashMap <> ();
        map.put (5, false);
        map.put (50, false);
        map.put (500, false);
        return map;
    }
    
    /**
     * @param c символ римской цифры
     * @return десятичное значение
     * @throws IllegalArgumentException если символ не является римской цифрой
     * @apiNote вспомогательный метод. возвращает десятичное значение римской цифры
     */
    private static int getValue (char c)
    {
        Integer i = romanMap.get (c);
        if (i == null) throw new IllegalArgumentException ("неверный символ " + c);
        return i;
    }
    
    /**
     * сначала сделал отдельным методом, присваивал результат в переменную,
     * которую передавал в convertRomanToDecimal() в качестве аргумента.
     * потом решил, что для конкретной задачи можно несколько иначе,
     * потому как какой смысл передавать, если иной альтернативы (другого Map) нет
     * <p>>
     * то же самое касательно Map порядков и Set вычитаний - сразу реализовал в статическом
     * блоке инициализации
     *
     * @return словарь римских цифр
     * @apiNote создает словарь римских цифр, где парой <b>ключ-значение</b>
     * является <b>римская цифра - её десятичное значение</b>
     */
    private static HashMap <Character, Integer> createRomanMap ()
    {
        HashMap <Character, Integer> map = new HashMap <> ();
        map.put ('I', 1);
        map.put ('V', 5);
        map.put ('X', 10);
        map.put ('L', 50);
        map.put ('C', 100);
        map.put ('D', 500);
        map.put ('M', 1000);
        return map;
    }
}
