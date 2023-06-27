package ru.gb.learn.seminar3.classwork.exercize1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main
{
    public static void main (String[] args)
    {
        Scanner scanner = new Scanner (System.in);
        List <Item> itemList = inputItemList (scanner);
        System.out.println ("itemList = " + itemList);
        System.out.print ("Введите наименование товара: ");
        String name = scanner.nextLine ();
        
        List <String> countries = new ArrayList <> ();
        int total = 0;
        for (Item item : itemList)
            if (item.getName ().equals (name))
            {
                countries.add (item.getCountry ());
                total += item.getVolume ();
            }
        
        if (countries.isEmpty ()) System.out.println ("товар не найден");
        else
        {
            System.out.println ("countries = " + countries);
            System.out.println ("total = " + total);
        }
        scanner.close ();
    }
    
    /**
     * @apiNote организовывает ввод списка пользователем
     * @param scanner экземпляр класса Scanner
     * @return список
     */
    private static ArrayList <Item> inputItemList (Scanner scanner)
    {
        System.out.print ("введите количество элементов: ");
        int n = Integer.parseInt (scanner.nextLine ());
        ArrayList <Item> list = new ArrayList <> (n);
        for (int i = 0; i < n; i++)
        {
            Item item = new Item ();
            System.out.printf ("введите %s элемент: %n", i + 1);
            item.setName (scanner.nextLine ());
            item.setCountry (scanner.nextLine ());
            item.setVolume (Integer.parseInt (scanner.nextLine ()));
            list.add (item);
        }
        return list;
    }
}
