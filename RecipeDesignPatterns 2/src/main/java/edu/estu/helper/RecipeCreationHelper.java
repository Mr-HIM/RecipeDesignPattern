package edu.estu.helper;

import edu.estu.common.ConsoleUtils;
import edu.estu.entities.Recipe;
import edu.estu.singleton.RecipeStore;

public class RecipeCreationHelper {

    public void handleCreateRecipe() {
        System.out.println("<<<<Recipe Creation>>>>");
        String name = ConsoleUtils.readLine("Title of the recipe: ");
        String description = ConsoleUtils.readLine("Description of the recipe: ");
        Integer size = ConsoleUtils.readInt("Serving size of the recipe: ", 1, 1000);

        Recipe recipe = createRecipes(name, description, size);

        CategoryHelper.createCategoryList().forEach(recipe::addCategory);
        TagHelper.createTagList().forEach(recipe::addTag);
        IngredientHelper.createIngredientList().forEach(recipe::addIngredient);
        recipe.setInstructions(InstructionHelper.createInstructions());
        System.out.println("Recipe created successfully!");
    }

    public Recipe createRecipes(String name, String description, int size) {
        Recipe recipe = new Recipe(name, description, size);
        RecipeStore.getInstance().addToBook(recipe);
        return recipe;
    }

}
