package edu.estu.helper;

import edu.estu.common.ConsoleUtils;
import edu.estu.entities.Recipe;

import static edu.estu.singleton.RecipeApplicationIoCContainer.getSingletonInstance;

public class RateRecipeHelper {

    public void handleRateRecipe() {
        System.out.println("<<<<Rate Recipe>>>>");
        Recipe recipe = getSingletonInstance(SelectRecipeHelper.class).selectRecipe();
        System.out.println("______________________________________\n");
        int rating = ConsoleUtils.readInt("Rate (0 to 5): ", 0, 5);
        recipe.addRating(rating);
    }

}
