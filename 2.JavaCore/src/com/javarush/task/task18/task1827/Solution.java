package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.*;
import java.util.ArrayList;


public class Solution {
    static ArrayList<String> list = new ArrayList<String>();
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        reader.close();
        BufferedReader file = new BufferedReader(new FileReader(name));
        int max = 0;
        if (args[0].equals("-c")) {
            while (file.ready()) {
                String str = file.readLine();
                list.add(str);
                int y = Integer.parseInt(str.substring(0, 8).replaceAll(" ", ""));
                if (y > max) max = y;

            }
            max++;
            file.close();
            BufferedWriter fileWR = new BufferedWriter(new FileWriter(name));
            for (String aList : list) {
                if (aList.equals(" ")) continue;
                fileWR.write(String.format("%s%n", aList));
            }
            StringBuilder productname = new StringBuilder(args[1]);
            for (int l = 2; l < args.length - 2; l++)
                productname.append("").append(args[l]);
           fileWR.write(String.format("%-8s%-30.30s%-8.2s%-4.4s", String.valueOf(max), productname.toString(), args[args.length - 2], args[args.length - 1]));
           fileWR.close();
        }

    }
}
