package ru.gb.learn.seminar3.homework.exercize3;

import java.util.ArrayList;
import java.util.List;

import static ru.gb.learn.seminar2.homework.Ex1.isPrime;

public class Main
{
    public static void main (String[] args)
    {
        List <Book> bookList = fillBookList (new ArrayList <> ());
        findBooksByCriteria (bookList);
    }
    
    private static void findBooksByCriteria (List <Book> bookList)
    {
        for (Book book : bookList)
            if (book.getYear () >= 2010 && book.getAuthor ().contains ("А")
                        && isPrime (book.getPages ())) System.out.println (book.getName ());
    }
    
    private static List <Book> fillBookList (List <Book> list)
    {
        list.add (new Book ("Тень", "Афанасьев", 400, 2010, 101));
        list.add (new Book ("Какая-то книга", "Нонейм", 700, 1988, 51));
        list.add (new Book ("Как понять ничто", "Пронин", 550, 2020, 22));
        list.add (new Book ("Кот", "Авдеев", 400, 2017, 53));
        list.add (new Book ("Усталость", "Прайс", 600, 2010, 97));
        return list;
    }
}
