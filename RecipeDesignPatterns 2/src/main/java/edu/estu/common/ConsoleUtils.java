package edu.estu.common;

import lombok.Getter;
import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.Scanner;

@UtilityClass
public class ConsoleUtils {

    @Getter
    private static final Scanner scanner = new Scanner(System.in);

    public static Integer readInt(String print, int min, int max) {
        System.out.print(print);
        while (true) {
            try {
                int val = Integer.parseInt(scanner.nextLine());
                if (val >= min && val <= max) return val;
                else throw new Exception();
            } catch (Exception e) {
                System.out.print("Please enter a valid integer(between " + min + " and " + max + "):");
            }
        }
    }

    public static Double readDouble(String print, double min, double max) {
        System.out.print(print);
        while (true) {
            try {
                double val = Double.parseDouble(scanner.nextLine());
                if (val >= min && val <= max) return val;
                else throw new Exception();
            } catch (Exception e) {
                System.out.print("Please enter a valid number(between " + min + " and " + max + "):");
            }
        }
    }

    public static String readLine(String print) {
        System.out.print(print);
        return scanner.nextLine();
    }

    public void printOptions(List<String> options, String title) {
        int counter = 1;
        System.out.println("<<<<" + title + ">>>>");
        for (String option : options)
            System.out.println(counter++ + ") " + option);
        System.out.println("0) Exit");
        System.out.println();
    }

}
