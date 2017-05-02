package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();

        reader.close();

        FileInputStream fileInputStream = new FileInputStream(fileName1);
        FileOutputStream fileOutputStream = new FileOutputStream(fileName2);

        if (fileInputStream.available() > 0){
            byte[] data = new byte[fileInputStream.available()];
            fileInputStream.read(data);

            String[] strArrDouble = new String(data).split(" ");
            StringBuilder stringBuilder = new StringBuilder(data.length);

            for (String strDouble: strArrDouble){
                stringBuilder.append(Math.round(Double.valueOf(strDouble)));
                stringBuilder.append(" ");
            }
            fileOutputStream.write(stringBuilder.toString().getBytes());
        }

        fileInputStream.close();
        fileOutputStream.close();

    }
}
