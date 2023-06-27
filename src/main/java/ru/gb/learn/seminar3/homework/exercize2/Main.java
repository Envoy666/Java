package ru.gb.learn.seminar3.homework.exercize2;

import ru.gb.learn.seminar3.homework.exercize1.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static ru.gb.learn.seminar3.homework.exercize1.Main.fillProdList;

public class Main
{
    public static void main (String[] args)
    {
        List <Product> prodList = fillProdList (new ArrayList <> ());
        
        Scanner scanner = new Scanner (System.in);
        System.out.println ("Введите сорт: ");
        int sort = 0;
        while (true)
        {
            try
            {
                sort = Integer.parseInt (scanner.nextLine ());
                if (sort < Product.SORT1 || sort > Product.SORT3)
                {
                    System.out.println ("введено неверное значение");
                    continue;
                }
                break;
            }
            catch (NumberFormatException e)
            {
                System.out.println ("введено неверное значение");
            }
        }
        getMinPriceProductName (prodList, sort);
    }
    
    /**
     * @param prodList список товаров
     * @param sort     сорт товаров
     * @apiNote выводит наименования товаров указанного сорта с наименьшей ценой
     */
    private static void getMinPriceProductName (List <Product> prodList, int sort)
    {
        List <Product> prodSortList = new ArrayList <> ();
        int minPrice = Integer.MAX_VALUE;
        
        for (Product prod : prodList)
            if (prod.getSort () == sort)
            {
                if (prod.getPrice () < minPrice) minPrice = prod.getPrice ();
                prodSortList.add (prod);
            }
        
        for (Product prod : prodSortList)
            if (prod.getPrice () == minPrice) System.out.println (prod.getName ());
    }
}
