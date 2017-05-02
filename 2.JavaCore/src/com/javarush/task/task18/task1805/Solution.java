package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream = new FileInputStream(reader.readLine());

        Map<Integer, Integer> tempMap = new HashMap<>();

        while (fileInputStream.available() > 0)
        {
            tempMap.put(fileInputStream.read(), null);
        }


        ArrayList<Integer> listOfBytes = new ArrayList<Integer>(tempMap.keySet());
        Collections.sort(listOfBytes);

        for (Integer sortInteger: listOfBytes) {
            System.out.print(sortInteger + " ");
        }

        fileInputStream.close();
    }
}
