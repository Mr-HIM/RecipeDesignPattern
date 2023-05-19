package edu.estu;

import edu.estu.common.DataSeeder;

public class Main {
    public static void main(String[] args) {
        DataSeeder.seed();
        RecipeApplication.start();
    }
}