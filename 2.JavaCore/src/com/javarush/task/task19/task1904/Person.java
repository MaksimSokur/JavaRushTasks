package com.javarush.task.task19.task1904;

import java.io.IOException;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Person implements PersonScanner  {
    private final Scanner fileScanner;
    private String firstName;
    private String middleName;
    private String lastName;
    private Date birthDate;

    public Person(Scanner fileScanner, String firstName, String middleName, String lastName, Date birthDate) {
        this.fileScanner = fileScanner;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %s", lastName, firstName, middleName, birthDate.toString());
    }

    @Override
    public Person read() throws IOException {
        String str=fileScanner.nextLine();
        String s[] = str.split(" ");
        int year, month, day;
        year=Integer.parseInt(s[5]);
        month = Integer.parseInt(s[4])-1;
        day=Integer.parseInt(s[3]);
        Date date= (new GregorianCalendar(year,month, day)).getTime();
        Person person =  new Person(s[1], s[2], s[0], date);
        return person;
    }

    @Override
    public void close() throws IOException {
        fileScanner.close();;
    }
}
