package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.FileInputStream;

public class Solution {
    public static void main(String[] args) throws Exception{
        int count = 0;
        int spaces = 0;
        double result = 0;
        if (args.length > 0){
            FileInputStream fileInputStream = new FileInputStream(args[0]);
            while (fileInputStream.available() > 0){
                count++;
                int data = fileInputStream.read();
                if(data == (int) ' '){
                    spaces++;
                }
            }
            fileInputStream.close();
        }
        if (count == 0){

        }
        else {
            result = (double)spaces / count * 100;
        }
        System.out.printf("%.2f", result);
    }
}
