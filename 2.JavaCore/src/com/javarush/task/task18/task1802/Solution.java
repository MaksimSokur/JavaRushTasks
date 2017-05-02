package com.javarush.task.task18.task1802;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Минимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream = new FileInputStream(reader.readLine());

        int data = 300;
        int temp;
        while (fileInputStream.available() > 0)
        {
            temp = fileInputStream.read();
            if (temp < data) data = temp;
        }
        System.out.println(data);
        fileInputStream.close();
    }
}
