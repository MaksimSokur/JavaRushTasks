package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        try {
            switch (args[0]) {
                case "-c":

                    synchronized (allPeople) {
                        for (int i = 1; i < args.length; i = i + 3) {
                            Person person = null;
                            String name = args[i];
                            String sex = args[i + 1];
                            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
                            Date date = format.parse(args[i + 2]);
                            person = sex.equals("м") ? Person.createMale(name, date) : Person.createFemale(name, date);
                            allPeople.add(person);
                            System.out.println(allPeople.indexOf(person));
                        }
                    }
                    break;
                case "-u":
                    synchronized (allPeople) {
                        for (int i = 1; i < args.length; i = i + 4) {
                            int id = Integer.parseInt(args[i]);
                            String name = args[i + 1];
                            String sex = args[i + 2];
                            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
                            Date date = format.parse(args[i + 3]);
                            for (int j = 0; j < allPeople.size(); j++) {
                                if (id == j) {

                                    allPeople.get(j).setName(name);
                                    allPeople.get(j).setSex("м".equals(sex) ? Sex.MALE : Sex.FEMALE);
                                    allPeople.get(j).setBirthDay(date);

                                }
                            }
                        }
                    }
                    break;
                case "-d":
                    synchronized (allPeople) {
                        for (int i = 1; i < args.length; i++) {

                            allPeople.get(Integer.parseInt(args[i])).setName(null);
                            allPeople.get(Integer.parseInt(args[i])).setSex(null);
                            allPeople.get(Integer.parseInt(args[i])).setBirthDay(null);
                        }
                    }
                    break;
                case "-i":
                    synchronized (allPeople) {
                        for (int i = 1; i < args.length; i++) {
                            int id = Integer.parseInt(args[i]);
                            System.out.print(allPeople.get(id).getName() + " ");
                            System.out.print(allPeople.get(id).getSex().equals(Sex.MALE) ? "м " : "ж ");
                            SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
                            System.out.println(format.format(allPeople.get(id).getBirthDay()));
                        }
                    }

                    break;
            }}
            catch(Exception e){
                e.printStackTrace();
            }
        }
    }


