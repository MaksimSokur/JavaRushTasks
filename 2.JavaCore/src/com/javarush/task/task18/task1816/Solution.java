package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.FileInputStream;

public class Solution {
    public static void main(String[] args) throws Exception {
        int count = 0;
        if(args.length > 0){
            FileInputStream fileInputStream = new FileInputStream(args[0]);
            while (fileInputStream.available() > 0){
                int data = fileInputStream.read();
                if((data >= (int) 'A') && (data <= (int)'Z') ||
                        (data >= (int) 'a') && (data <= (int) 'z'))
                    count++;
            }
            fileInputStream.close();
        }
        System.out.println(count);
    }
}
