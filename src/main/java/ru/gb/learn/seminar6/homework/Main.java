package ru.gb.learn.seminar6.homework;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main
{
    private static final List <Notebook> notebookList = createNotebookList ();
    private static final String[] attrs = Notebook.getAttrs ();
    private static final String columnNumbers;
    private static final String header;
    private static final String entryFormat;
    
    private static final List <Filter> filters = new ArrayList <> ();
    
    
    /*
     блок инициализации готовит предварительные данные
     */
    static
    {
        int columnWidth = 15;
        String format = "%-" + columnWidth + "s";
        // columnWidth + 1 - потому что один символ "пропадает" из-за % в выражении [%s]
        String numbersFormat = "%-" + (columnWidth + 1) + "s";
        numbersFormat = String.format (numbersFormat, "[%s]");
        
        StringBuilder numbersSb = new StringBuilder ();
        StringBuilder headerSb = new StringBuilder ();
        StringBuilder entryBuilder = new StringBuilder ();
        
        for (int i = 0; i < attrs.length; i++)
        {
            numbersSb.append (String.format (numbersFormat, i + 1));
            headerSb.append (String.format (format, attrs[i]));
            entryBuilder.append (format);
        }
        
        columnNumbers = numbersSb.toString ();
        header = headerSb.toString ();
        entryFormat = entryBuilder.toString ();
        
        // отсекаем единицы измерения, но не по пробелу, вдруг будет из 2 слов
        for (int i = 0; i < attrs.length; i++)
        {
            String[] split = attrs[i].split ("\\(");
            attrs[i] = split[0].trim ();
        }
    }
    
    public static void main (String[] args)
    {
        Scanner scanner = new Scanner (System.in);
        List <Notebook> filtredList = notebookList;
        while (true)
        {
            outputStatus (filtredList);
            if (!addFilters (scanner)) break;
            filtredList = filtreList ();
        }
        scanner.close ();
    }
    
    /**
     * @param scanner экземпляр класса Scanner
     * @return true - если работа должна быть продолжена, иначе false
     * @apiNote орагнизовывает взаимодействие с пользователем
     */
    private static boolean addFilters (Scanner scanner)
    {
        String inputStr;
        while (true)
        {
            System.out.println ("Enter column name or number to add filter," +
                                        " or \"clear\" to clear filter list, or \"exit\" to quit");
            inputStr = scanner.nextLine ();
            if (inputStr.equals ("exit"))
            {
                System.out.println ("Bye!");
                return false;
            }
            else if (inputStr.equals ("clear"))
            {
                filters.clear ();
                System.out.println ("Filters are cleared. Add new filter? Y/N");
                if (forceValidAnswer (scanner)) continue;
                else break;
            }
            
            newFilter (inputStr, scanner);
            System.out.println ("Add one more filter? Y/N");
            if (!forceValidAnswer (scanner)) break;
        }
        
        return true;
    }
    
    /**
     * @param inputStr строка, содержащая наименование или номер столбца таблицы товаров,
     *                 которые используются для определения нужного фильтра
     * @param scanner  экземпляр класса Scanner
     * @apiNote организовывает добавление фильтра в список
     */
    private static void newFilter (String inputStr, Scanner scanner)
    {
        int filterId = -1;
        try
        {
            filterId = Integer.parseInt (inputStr);
        }
        catch (NumberFormatException nfe)
        {
            for (int i = 0; i < attrs.length; i++)
            {
                if (attrs[i].equalsIgnoreCase (inputStr))
                {
                    filterId = i + 1;
                    break;
                }
            }
        }
        
        if (filterId < 0 || filterId > attrs.length)
        {
            System.out.println ("No such column. Filter won't be added");
        }
        else
        {
            if (filterId == 1)
            {
                System.out.println ("Enter Vendor name");
                filters.add (new StringFilter (scanner.nextLine ()));
            }
            else if (filterId == 6)
            {
                System.out.println ("Enter minimum value for Diagonal");
                try
                {
                    filters.add (new DoubleFilter (Double.parseDouble (scanner.nextLine ())));
                }
                catch (NumberFormatException nfe)
                {
                    System.out.println ("Wrong number format. Filter won't be added");
                }
            }
            else
            {
                System.out.println ("Enter minimum value for " + attrs[filterId - 1]);
                try
                {
                    filters.add (new IntegerFilter (filterId, Integer.parseInt (scanner.nextLine ())));
                }
                catch (NumberFormatException nfe)
                {
                    System.out.println ("Wrong number format. Filter won't be added");
                }
            }
        }
    }
    
    /**
     * @param scanner экземпляр класса Scanner
     * @return true - если введено Y, false - если N
     * @apiNote организовывает получение валидного ответа от пользователя - только Y или N
     */
    private static boolean forceValidAnswer (Scanner scanner)
    {
        String inputStr;
        while (true)
        {
            inputStr = scanner.nextLine ();
            if (inputStr.equalsIgnoreCase ("Y")) return true;
            if (inputStr.equalsIgnoreCase ("N")) return false;
            System.out.println ("Unknown command: " + inputStr);
        }
    }
    
    /**
     * @return список ноутбуков
     * @apiNote создает список ноутбуков, соответствующих критериям фильтров
     */
    private static List <Notebook> filtreList ()
    {
        List <Notebook> newList = new ArrayList <> ();
        for (Notebook n : notebookList)
        {
            if (matchFilters (n)) newList.add (n);
        }
        return newList;
    }
    
    /**
     * @param n ноутбук
     * @return true - если соответствует, иначе false
     * @apiNote проверяет соответствие ноутбука критерию фильтра
     */
    private static boolean matchFilters (Notebook n)
    {
        for (Filter filter : filters)
        {
            if (!filter.match (n)) return false;
        }
        return true;
    }
    
    /**
     * @param list список ноутбуков
     * @apiNote выводит статус: сведения о фильтрах и таблицу с данными ноутбуков из списка
     */
    private static void outputStatus (List <Notebook> list)
    {
        if (filters.isEmpty ()) System.out.println ("No filters applied");
        else
        {
            System.out.print ("Filters -> ");
            for (int i = 0; i < filters.size (); i++)
            {
                System.out.print (filters.get (i).toString ());
                if (i < filters.size () - 1) System.out.print (", ");
            }
            System.out.println ();
        }
        
        if (list.isEmpty ())
        {
            System.out.println ("no matches");
            return;
        }
        
        System.out.println (columnNumbers);
        System.out.println (header);
        for (Notebook n : list)
        {
            System.out.printf (entryFormat, n.getVendor (), n.getCPU (), n.getCores (),
                    n.getMemory (), n.getVolume (), n.getDiagonal (), n.getPrice ());
            System.out.println ();
        }
    }
    
    /**
     * @return список ноутбуков
     * @apiNote создает общий список ноутбуков
     */
    private static List <Notebook> createNotebookList ()
    {
        List <Notebook> list = new ArrayList <> ();
        list.add (new Notebook ("ASUS", 2700, 4, 8, 512, 14.0, 60000));
        list.add (new Notebook ("ASUS", 3000, 4, 8, 1024, 14.0, 80000));
        list.add (new Notebook ("Lenovo", 2700, 2, 4, 512, 13.3, 37000));
        list.add (new Notebook ("Lenovo", 3000, 4, 8, 512, 15.6, 60000));
        list.add (new Notebook ("Acer", 2400, 2, 4, 512, 15.6, 50000));
        list.add (new Notebook ("Acer", 3000, 4, 8, 1024, 15.6, 60000));
        list.add (new Notebook ("MSI", 3400, 6, 16, 1024, 17.3, 100000));
        list.add (new Notebook ("MSI", 2700, 4, 8, 512, 15.6, 60000));
        list.add (new Notebook ("HP", 2400, 4, 8, 512, 15.6, 60000));
        list.add (new Notebook ("HP", 3000, 4, 16, 512, 15.6, 70000));
        return list;
    }
}
