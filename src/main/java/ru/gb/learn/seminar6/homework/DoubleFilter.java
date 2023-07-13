package ru.gb.learn.seminar6.homework;

public class DoubleFilter extends Filter
{
    private final double criteria;
    
    public DoubleFilter (double criteria)
    {
        this.criteria = criteria;
    }
    
    @Override
    boolean match (Notebook n)
    {
        return n.getDiagonal () >= criteria;
    }
    
    @Override
    public String toString ()
    {
        return "Diagonal: " + criteria;
    }
}
