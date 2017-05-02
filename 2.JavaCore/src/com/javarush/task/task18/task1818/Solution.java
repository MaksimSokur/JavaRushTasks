package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        String file3 = reader.readLine();

        FileOutputStream fileOutputStream =  new FileOutputStream(file1);
        FileInputStream fileInputStreamOne = new FileInputStream(file2);
        FileInputStream fileInputStreamTwo = new FileInputStream(file3);


        while (fileInputStreamOne.available() > 0){
            int data = fileInputStreamOne.read();
            fileOutputStream.write(data);
        }
        while (fileInputStreamTwo.available() > 0){
            int data = fileInputStreamTwo.read();
            fileOutputStream.write(data);
        }

        reader.close();
        fileInputStreamOne.close();
        fileInputStreamTwo.close();
        fileOutputStream.close();
    }
}
