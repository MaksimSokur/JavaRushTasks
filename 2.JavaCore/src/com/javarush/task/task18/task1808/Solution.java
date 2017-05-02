package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStreamOne = new FileInputStream(reader.readLine());
        FileOutputStream fileOutputStreamOne = new FileOutputStream(reader.readLine());
        FileOutputStream fileOutputStreamTwo = new FileOutputStream(reader.readLine());

        while (fileInputStreamOne.available() > 0)
        {
            if(fileInputStreamOne.available()%2 == 0)
            {
            byte [] o1 = new byte[fileInputStreamOne.available()/2];
            byte [] o2 = new byte[fileInputStreamOne.available()/2];
            int count1 = fileInputStreamOne.read(o1);
            int count2 = fileInputStreamOne.read(o2);
            fileOutputStreamOne.write(o1, 0, count1);
            fileOutputStreamTwo.write(o2, 0, count2);
            }else{
                byte [] o1 = new byte[fileInputStreamOne.available()/2 + 1];
                byte [] o2 = new byte[fileInputStreamOne.available()/2];
                int count1 = fileInputStreamOne.read(o1);
                int count2 = fileInputStreamOne.read(o2);
                fileOutputStreamOne.write(o1, 0, count1);
                fileOutputStreamTwo.write(o2, 0, count2);
            }

        }
        reader.close();
        fileInputStreamOne.close();
        fileOutputStreamOne.close();
        fileOutputStreamOne.close();
    }
}
