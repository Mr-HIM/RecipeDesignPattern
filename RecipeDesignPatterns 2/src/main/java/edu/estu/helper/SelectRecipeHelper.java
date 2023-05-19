package edu.estu.helper;

import edu.estu.common.ConsoleUtils;
import edu.estu.entities.Recipe;
import edu.estu.singleton.RecipeStore;

import java.util.List;

public class SelectRecipeHelper {
    public Recipe selectRecipe() {
        RecipeStore recipeStore = RecipeStore.getInstance();
        List<Recipe> recipeList = recipeStore.getRecipeList();


        new RecipeDisplayHelper().listAllRecipes();
        System.out.println();
        while (true) {
            String title = ConsoleUtils.readLine("Select the recipe you want (Enter Recipe Title): ");
            Recipe recipe = recipeList.stream().filter(recipe1 -> recipe1.getTitle().equals(title)).findFirst().orElse(null);
            if (recipe != null) return recipe;
            System.out.println("Recipe could not be found");
        }
    }

}
