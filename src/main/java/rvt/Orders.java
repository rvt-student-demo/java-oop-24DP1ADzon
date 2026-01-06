package rvt;

import java.io.File;
import java.util.Scanner;

public class Orders {
    public static void main(String[] args) {
        try {
            double sum = 0;
            Scanner reader = new Scanner(new File("data/orders.csv"));
            reader.nextLine();
            while(reader.hasNextLine()){
                String line = reader.nextLine();
                String[] parts = line.split(",");
                double orderSum = (Double.valueOf(parts[3]) * Double.valueOf(parts[4]));
                
                System.out.println("Pasutijums #" + parts[0] + ": " + parts[1] + " pasutija " + parts[3] + " x " + parts[2] + " (" + parts[4] + ") -> Kopa: " + orderSum + " EUR");
                
                sum += orderSum;
            }
            System.out.println();
            System.out.println("Kopeja pasutijumu summa: " + sum + " EUR");

        } catch (Exception e) {
            System.out.println("Kluda");
        }
        
    }
}
