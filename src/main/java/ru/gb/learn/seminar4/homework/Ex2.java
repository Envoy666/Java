package ru.gb.learn.seminar4.homework;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.Stack;

public class Ex2
{
    public static void main (String[] args)
    {
        System.out.println ("isParenthesesValid (\"()\") = "
                                    + isBracketValid ("()")); // true
        System.out.println ("isParenthesesValid (\"() {} []\") = "
                                    + isBracketValid ("() {} []")); // true
        System.out.println ("isParenthesesValid (\"[{s} (qwerty)]\") = "
                                    + isBracketValid ("[{s} (qwerty)]"));
        System.out.println ("isParenthesesValid (\"{[(])}\") = "
                                    + isBracketValid ("{[(])}")); // false
        System.out.println ("isParenthesesValid (\"[[{{(())}}]]({[]})\") = "
                                    + isBracketValid ("[[{{(())}}]]({[]})")); // true
        System.out.println ("isParenthesesValid (\")\") = "
                                    + isBracketValid (")")); // false
    }
    
    /**
     * строка является валидной, если:
     * <ul>
     *     <li>все открывающие скобки должны быть закрыты скобками того же типа</li>
     *     <li>открывающие скобки должны быть закрыты в том же порядке</li>
     *     <li>каждой закрывающей скобке должна соответствовать открывающая скобка того же типа</li>
     * </ul>
     *
     * @param str проверяемая строка
     * @return возвращает <b>true</b>, если пары скобок корректны, иначе <b>false</b>
     * @apiNote проверяет строку на валидность
     */
    private static boolean isBracketValid (String str)
    {
        Stack <Character> bracketStack = new Stack <> ();
        CharacterIterator iterator = new StringCharacterIterator (str);
        while (iterator.current () != CharacterIterator.DONE)
        {
            char c = iterator.current ();
            if (isOpenBracket (c)) bracketStack.push (c);
            else if (isCloseBracket (c))
            {
                if (bracketStack.isEmpty ()
                            || !isPairedBrackets (c, bracketStack.pop ())) return false;
            }
            iterator.next ();
        }
        return true;
    }
    
    /**
     * @param c символ
     * @return возвращает <b>true</b>, если символ - открывающая скобка, иначе <b>false</b>
     * @apiNote проверяет, что символ является открывающей скобкой
     */
    private static boolean isOpenBracket (char c)
    {
        return c == '(' || c == '{' || c == '[';
    }
    
    /**
     * @param c символ
     * @return возвращает <b>true</b>, если символ - закрывающая скобка, иначе <b>false</b>
     * @apiNote проверяет, что символ является закрывающей скобкой
     */
    private static boolean isCloseBracket (char c)
    {
        return c == ')' || c == '}' || c == ']';
    }
    
    /**
     * @param c1 первый символ
     * @param c2 второй символ
     * @return возвращает <b>true</b>, если символы - открывающая и закрывающая скобки одного типа,
     * иначе <b>false</b>
     * @apiNote проверяет, что символы являются парой открывающей и закрывающей скобок одного типа
     */
    private static boolean isPairedBrackets (char c1, char c2)
    {
        if (c1 > c2) return isPairedBrackets (c2, c1);
        // хотел выехать на арифметике, но если символы '(' и ')' следуют друг за другом,
        // то, к сожалению, между '{' и '}', а также '[' и ']' есть символы '|' и '\'
        return (c1 == '(' && c2 == ')')
                       || (c1 == '{' && c2 == '}')
                       || (c1 == '[' && c2 == ']');
    }
}
