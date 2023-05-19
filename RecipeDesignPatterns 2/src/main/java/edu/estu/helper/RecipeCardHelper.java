package edu.estu.helper;

import edu.estu.entities.Category;
import edu.estu.entities.Ingredient;
import edu.estu.entities.Recipe;
import edu.estu.entities.Tag;

import java.util.stream.Collectors;

public class RecipeCardHelper {

    public static void printRecipeCard(Recipe recipe) {
        System.out.println("___________________________________________________________");
        System.out.println("Title: " + recipe.getTitle());
        System.out.println("Rating: " + recipe.getAverageRating());
        System.out.println("Description: " + recipe.getDescription());
        System.out.println("Serving size: " + recipe.getServingSize());
        System.out.println("Categories: " + recipe.getCategories().stream().map(Category::name).collect(Collectors.joining(",")));
        System.out.println("Tags: " + recipe.getTags().stream().map(Tag::name).collect(Collectors.joining(",")));
        System.out.println("___________________________________________________________");
        System.out.println("<<<<Ingredients>>>>");
        getIngredients(recipe);
        System.out.println("___________________________________________________________");
        System.out.println("<<<<Instructions>>>>");
        getInstructions(recipe);
        System.out.println("___________________________________________________________");
    }

    public static void printRecipeForAverageRating(Recipe recipe) {
        System.out.println("___________________________________________________________");
        System.out.println("Recipe Title: " + recipe.getTitle() + "      \nRate: " + recipe.getImpact());
        System.out.println("___________________________________________________________");
    }

    private static void getIngredients(Recipe recipe) {
        for (Ingredient ingredient : recipe.getIngredients()) {
            System.out.println("#                                                        #");
            System.out.println("# " + ingredient.name() + " " + ingredient.amount() + " " + ingredient.unit().name());
        }
    }

    private static void getInstructions(Recipe recipe) {
        System.out.println("<<<<Instructions>>>>");
        int lineLength = 0;
        String[] words = recipe.getInstructions().split(" ");
        for (String word : words) {
            System.out.print(word + " ");
            lineLength += word.length() + 1;
            if (lineLength > 60) {
                System.out.println();
                lineLength = 0;
            }
        }
    }
}
