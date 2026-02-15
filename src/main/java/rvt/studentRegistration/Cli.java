package rvt.studentRegistration;

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

    public static String[] validateInput(){
        String name, lastName, email, perCode;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter name: ");
            name = scanner.nextLine();
            if(!validateName(name)) continue;

            System.out.print("Enter last name: ");
            lastName = scanner.nextLine();
            if(!validateName(lastName)) continue;

            System.out.print("Enter email: ");
            email = scanner.nextLine();
            if(!validateEmail(email)) continue;

            System.out.print("Enter persone code: ");
            perCode = scanner.nextLine();
            if(!validatePerCode(perCode)) continue;
            break;
        }
        String[] dataParts = LocalDateTime.now().toString().split("T");
        String[] data = {name, lastName, email, perCode, dataParts[0] + " " + dataParts[1].substring(0, 5)};
        return data;
    }

    public static void register(String[] data){
        ArrayList<String> file = FileHandler.readFile();
        file.add(data[0] + "," + data[1] + "," + data[2] + "," + data[3] + "," + data[4]);
        FileHandler.writeFile(file);
    }

    public static void delete(){
        System.out.println("delete function is not implemented yet");
    }
    public static void edit(){
        System.out.println("edit function is not implemented yet");
    }
    public static void help(){
        System.out.println("\t\t     Avaible commands:");
        System.out.println("\n1. list\n2. register\n3. delete\n4. edit\n5. help\n6. stop\n");
    }
    

    public static void userInterface(){
        Scanner scanner = new Scanner(System.in);
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
                    delete();
                    break;
                case "4":
                case "e":
                case "edit":
                    edit();
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