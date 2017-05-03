package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Solution {
    public static void main(String[] args)  throws Exception{

        FileInputStream fileInputStream = new FileInputStream(args[1]);
        FileOutputStream fileOutputStream = new FileOutputStream(args[2]);

        while (fileInputStream.available() > 0){
            int data = fileInputStream.read();
            fileOutputStream.write(data^6);
        }
        fileInputStream.close();
        fileOutputStream.close();
    }

}
