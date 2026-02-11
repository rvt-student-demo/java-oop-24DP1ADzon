package rvt.studentRegistration;

public class Student {
    String name;
    String lastName;
    String email;
    String personCode;
    String regDate;
    
    public Student(String name, String lastName, String email, String personCode, String regDate){
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.personCode = personCode;
        this.regDate = regDate;
    }

    public String[] getData(){
        String[] dataArray = {this.name, this.lastName, this.email, this.personCode, this.regDate};
        return  dataArray;
    }
}
