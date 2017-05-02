package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* 
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            FileInputStream fileInputStream = new FileInputStream(reader.readLine());

            ArrayList listOfBytes = new ArrayList();

            while (fileInputStream.available() > 0)
            {
                listOfBytes.add(fileInputStream.read());
            }
            fileInputStream.close();

            HashMap<Integer, Integer> map = new HashMap<>();

            initMapBytesCount(listOfBytes, map);
            print(map, getMaxCount(map));

        }
    }

    private static void print(HashMap<Integer, Integer> map, int maxCount) {
        for (Map.Entry<Integer, Integer> pair:map.entrySet()) {
            if(pair.getValue() == maxCount)
                System.out.print(pair.getKey() + " ");
        }
    }

    private static int getMaxCount(HashMap<Integer, Integer> map) {
        int maxCount = 0;

        for (Map.Entry<Integer, Integer> pair: map.entrySet()) {
            if (pair.getValue() > maxCount)
                maxCount = pair.getValue();
        }
        return maxCount;
    }

    private static void initMapBytesCount(ArrayList listOfBytes, HashMap<Integer, Integer> map) {
        for (int i = 0; i < listOfBytes.size() - 1; i++) {
            int countSameBytes = 0;

            for (int j = i + 1; j < listOfBytes.size(); j++) {
                if (listOfBytes.get(j) == listOfBytes.get(i))
                    countSameBytes++;
            }

            boolean contains = false;

            for (Map.Entry<Integer, Integer> pair : map.entrySet()) {
                if (pair.getKey() == listOfBytes.get(i)) {
                    contains = true;
                }
            }

            if (!contains) {
                map.put((Integer) listOfBytes.get(i), countSameBytes);
            }
        }
    }
}
