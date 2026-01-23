package rvt.todo;

import java.util.Scanner;

public class UserInterface {
    private void commandOutput(){
        System.out.println("Avaible commands:");
        System.out.println("add\tlist\tremove\tstop\thelp\n");
    }

    private void handleCommands(){
        Scanner scanner = new Scanner(System.in);
        Todo todo = new Todo();
        boolean exectue = true;
        String userArgument;

        do{
            System.out.print("Command: ");
            String userInput = scanner.nextLine();
            
            switch (userInput) {
                case "add":
                    System.out.print("To add: ");
                    userArgument = scanner.nextLine();
                    todo.add(userArgument);
                    break;
                
                case "list":
                    todo.print();
                    break;
                
                case "remove":
                    System.out.print("To remove: ");
                    userArgument = scanner.nextLine();
                    todo.remove(Integer.valueOf(userArgument));
                    break;
                
                case "stop":
                    exectue = false;
                    System.out.println("Closing programm...");
                    break;
                
                case "help":
                    commandOutput();
                    break;

                default:
                    System.out.println("Wrong command, write again!");
                    break;
            }

        } while(exectue);
        scanner.close();
    }

    public void start(){
        commandOutput();
        handleCommands();
    }
    public static void main(String[] args){
        UserInterface program = new UserInterface();
        program.start();
    }

}
