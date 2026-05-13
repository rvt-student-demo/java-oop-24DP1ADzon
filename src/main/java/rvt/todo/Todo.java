package rvt.todo;

import java.util.ArrayList;

public class Todo {    
    public void add(String task){
        TodoDB db = new TodoDB();
        db.saveTask(task);
    }

    public void print(){
        TodoDB db = new TodoDB();
        ArrayList<String> tasks = db.getTasks();

        for(int i = 0; i < tasks.size(); i++){
            String[] stringParts = tasks.get(i).split(",");
            System.out.println(stringParts[0] + ": " + stringParts[1]);
        }
        System.out.println();
    }

    public void remove(int taskId){
        TodoDB db = new TodoDB();
        db.deleteTask(taskId);
    }
}
