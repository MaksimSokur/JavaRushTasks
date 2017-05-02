package com.javarush.task.task18.task1823;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName;
        ArrayList<String> list = new ArrayList<>();
        while (!(fileName = reader.readLine()).equals("exit")) {
            list.add(fileName);
        }
        for (String s : list) {
            ReadThread readThread = new ReadThread(s);
            readThread.start();
            readThread.join();
        }
    }


    public static class ReadThread extends Thread {
        private String fileName;

        public ReadThread(String fileName) {
            //implement constructor body
            this.fileName = fileName;
        }
        // implement file reading here - реализуйте чтение из файла тут

        @Override
        public void run() {
            try {
                FileInputStream fileInputStream = new FileInputStream(fileName);
                ArrayList<Integer> list = new ArrayList<>();
                while (fileInputStream.available() > 0) {
                    int data = fileInputStream.read();
                    list.add(data);
                }
                fileInputStream.close();

                int max = 0;
                int id = 0;
                int count;

                for (int a = 0; a < list.size(); a++) {
                    count = Collections.frequency(list, list.get(a));
                    if (count > max) {
                        max = count;
                        id = list.get(a);
                    }
                }
                resultMap.put(fileName, id);
                System.out.println(resultMap);
            } catch (Exception ignored) {}
        }
    }
}
