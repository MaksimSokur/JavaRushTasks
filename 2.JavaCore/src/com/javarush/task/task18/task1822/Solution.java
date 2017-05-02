package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        FileReader fileReader = new FileReader(fileName);
        BufferedReader fileBufReader = new BufferedReader(fileReader);

        String res;

        while ((res = fileBufReader.readLine()) != null){
            if (res.startsWith(args[0] + " ")){
                System.out.println(res);
                break;
            }
        }
        reader.close();
        fileBufReader.close();
        fileReader.close();
    }
}
