package com.teachmeskills.Lesson_11;

import java.io.*;
import java.util.Scanner;

public class SortingDocumnetNumbers {

    public static void main(String[] args)  {
        System.out.println("Insert a File Path");
        Scanner s = new Scanner(System.in);

        String line;
        try {
            FileReader myFile = new FileReader(s.nextLine());
            
            BufferedReader num = new BufferedReader(myFile);
            BufferedWriter validNums = new BufferedWriter(new FileWriter("validOutput.txt"));
            BufferedWriter invalidNums = new BufferedWriter(new FileWriter("invalidOutput.txt"));

            while ((line = num.readLine()) != null) {
                if (line.length() == 15 && (line.toString().startsWith("contract") || line.toString().startsWith("docnum"))) {
                    validNums.write(line + "\n");
                    //System.out.println(line);

                } else if (line.length() != 15) {
                    invalidNums.write(line + " - The number must be 15 characters long" + "\n");
                    //System.out.println(line);

                } else if (!(line.toString().startsWith("docnum") || line.toString().startsWith("contract"))) {
                    invalidNums.write(line + " - The number must start with \"contract\" or \"docnum\"" + "\n");
                    //System.out.println(line);

                } else {
                    invalidNums.write(line + "\n");
                }
            }
            myFile.close();
            validNums.close();
            invalidNums.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
