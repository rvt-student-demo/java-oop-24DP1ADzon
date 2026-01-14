package rvt;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.Scanner;

public class Todo {
    Writer writer;
    Scanner reader;

    public Todo() {
        try {
            this.reader = new Scanner(new File("data/todo.csv"));
            this.writer = new FileWriter("data/todo.csv"); 
        } catch (Exception e) {
            System.out.println("Problems in constructor: " + e);
        }
    }

    public void add(String task){
        try{
            this.writer.append(task);
            this.writer.flush();
            
        } catch (Exception e){

        } 

        }

    public void print(){
        while(this.reader.hasNextLine()){
            String line = reader.nextLine();
            System.out.println(line);
            String[] parts = line.split(",");
            System.out.println(parts[0] + ": " + parts[1]);
        }
    }

    public void remove(int taskId){

    }

    public static void main(String[] args) {
        Todo todo = new Todo();
        todo.add("");
        todo.print();
    }
}
