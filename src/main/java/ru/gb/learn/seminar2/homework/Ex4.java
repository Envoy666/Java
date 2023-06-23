package ru.gb.learn.seminar2.homework;

import java.util.HashSet;

public class Ex4
{
    public static void main (String[] args)
    {
        char[][] board = validBoard ();
//        char[][] board = invalidBoard ();
        
        // хотел сначала сделать итератор с консьюмером и логгером или что-то такое, но лень
//        checkChars (board); // просмотрел, что контрактом оговорены символы и размерность :(
        checkRows (board);
        checkColumns (board);
        checkBlocks (board);
    }
    
    /**
     * @return массив
     * @apiNote возвращает валидный массив
     */
    private static char[][] validBoard ()
    {
        return new char[][] {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'},
        };
    }
    
    /**
     * в массив внесены изменения, чтобы проверить логику проверок
     * <ul>
     *     <li>некорректные символы d в одной строке (0)</li>
     *     <li>некорректные символы 0 в одном столбце (5)</li>
     *     <li>дубликаты 8 в строке 3 и столбце 3, 9 - в строке 7 и столбце 1</li>
     *     <li>в центральном блоке (1 : 1) дубликаты 8, а в правом нижнем (2 : 2) - дубликаты 5</li>
     *     <li>первый блок (0 : 0) заполнен, чтобы удостовериться, что HashSet заполняется корректно</li>
     * </ul>
     *
     * @return массив
     * @apiNote возвращает невалидный массив
     */
    private static char[][] invalidBoard ()
    {
        return new char[][] {
                {'5', '3', '4', 'd', '7', '0', '.', 'd', '.'},
                {'6', '2', '7', '1', '9', '5', '.', '.', '.'},
                {'1', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '8', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '0', '2', '8', '.'},
                {'.', '9', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '5', '7', '9'},
        };
    }
    
    /**
     * @param board проверяемый массив
     * @apiNote проверяет валидность символов в массиве
     */
    private static void checkChars (char[][] board)
    {
        int count = 0;
        for (int row = 0; row < board.length; row++)
            for (int col = 0; col < board[row].length; col++)
                if (!isCharValid (board[row][col]))
                {
                    count++;
                    System.out.printf ("неверный символ '%s' (строка %s, столбец %s)%n",
                            board[row][col], row, col);
                }
        if (count == 0) System.out.println ("все символы валидны");
    }
    
    /**
     * @param c проверяемый символ
     * @return возвращает <b>true</b>, если символ валиден, иначе возвращает <b>false</b>
     * @apiNote проверяет валидность символа
     */
    private static boolean isCharValid (char c)
    {
        return (c == '.' || (c >= '1' && c <= '9'));
    }
    
    /**
     * при выявлении несоответствия требованиям метод выводит соответствующую информацию
     * с указанием символа и его координат в массиве (строка и столбец)<br>
     * в случае валидности всех строк выводится соответствующее сообщение
     *
     * @param board проверяемый массив
     * @apiNote проверяет валидность строк
     */
    private static void checkRows (char[][] board)
    {
        int count = 0;
        for (int row = 0; row < board.length; row++)
        {
            HashSet <Character> set = new HashSet <> ();
            for (int col = 0; col < board[0].length; col++)
                if (isCharValid (board[row][col]) && board[row][col] != '.')
                    if (!set.add (board[row][col]))
                    {
                        count++;
                        System.out.printf ("дублирующий символ '%s' в строке %s (столбец %s)%n",
                                board[row][col], row, col);
                    }
            
            
        }
        if (count == 0) System.out.println ("все строки валидны");
    }
    
    /**
     * при выявлении несоответствия требованиям метод выводит соответствующую информацию
     * с указанием символа и его координат в массиве (строка и столбец)<br>
     * в случае валидности всех столбцов выводится соответствующее сообщение
     *
     * @param board проверяемый массив
     * @apiNote проверяет валидность столбцов
     */
    private static void checkColumns (char[][] board)
    {
        int count = 0;
        for (int col = 0; col < board[0].length; col++)
        {
            HashSet <Character> set = new HashSet <> ();
            for (int row = 0; row < board.length; row++)
                if (isCharValid (board[row][col]) && board[row][col] != '.')
                    if (!set.add (board[row][col]))
                    {
                        count++;
                        System.out.printf ("дублирующий символ '%s' в столбце %s (строка %s)%n",
                                board[row][col], col, row);
                    }
        }
        if (count == 0) System.out.println ("все столбцы валидны");
    }
    
    /**
     * при выявлении несоответствия требованиям метод выводит соответствующую информацию
     * с указанием символа и координат блока в массиве (блоки нумеруются с 0, слева направо,
     * сверху вниз)<br>
     * в случае валидности всех блоков выводится соответствующее сообщение
     *
     * @param board проверяемый массив
     * @apiNote проверяет валидность строк
     */
    private static void checkBlocks (char[][] board)
    {
        int count = 0;
        
        // хадукен XD
        for (int blockRow = 0; blockRow < 3; blockRow++)
        {
            int rowStart = 3 * blockRow;
            int rowEnd = rowStart + 3;
            for (int blockCol = 0; blockCol < 3; blockCol++)
            {
                int colStart = 3 * blockCol;
                int colEnd = colStart + 3;
                HashSet <Character> set = new HashSet <> ();
                for (int row = rowStart; row < rowEnd; row++)
                    for (int col = colStart; col < colEnd; col++)
                        if (isCharValid (board[row][col]) && board[row][col] != '.')
                            if (!set.add (board[row][col]))
                            {
                                count++;
                                System.out.printf ("дублирующий символ '%s' в блоке %s : %s%n",
                                        board[row][col], blockRow, blockCol);
                            }
            }
        }
        
        if (count == 0) System.out.println ("все блоки валидны");
    }
}
