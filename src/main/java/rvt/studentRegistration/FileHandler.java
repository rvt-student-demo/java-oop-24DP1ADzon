package rvt.studentRegistration;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.Writer;

public class FileHandler{
    public static ArrayList<String> readFile(){
        ArrayList<String> fileStrings = new ArrayList<>();
        try{
            Scanner scanner = new Scanner(new File("data/registration.csv"));
            while (scanner.hasNextLine()){
                fileStrings.add(scanner.nextLine());
            }
            scanner.close();
        } catch(Exception e){
            System.out.println("Failed to read the file: " + e.getMessage());
        }
        return fileStrings;
    }

    public static void writeFile(ArrayList<String> fileStrings){
        try{
            Writer writer = new FileWriter("data/registration.csv");
            for(int i = 0; i < fileStrings.size(); i++){
                writer.write(fileStrings.get(i));
            }
            writer.flush();
            writer.close();

        } catch(Exception e){
            System.out.println("Failed to write the file: " + e.getMessage());
        }
    }
}