package rvt.studentRegistration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

public class Student {
    String name;
    String lastName;
    String email;
    String personeCode;
    String regDate;
    
    public Student(String name, String lastName, String email, String personeCode){
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.personeCode = personeCode;
        String[] dateTime = String.valueOf(LocalDateTime.now()).split("T");
        this.regDate = dateTime[0] + " " + dateTime[1].split(":")[0] + ":" + dateTime[1].split(":")[1];
    }

    public ArrayList<String> getData(){
        String[] dataArray = {this.name, this.lastName, this.email, this.personeCode, this.regDate};
        return new ArrayList<>(Arrays.asList(dataArray));
    }

    public String toString(){
        ArrayList<String> data = getData();
        return data.get(0) + "," + data.get(1) + "," + data.get(2) + "," + data.get(3) + "," + data.get(4);
    }
}
