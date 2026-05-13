package rvt;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class App {
    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:todo.db");
            Statement statement = conn.createStatement();

            statement.execute(
                "CREATE TABLE IF NOT EXISTS todo(id INTEGER PRIMARY KEY, task TEXT) STRICT;"
            ); // Citi SQL pieprasījumi

            // statement.executeUpdate("INSERT INTO todo(task) VALUES ('task1');");

            statement.executeUpdate(""); // INSERT, ALTER, ...
            ResultSet res = statement.executeQuery("SELECT * FROM todo"); // SELECT
            
            for(int i = 1; i < 6; i++){
                res.next();
                System.out.println(res.getString(2));
            }
            statement.close();
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}
