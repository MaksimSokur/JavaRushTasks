package com.javarush.task.task16.task1630;

import java.io.*;

public class Solution {
    public static String firstFileName;
    public static String secondFileName;

    //add your code here - добавьте код тут
    static {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            firstFileName = reader.readLine();
            secondFileName = reader.readLine();
            reader.close();
        } catch (IOException e) {
            System.out.println("not file");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        f.join();
        //add your code here - добавьте код тут
        System.out.println(f.getFileContent());
    }

    public interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }

    public static class ReadFileThread extends Thread implements ReadFileInterface {
        private String str;

        private StringBuilder sb = new StringBuilder();

        @Override
        public void setFileName(String fullFileName) {
            str = fullFileName;
        }

        @Override
        public String getFileContent() {
            //объект, для построения строки
            return sb.toString();
        }

        @Override
        public void run() {
            try {
                //объект, для чтения файла из буффера
                BufferedReader in = new BufferedReader(new FileReader(str));
                while ((str = in.readLine()) != null) {
                    sb.append(str);
                    sb.append(" ");
                }

                in.close();

            } catch (FileNotFoundException e) {

            } catch (IOException e) {

            }
        }
    }


    //add your code here - добавьте код тут
}
