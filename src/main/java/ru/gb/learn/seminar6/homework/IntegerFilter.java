package ru.gb.learn.seminar6.homework;

public class IntegerFilter extends Filter
{
    private final int column;
    private final int criteria;
    
    public IntegerFilter (int column, int criteria)
    {
        this.column = column;
        this.criteria = criteria;
    }
    
    @Override
    boolean match (Notebook n)
    {
        int value;
        switch (column)
        {
            case 2 -> value = n.getCPU ();
            case 3 -> value = n.getCores ();
            case 4 -> value = n.getMemory ();
            case 5 -> value = n.getVolume ();
            case 7 -> value = n.getPrice ();
            default ->
            {
                return false;
            }
        }
        return value >= criteria;
    }
    
    @Override
    public String toString ()
    {
        return Notebook.getAttrs ()[column - 1] + ": " + criteria;
    }
}
