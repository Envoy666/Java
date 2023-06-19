package ru.gb.learn.seminar1.homework;

import java.util.Arrays;

public class Ex7
{
    public static void main (String[] args)
    {
        // перебор а- и симметричных массивов с четным и нечетным количеством элементов
        int[] array1 = new int[] {0, 1, 2, 1, 0};
        int[] array2 = new int[] {0, 1, 2, 2, 1, 0};
        int[] array3 = new int[] {0, 1, 2, 3, 0};
        int[] array4 = new int[] {0, 1, 2, 3, 1, 0};
        int[][] sArray = new int[][] {array1, array2, array3, array4};
        for (int[] array : sArray)
        {
            System.out.print ("массив: " + Arrays.toString (array));
            if (checkArraySymmetry (array)) System.out.println (" - симметричный");
            else System.out.println (" - асимметричный");
        }
    }
    
    /**
     * @param array проверяемый массив
     * @return true, если массив симметричен. в противном случае - false
     * @apiNote проверяет массив на симметричность
     */
    private static boolean checkArraySymmetry (int[] array)
    {
        // логично интерпретировать пустой массив, как не имеющий симметрию (нет элементов)
        if (array.length == 0) return false;
        for (int i = 0, j = array.length - 1; i < j; i++, j--)
            if (array[i] != array[j]) return false;
        return true;
    }
}
