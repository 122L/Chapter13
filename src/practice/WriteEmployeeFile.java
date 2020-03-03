package practice;

import java.util.Scanner;
import java.nio.file.*;
import java.io.*;
import static java.nio.file.StandardOpenOption.*;

public class WriteEmployeeFile {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Path file = Paths.get("C:\\Users\\og153182\\Desktop\\Java\\Chapter13\\src\\practice\\Employees.txt");
        String s = "";
        String delimiter = ",";
        int id;
        String name;
        double payRate;
        final int QUIT = 999;
        try{
            OutputStream output = new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(output));
            System.out.print("Enter employee ID number >>> ");
            id = input.nextInt();
            while (id != QUIT) {
                System.out.print("Enter name for employee #" + id + " >>> ");
                input.nextLine();
                name = input.next();
                System.out.println("Enter pay rate >>> ");
                payRate = input.nextDouble();
                s = id + delimiter + name + delimiter + payRate;
                writer.write(s, 0, s.length());
                writer.newLine();
                System.out.println("Enter next ID number or " + QUIT + " to quit");
                id = input.nextInt();
            }
            writer.close();
        }
        catch (Exception e){
            System.out.println("Message: " + e);
        }
    }
}
