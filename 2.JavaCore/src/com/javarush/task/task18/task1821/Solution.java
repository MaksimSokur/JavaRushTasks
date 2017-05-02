package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.File;
import java.io.FileInputStream;
import java.util.Arrays;
import java.util.HashMap;

public class Solution {
    public static void main(String[] args) throws Exception{
        FileInputStream inputStream = new FileInputStream(new File(args[0]));
        byte[] symbols = new byte[inputStream.available()];
        inputStream.read(symbols);
        Arrays.sort(symbols);

        HashMap<Byte, Integer> map = new HashMap<>();

        int count;

        for (byte x : symbols){
            count = 0;

            for (byte x1 : symbols){
                if (x == x1){
                    count++;
                }
            }

            if (!map.containsKey(x)){
                map.put(x, count);
                System.out.println((char) x + " " + count);
            }
        }

        inputStream.close();

    }
}
