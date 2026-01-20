package rvt.todo;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Scanner;

public class Todo {
    Scanner reader;

    public Todo() {
        try {
            this.reader = new Scanner(new File("data/todo.csv"));
        } catch (Exception e) {
            System.out.println("Problems in constructor: " + e);
        }
    }

    public void add(String task){
        try{            
            Writer writer = new FileWriter("data/todo.csv", true); // append=true
            writer.write(task + "\n");
            writer.flush();
            writer.close();
                   
        } catch (Exception e){
            System.out.println("Failed to add a task: " + e.getMessage());
        }
    }

    public void print(){
        while(this.reader.hasNextLine()){
            String line = reader.nextLine();
            String[] parts = line.split(",");
            System.out.println(parts[0] + ": " + parts[1]);
        }
    }

    public void remove(int taskId){
        ArrayList<String> tasks = new ArrayList<>();
        try{
            while(this.reader.hasNextLine()){
                tasks.add(reader.nextLine());
            }
        } catch(Exception e){
            System.out.println("Failed to open tasks: " + e.getMessage());
        }

        try{
            tasks.remove(taskId - 1);
            Writer writer = new FileWriter("data/todo.csv");
            for(int i = 0; i < tasks.size(); i++){
                writer.write(String.valueOf(i + 1) + "," + tasks.get(i).split(",")[1]);
                writer.write("\n");
                writer.flush();
            }
        } catch(Exception e){
            System.out.println("Failed to rewrite tasks: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Todo list = new Todo();
        list.add("Kkas");
    }
}
