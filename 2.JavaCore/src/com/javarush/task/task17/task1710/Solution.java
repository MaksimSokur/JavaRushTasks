package com.javarush.task.task17.task1710;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws IOException, ParseException {
        //start here - начни тут
        if (args.length < 2 || args.length > 7 || args.length == 3){
            return;
        }else processParams(args);
    }

    public static void processParams(String[] args){
        SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        SimpleDateFormat format2 = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        String name = "";
        Date bd = null;
        int id;

        switch (args[0]){
            case "-c":
                name = args[1];
                if (!args[2].equals("м") && !args[2].equals("ж")){
                    name = name + " " + args[2];
                }
                try
                {
                    bd = format1.parse(args[args.length - 1]);
                }catch (ParseException e){
                    System.out.println("ParseException: maybe wrong date format");
                    return;
                }

                allPeople.add(args[args.length - 2].equals("м") ? Person.createMale(name, bd) : Person.createFemale(name, bd));
                System.out.println(allPeople.size()-1);
                break;

            case "-u":
                id = Integer.parseInt(args[1]);
                name = args[2];
                if (!args[3].equals("м") && !args[3].equals("ж")){
                    name = name + " " + args[3];
                }
                try
                {
                    bd = format1.parse(args[args.length-1]);
                }catch (ParseException e){
                    System.out.println("ParseException: maybe wrong date format");
                    return;
                }
                allPeople.get(id).setSex(args[args.length - 2].equals("м") ? Sex.MALE : Sex.FEMALE);
                allPeople.get(id).setName(name);
                allPeople.get(id).setBirthDay(bd);
                break;

            case "-d":
                id = Integer.parseInt(args[1]);
                allPeople.get(id).setBirthDay(null);
                allPeople.get(id).setSex(null);
                allPeople.get(id).setName(null);
                break;

            case "-i":
                id = Integer.parseInt(args[1]);
                System.out.println(allPeople.get(id).getName() + (allPeople.get(id).getSex() == Sex.MALE ? " м " : " ж ") + format2.format(allPeople.get(id).getBirthDay()));
                break;
        }
    }
}
