package edu.estu.helper;

import edu.estu.entities.Category;
import edu.estu.entities.Ingredient;
import edu.estu.entities.Recipe;
import edu.estu.entities.Tag;
import edu.estu.helper.RecipeCardHelper;
import edu.estu.singleton.RecipeStore;

import java.util.LinkedList;
import java.util.List;

public class RecipeSearch {
    List<Recipe> recipeList = RecipeStore.getInstance().getRecipeList();

    public void searchRecipeByName(String name) {
        List<Recipe> result = new LinkedList<>();
        for (Recipe recipe : recipeList) {
            if (recipe.getTitle().toLowerCase().contains(name.toLowerCase())) {
                result.add(recipe);
            }
        }
        if (result.isEmpty()) System.out.println("No recipe found");
        else result.forEach(RecipeCardHelper::printRecipeCard);
    }

    public void searchRecipeByTag(Tag tag) {
        List<Recipe> result = new LinkedList<>();
        for (Recipe recipe : recipeList) {
            for (Tag recipeTag : recipe.getTags()) {
                if (recipeTag.name().contains(tag.name().toUpperCase())) {
                    result.add(recipe);
                }
            }
        }
        if (result.isEmpty())
            System.out.println("No recipe found");

        else {
            for (Recipe recipe : result) {
                RecipeCardHelper.printRecipeCard(recipe);
            }
        }
    }

    public void searchRecipeByCategory(Category category) {
        List<Recipe> result = new LinkedList<>();
        for (Recipe recipe : recipeList) {
            for (Category recipeCategory : recipe.getCategories()) {
                if (recipeCategory.name().toLowerCase().contains(category.name().toLowerCase())) {
                    result.add(recipe);
                }
            }
        }
        if (result.isEmpty())
            System.out.println("No recipe found");

        else {
            for (Recipe recipe : result) {
                RecipeCardHelper.printRecipeCard(recipe);
            }
        }
    }

    public void searchRecipeByIngredient(String ingredient) {
        List<Recipe> result = new LinkedList<>();
        for (Recipe recipe : recipeList) {
            for (Ingredient recipeIngredient : recipe.getIngredients()) {
                if (recipeIngredient.name().toLowerCase().contains(ingredient.toLowerCase())) {
                    result.add(recipe);
                }
            }
        }
        if (result.isEmpty())
            System.out.println("No recipe found");

        else {
            for (Recipe recipe : result) {
                RecipeCardHelper.printRecipeCard(recipe);
            }
        }
    }
}
