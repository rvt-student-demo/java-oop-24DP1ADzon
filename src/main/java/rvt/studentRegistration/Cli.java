package rvt.studentRegistration;

import java.io.File;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Cli {
    public static boolean validateName(String name){ // Name and Last name
        String regex = "^[\\p{L}]+$"; // Check for letters with garumzīmes
        return name.matches(regex);
    }
    public static boolean validateEmail(String email){
        String regex = "^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}";
        return email.matches(regex);
    }
    public static boolean validatePerCode(String personeCode){
        String regex = "^[\\d]{6}-[\\d]{6}";
        return personeCode.matches(regex);
    }

    private static void printLine(int name, int lastName, int email, int perCode, int regDate) {
        System.out.print("+");
        for (int i = 0; i < name + 2; i++) System.out.print("-");
        System.out.print("+");
        for (int i = 0; i < lastName + 2; i++) System.out.print("-");
        System.out.print("+");
        for (int i = 0; i < email + 2; i++) System.out.print("-");
        System.out.print("+");
        for (int i = 0; i < perCode + 2; i++) System.out.print("-");
        System.out.print("+");        
        for (int i = 0; i < regDate + 2; i++) System.out.print("-");
        System.out.println("+");
}
    
    public static void list(){
        ArrayList<String> file = FileHandler.readFile();
        if(file.size() == 0){
            System.out.println("No registered students");
            return;
        }
        
        int maxNameLength = "Name".length();
        int maxLastNameLength = "Last Name".length();
        int maxEmailLength = "Email".length();
        int personeCodeLength = 12;
        int dateLength = 16;

        String[] fileString;
        System.out.println();
        for(int i = 0; i < file.size(); i++){
            fileString = file.get(i).split(",");
            if(fileString[0].length() > maxNameLength) maxNameLength = fileString[0].length();
            if(fileString[1].length() > maxLastNameLength) maxLastNameLength = fileString[1].length();
            if(fileString[2].length() > maxEmailLength) maxEmailLength = fileString[2].length();
        }
        printLine(maxNameLength, maxLastNameLength, maxEmailLength, personeCodeLength, dateLength);    
        System.out.printf("| %-" + maxNameLength + "s | %-" + maxLastNameLength + "s | %-" + maxEmailLength + "s | %-" + personeCodeLength + "s | %-" + dateLength + "s |\n", "Name", "Last Name", "Email", "Persone Code", "Registered");
        printLine(maxNameLength, maxLastNameLength, maxEmailLength, personeCodeLength, dateLength);    

        for(int i = 0; i < file.size(); i++){
            fileString = file.get(i).split(",");
                System.out.printf("| %-" + maxNameLength + "s | %-" + maxLastNameLength + "s | %-" + maxEmailLength + "s |%-"  + personeCodeLength + "s | %-"  + dateLength + "s | \n", fileString[0], fileString[1], fileString[2], fileString[3], fileString[4]);
        }
        printLine(maxNameLength, maxLastNameLength, maxEmailLength, personeCodeLength, dateLength);    
    }

    public static String validateInput(){
        String name, lastName, email, perCode;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter name: ");
            name = scanner.nextLine();
            if(validateName(name)) break;
        }
        while (true) {
            System.out.print("Enter last name: ");
            lastName = scanner.nextLine();
            if(validateName(lastName)) break;
        }
        while (true) {
            System.out.print("Enter email: ");
            email = scanner.nextLine();
            if(validateEmail(email)) break;
        }
        while (true) {
            System.out.print("Enter persone code: ");
            perCode = scanner.nextLine();
            if(validatePerCode(perCode)) break;
        }
        Student student = new Student(name, lastName, email, perCode);
        return student.toString();
    }

    public static void register(String data){
        ArrayList<String> file = FileHandler.readFile();
        file.add(data);
        FileHandler.writeFile(file);
    }

    public static void delete(String perCode){
        ArrayList<String> file = FileHandler.readFile();
        String fileLine;
        String linePerCode;
        for(int i = 0; i < file.size(); i++){
            fileLine = file.get(i);
            linePerCode = fileLine.split(",")[3];
            if(linePerCode.equals(perCode)){
                file.remove(i);
            }
        }
        FileHandler.writeFile(file);
    }

    public static String[] editInput(){
        Scanner scanner = new Scanner(System.in);
        String[] returnData = new String[2];
        String userInput;
        System.out.println("1. Name\n2. Last name\n3. Email\n4. Persone code");
        System.out.print("Enter what to edit: ");
        String userChoice = scanner.nextLine();
        while (true) {
            switch (userChoice.toLowerCase()) {
                case "1":
                case "n":
                case "name":
                    while (true) {
                        System.out.print("Enter new name: ");
                        userInput = scanner.nextLine();
                        if(validateName(userInput)) break;
                    }
                    returnData[0] = "0";
                    returnData[1] = userInput;
                    return returnData;
                case "2":
                case "l":
                case "last name":
                    while (true) {
                        System.out.print("Enter new last name: ");
                        userInput = scanner.nextLine();
                        if(validateName(userInput)) break;
                    }
                    returnData[0] = "1";
                    returnData[1] = userInput;
                    return returnData;
                case "3":
                case "e":
                case "email":
                    while (true) {
                        System.out.print("Enter new email: ");
                        userInput = scanner.nextLine();
                        if(validateEmail(userInput)) break;
                    }
                    returnData[0] = "2";
                    returnData[1] = userInput;
                    return returnData;
                case "4":
                case "p":
                case "persone code":             
                    while (true) {
                        System.out.print("Enter new persone code: ");
                        userInput = scanner.nextLine();
                        if(validatePerCode(userInput)) break;
                    }
                    returnData[0] = "3";
                    returnData[1] = userInput;
                    return returnData;
                default:
                    System.out.println("Wrong input!");
                    break;
            }
        }
    }

    public static String editString(String string, String[] editData){
        String[] stringParts = string.split(",");
        stringParts[Integer.valueOf(editData[0])] = editData[1];
        return stringParts[0] + "," + stringParts[1] + "," + stringParts[2] + "," + stringParts[3] + "," + stringParts[4];
    }

    public static void edit(String perCode){
        ArrayList<String> file = FileHandler.readFile();
        String fileLine;
        String linePerCode;
        for(int i = 0; i < file.size(); i++){
            fileLine = file.get(i);
            linePerCode = fileLine.split(",")[3];
            if(linePerCode.equals(perCode)){
                file.set(i, editString(file.get(i), editInput()));
            }
        }
        FileHandler.writeFile(file);
    }

    public static void help(){
        System.out.println("\t\t     Avaible commands:");
        System.out.println("\n1. list\n2. register\n3. delete\n4. edit\n5. help\n6. stop\n");
    }
    
    public static void userInterface(){
        Scanner scanner = new Scanner(System.in);
        String perCode;
        help();
        while (true) {
            System.out.print("\nEnter a command: ");
            String userInput = scanner.nextLine().toLowerCase();
            switch (userInput) {
                case "1":
                case "l":
                case "list":
                    list();
                    break;
                case "2":
                case "rg":
                case "register":
                    register(validateInput());
                    break;
                case "3":
                case "d":
                case "delete":
                    while (true) {
                        System.out.print("Enter persone code: ");
                        perCode = scanner.nextLine();
                        if(validatePerCode(perCode)) break;
                    }
                    delete(perCode);
                    break;
                case "4":
                case "e":
                case "edit":
                    while (true) {
                        System.out.print("Enter persone code: ");
                        perCode = scanner.nextLine();
                        if(validatePerCode(perCode)) break;
                    }
                    edit(perCode);
                    break;
                case "5":
                case "h":
                case "help":
                    help();
                    break;
                case "6":
                case "s":
                case "stop":
                    scanner.close();
                    return;
                default:
                    System.out.println("Wrong comand, try one more time.");
                    System.out.println("Print help to see avaible commands.");
                    break;
            }
        }

    }

    public static void main(String[] args) {
        userInterface();
    }
}