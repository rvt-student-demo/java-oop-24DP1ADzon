package rvt.todo;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Scanner;

public class Todo {
    Scanner reader;
    
    public ArrayList<String> readFile(){
        ArrayList<String> fileData = new ArrayList<>();
        try {
            Scanner reader = new Scanner(new File("data/todo.csv"));
            while (reader.hasNextLine()) {
                fileData.add(reader.nextLine());
            }           
            reader.close();

        } catch (Exception e) {
            System.out.println("Failed to read the file: " + e.getMessage());
        }
        return fileData;
    }

    public void writeFile(ArrayList<String> fileData){
        try {
            Writer writer = new FileWriter("data/todo.csv");
            for(int i = 0; i < fileData.size(); i++){
                String[] stringParts = fileData.get(i).split(",");
                writer.write((i + 1) + "," + stringParts[1] + "\n");
            }
            writer.flush();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void add(String task){
        ArrayList<String> tasks = this.readFile();
        tasks.add("," + task);
        this.writeFile(tasks);
        System.out.println("Task has been saved successfully!"); // Move to UserInterface later
    }

    public void print(){
        ArrayList<String> tasks = this.readFile();
        System.out.println("\nList of your tasks: \n");

        for(int i = 0; i < tasks.size(); i++){
            String[] stringParts = tasks.get(i).split(",");
            System.out.println(stringParts[0] + ": " + stringParts[1]);
        }
        System.out.println();
    }

    public void remove(int taskId){
        ArrayList<String> tasks = this.readFile();
        tasks.remove(taskId - 1);
        this.writeFile(tasks);

        System.out.println("Task has been removed successfully!"); // Move to UserInterface later
    }
}
