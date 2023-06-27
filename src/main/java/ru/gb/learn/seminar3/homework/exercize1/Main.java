package ru.gb.learn.seminar3.homework.exercize1;

import java.util.ArrayList;
import java.util.List;

public class Main
{
    public static void main (String[] args)
    {
        List <Product> prodList = fillProdList (new ArrayList <> ());
        System.out.println ("findMaxPrice (prodList) = " + findMaxPrice (prodList));
    }
    
    /**
     * @param prodList список товаров
     * @return максимальная цена
     * @apiNote возвращает значение макчимальной цены товаров 1 и 2 сорта,
     * содержащих слово "высший" в наименовании, или 0
     */
    private static int findMaxPrice (List <Product> prodList)
    {
        int maxPrice = 0;
        for (Product prod : prodList)
            if ((prod.getSort () == Product.SORT1
                        || prod.getSort () == Product.SORT2)
                        && prod.getName ().toLowerCase ().contains ("высший")
                        && prod.getPrice () > maxPrice) maxPrice = prod.getPrice ();
        
        return maxPrice;
    }
    
    /**
     * сделал пабликом для повторного исполльзования в задании 2
     *
     * @param list список для заполнения
     * @return список
     * @apiNote заполняет список товаров данными
     */
    public static List <Product> fillProdList (List <Product> list)
    {
        list.add (new Product ("Высший эльф. Табак", "Бразилия", Product.SORT1, 450, 100));
        list.add (new Product ("Kent. Сигареты с фильтром", "Америка", Product.SORT1, 225, 100));
        list.add (new Product ("Высший свет. Вино", "Италия", Product.SORT2, 550, 500));
        list.add (new Product ("Киндзмараули. Вино", "Грузия", Product.SORT2, 550, 500));
        list.add (new Product ("Высший орден. Табак", "Куба", Product.SORT3, 195, 100));
        list.add (new Product ("Донской табак. Сигареты с фильтром", "Россия", Product.SORT3, 195, 100));
        return list;
    }
}
