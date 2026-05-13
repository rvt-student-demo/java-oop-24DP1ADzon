package rvt.todo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class TodoDB {
    private final static String DB_URL = "jdbc:sqlite:todo.db";

    public TodoDB(){
        initSchema();
    }

    private Connection connect() throws SQLException {
        return DriverManager.getConnection(DB_URL);
    }

    private void initSchema(){
        String sql = "CREATE TABLE IF NOT EXISTS todo(id INTEGER PRIMARY KEY, task TEXT);";
        try {
            Connection conn = connect();
            Statement statement = conn.createStatement();
            statement.execute(sql);
        } catch (SQLException e) {
            throw new RuntimeException("Schema init failed " + e.getMessage());
        }
    }

    public void saveTask(String task){
        String sql = "INSERT INTO todo (task) VALUES ('" + task + "')";
        try {
            Connection conn = connect();
            Statement statement = conn.createStatement();
            statement.execute(sql);
        } catch(SQLException e){
            throw new RuntimeException("Failed to save task in database " + e.getMessage());
        }
    }

    public ArrayList<String> getTasks(){
        String sql = "SELECT * FROM todo;";
        ArrayList<String> tasks = new ArrayList<>();
        try {
            Connection conn = connect();
            Statement statement = conn.createStatement();
            ResultSet res = statement.executeQuery(sql);

            while (res.next()) {
                String string = res.getString(1) + "," + res.getString(2);
                tasks.add(string);
            }
            
        } catch (SQLException e) {
            System.out.println("Failed to get tasks from database " + e.getMessage());
        }  
        return tasks;
    }

    public void deleteTask(int id){
        String sql = "DELETE FROM todo WHERE id = " + id;
        try{
            Connection conn = connect();
            Statement statement = conn.createStatement();
            statement.execute(sql);

        } catch(SQLException e){
            System.out.println("Failed to delete task from database " + e.getMessage());
        }
    }

}
