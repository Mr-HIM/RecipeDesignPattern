package edu.estu.helper;

import edu.estu.entities.Category;
import edu.estu.entities.Ingredient;
import edu.estu.entities.Recipe;
import edu.estu.entities.Tag;

import java.util.HashSet;
import java.util.List;

public class ModifyRecipe {
    Recipe recipe;

    public ModifyRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public void updateRecipeName(String name) {
        recipe.setTitle(name);
    }

    public void updateRecipeDescription(String description) {
        recipe.setDescription(description);
    }

    public void updateRecipeSize(int size) {
        recipe.setServingSize(size);
    }

    public void updateRecipeCategories(HashSet<Category> categories) {
        recipe.setCategories(categories);
    }

    public void updateRecipeTags(HashSet<Tag> tags) {
        recipe.setTags(tags);
    }

    public void updateRecipeIngredients(List<Ingredient> ingredient) {
        recipe.setIngredients(ingredient);
    }

    public void updateRecipeInstructions(String instructions) {
        recipe.setInstructions(instructions);
    }

}


