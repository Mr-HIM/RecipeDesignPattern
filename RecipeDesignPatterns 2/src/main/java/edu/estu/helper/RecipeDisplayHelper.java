package edu.estu.helper;

import edu.estu.entities.Recipe;
import edu.estu.strategy.rating.concretes.TotalRatingsStrategy;
import edu.estu.singleton.RecipeStore;

import java.util.List;

public class RecipeDisplayHelper {
    private final RecipeStore recipeStore = RecipeStore.getInstance();

    public void listAllRecipes() {
        List<Recipe> recipeList = recipeStore.getRecipeList();
        Recipe recipe;
        for (Recipe value : recipeList) {
            recipe = value;
            RecipeCardHelper.printRecipeCard(recipe);
        }
    }

    public void listAllRecipesForAverageRatings() {
        List<Recipe> recipeList = recipeStore.getRecipeList();
        Recipe recipe;
        for (Recipe value : recipeList) {
            recipe = value;
            RecipeCardHelper.printRecipeForAverageRating(recipe);
        }
    }

    public void listAllRecipesForTotalRatings() {
        List<Recipe> recipeList = recipeStore.getRecipeList();
        Recipe recipe;
        for (Recipe value : recipeList) {
            recipe = value;
            recipe.setRatingStrategy(new TotalRatingsStrategy());
            RecipeCardHelper.printRecipeForAverageRating(recipe);
        }
    }

}
