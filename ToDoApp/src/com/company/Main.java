package com.company;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
	// write your code here
        boolean IsFinnsihed = true;
        System.out.println("Press 'RETURN' to start adding to ToDo list or write 'Read' to read the file and 'Exit' to exit the app.");
        System.out.print("Your Command: ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int count = 0;
        boolean isFirst = true;

        if (input.equals("Exit")){
            System.exit(0);
        }else if(input.equals("Read")){
            readFile();
        }else {
            IsFinnsihed = false;
        }
        while(!IsFinnsihed){
            try {
                File myObj = new File("toDoList.txt");
                SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
                Date date = new Date(System.currentTimeMillis());
                if (myObj.createNewFile()) {
                    count++;
                    System.out.println("File created: " + myObj.getName());
                    System.out.print("Write your command: ");
                    if (isFirst){
                        writeToFile( date + "]\n[" + String.valueOf(count));
                        isFirst = false;
                    }else {
                        writeToFile(String.valueOf(count));
                    }
                } else {
                    count++;
                    System.out.println("Append to toDoList.txt.");
                    System.out.print("Write your command: ");
                    if (isFirst){
                        writeToFile( date + "]\n[" + String.valueOf(count));
                        isFirst = false;
                    }else {
                        writeToFile(String.valueOf(count));
                    }
                }
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }


    }
    public static void writeToFile(String count) throws IOException {
        Scanner scannerCode = new Scanner(System.in);
        String inputCode = scannerCode.nextLine();
        if (inputCode.equals("Exit")) {
            System.exit(0);
        } else {
            FileWriter fstream = new FileWriter("toDoList.txt",true);
            BufferedWriter fbw = new BufferedWriter(fstream);
            fbw.write("[" + (count) + "] " + inputCode);
            fbw.newLine();
            fbw.close();
        }
    }

    public static void readFile(){
        try {
            File myObj = new File("toDoList.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
