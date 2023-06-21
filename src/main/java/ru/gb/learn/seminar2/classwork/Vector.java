package ru.gb.learn.seminar2.classwork;

import static java.lang.Math.sqrt;

public record Vector(double x, double y, double z)
{
    /**
     * @return модуль вектора
     * @apiNote определяет модуль вектора (длину отрезка)
     */
    public double modulus ()
    {
        return sqrt (x * x + y * y + z * z);
    }
    
    /**
     * @param v вектор, на который производится умножение
     * @return результат
     * @apiNote определяет скалярное произведение векторов
     */
    public double scalarMulti (Vector v)
    {
        return x * v.x + y * v.y + z * v.z;
    }
    
    /**
     * @param v вектор, на который производится умножение
     * @return результирующий вектор
     * @apiNote определяет векторное произведение векторов
     */
    public Vector vectorMulti (Vector v)
    {
        return new Vector (y * v.z - z * v.y, z * v.x - x * v.z, x * v.y - y * v.x);
    }
    
    /**
     * @param v вектор, относительно которого определяется угол
     * @return значение косинуса угла
     * @apiNote определяет значение косинуса угла между векторами
     */
    public double cos (Vector v)
    {
        return scalarMulti (v) / (modulus () * v.modulus ());
    }
    
    // todo: методы сложения и вычитания
}
