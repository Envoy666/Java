package ru.gb.learn.seminar6.homework;

public class StringFilter extends Filter
{
    
    private final String criteria;
    
    public StringFilter (String criteria)
    {
        this.criteria = criteria;
    }
    
    @Override
    boolean match (Notebook n)
    {
        return criteria.equalsIgnoreCase (n.getVendor ());
    }
    
    @Override
    public String toString ()
    {
        return "Vendor: " + criteria;
    }
}
