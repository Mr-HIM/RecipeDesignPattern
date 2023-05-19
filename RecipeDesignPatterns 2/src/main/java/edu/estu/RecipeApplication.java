package edu.estu;


import edu.estu.common.ConsoleUtils;
import edu.estu.helper.*;

import java.util.Arrays;
import java.util.List;

import static edu.estu.singleton.RecipeApplicationIoCContainer.getSingletonInstance;

public class RecipeApplication {

    public static void start() {

        while (true) {
            List<String> options = Arrays.asList("Create New Recipe", "Search A Recipe", "Modify An Existing Recipe", "Rate Recipe", "Show Ratings");
            ConsoleUtils.printOptions(options, "Main Menu");
            int choice = ConsoleUtils.readInt("Enter your choice: ", 0, options.size());
            if (choice == 0) break;
            System.out.println();
            switch (choice) {
                case 1 -> getSingletonInstance(RecipeCreationHelper.class).handleCreateRecipe();
                case 2 -> getSingletonInstance(RecipeSearchHelper.class).handleSearchRecipe();
                case 3 -> getSingletonInstance(RecipeUpdateHelper.class).handleModifyRecipe();
                case 4 -> getSingletonInstance(RateRecipeHelper.class).handleRateRecipe();
                case 5 -> getSingletonInstance(RecipeRatingHelper.class).handleRecipeRating();
            }
            System.out.println();
        }
        System.out.println("See you next time...");
        ConsoleUtils.getScanner().close();
    }


}


