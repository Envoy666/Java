package ru.gb.learn.seminar2.classwork;

public class Ex4
{
    public static void main (String[] args)
    {
        Vector vector1 = new Vector (1, 2, 3);
        Vector vector2 = new Vector (1, 1, 1);
        
        System.out.println ("vector1.modulus () = " + vector1.modulus ());
        System.out.println ("vector2.modulus () = " + vector2.modulus ());
        
        System.out.println ("vector1.scalarMulti (vector2) = " + vector1.scalarMulti (vector2));
        // тут, очевидно, результат должен быть тем же
        System.out.println ("vector2.scalarMulti (vector1) = " + vector2.scalarMulti (vector1));
        
        // воспользуемся toString(), который предлагает record
        System.out.println ("vector1.vectorMulti (vector2) = " + vector1.vectorMulti (vector2));
        // тут должно получиться с противоположными знаками (противоположно направленный вектор)
        System.out.println ("vector2.vectorMulti (vector1) = " + vector2.vectorMulti (vector1));
        
        System.out.println ("vector1.cos (vector2) = " + vector1.cos (vector2));
        
        System.out.println ("vector1.sum (vector2) = " + vector1.sum (vector2));
        
        System.out.println ("vector1.dif (vector2) = " + vector1.dif (vector2));
        // тут должно получиться с противоположными знаками (противоположно направленный вектор)
        System.out.println ("vector2.dif (vector1) = " + vector2.dif (vector1));
    }
}
