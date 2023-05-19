package edu.estu.singleton;

import edu.estu.entities.Recipe;

import java.util.LinkedList;
import java.util.List;

public class RecipeStore {
    private static RecipeStore instance;
    private final List<Recipe> recipeList = new LinkedList<>();

    private RecipeStore() {
    }

    public List<Recipe> getRecipeList() {
        return recipeList;
    }

    public static RecipeStore getInstance() {
        if (instance == null) {
            instance = new RecipeStore();
        }
        return instance;
    }

    public void addToBook(Recipe recipe) {
        recipeList.add(recipe);
    }

}
