package com.javarush.task.task01.task0129;

/* 
Считаем длину окружности
*/

public class Solution {
    public static void main(String[] args) {
        printCircleLength(5);
    }

    public static void printCircleLength(int radius) {
        //напишите тут ваш код
        double l;
        double Pi = 3.14;
        l = 2 * Pi * radius;
        System.out.println(l);
    }
}