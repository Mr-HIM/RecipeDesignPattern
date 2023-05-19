package edu.estu.helper;

import edu.estu.common.ConsoleUtils;

import static edu.estu.singleton.RecipeApplicationIoCContainer.getSingletonInstance;

public class RecipeRatingHelper {
    public void handleRecipeRating() {

        int choice = ConsoleUtils.readInt("Enter 1 to show rating by average, 2 to total ratings:", 1, 2);
        RecipeDisplayHelper lister = getSingletonInstance(RecipeDisplayHelper.class);
        if (choice == 1)
            lister.listAllRecipesForAverageRatings();
        else
            lister.listAllRecipesForTotalRatings();
    }
}
