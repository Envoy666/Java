package ru.gb.learn.seminar3.classwork.exercize2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Student
{
    private String name;
    private int group;
    private int salary;
    private List <Integer> scoresList;
}
