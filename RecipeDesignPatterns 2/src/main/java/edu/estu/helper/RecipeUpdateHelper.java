package edu.estu.helper;

import edu.estu.common.ConsoleUtils;
import edu.estu.entities.Category;
import edu.estu.entities.Ingredient;
import edu.estu.entities.Recipe;
import edu.estu.entities.Tag;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static edu.estu.singleton.RecipeApplicationIoCContainer.getSingletonInstance;

public class RecipeUpdateHelper {

    private final Recipe recipe = selectRecipeToModify();
    private final ModifyRecipe updateRecipe = new ModifyRecipe(recipe);

    public void handleModifyRecipe() {
        List<String> options = Arrays.asList("Update Recipe Title", "Update Recipe Description", "Update Recipe Service Serving Size", "Update Recipe Ingredients", "Update Recipe Instructions", "Update Recipe Categories", "Update Recipe Tags");
        ConsoleUtils.printOptions(options, "Update Recipe");
        int choice = ConsoleUtils.readInt("Enter your choice: ", 1, options.size());
        if (choice == 0) return;
        switch (choice) {
            case 1 -> updateRecipeName();
            case 2 -> updateRecipeDescription();
            case 3 -> updateRecipeServiceSize();
            case 4 -> updateRecipeIngredients();
            case 5 -> updateRecipeInstructions();
            case 6 -> updateRecipeCategories();
            case 7 -> updateRecipeTags();
        }

    }

    private void updateRecipeTags() {
        HashSet<Tag> tags = TagHelper.createTagList();

        HashSet<Tag> oldTags = new HashSet<>(recipe.getTags());

        updateRecipe.updateRecipeTags(tags);

        System.out.println("Recipe tags modified successfully ");
        System.out.println("Here is your new recipe: ");
        RecipeCardHelper.printRecipeCard(recipe);
        undoModification(oldTags, "tags");

    }

    private void updateRecipeCategories() {
        HashSet<Category> categories = CategoryHelper.createCategoryList();

        HashSet<Category> oldCategories = new HashSet<>(recipe.getCategories());

        updateRecipe.updateRecipeCategories(categories);
        System.out.println("Recipe categories modified successfully ");
        RecipeCardHelper.printRecipeCard(recipe);

        undoModification(oldCategories, "categories");
    }


    private void updateRecipeInstructions() {
        String instructions = InstructionHelper.createInstructions();
        String oldInstructions = recipe.getInstructions();

        updateRecipe.updateRecipeInstructions(instructions);
        System.out.println("Recipe instructions modified successfully ");
        System.out.println("Here is your new recipe: ");
        RecipeCardHelper.printRecipeCard(recipe);
        undoModification(oldInstructions, "instructions");
    }

    private void updateRecipeIngredients() {
        List<Ingredient> ingredients = IngredientHelper.createIngredientList();

        List<Ingredient> oldIngredients = recipe.getIngredients();


        updateRecipe.updateRecipeIngredients(ingredients);
        System.out.println("Recipe ingredients modified successfully ");
        System.out.println("Here is your new recipe: ");
        RecipeCardHelper.printRecipeCard(recipe);
        undoModification(oldIngredients, "ingredients");
    }

    private void updateRecipeServiceSize() {
        System.out.println();

        int oldServiceSize = recipe.getServingSize();

        int newServiceSize = ConsoleUtils.readInt("Enter new service size: ", 1, 1000);

        updateRecipe.updateRecipeSize(newServiceSize);
        System.out.println("Recipe service size changed to: " + recipe.getServingSize());
        System.out.println("Here is your new recipe: ");
        RecipeCardHelper.printRecipeCard(recipe);
        undoModification(oldServiceSize, "size");
    }

    private void updateRecipeDescription() {
        String oldDescription = recipe.getDescription();
        String newDescription = ConsoleUtils.readLine("Enter new description: ");
        updateRecipe.updateRecipeDescription(newDescription);
        System.out.println("Recipe description changed to: " + recipe.getDescription());
        System.out.println("Here is your new recipe: ");
        RecipeCardHelper.printRecipeCard(recipe);
        undoModification(oldDescription, "description");
    }

    private void updateRecipeName() {
        String oldName = recipe.getTitle();
        String newName = ConsoleUtils.readLine("Enter new name: ");
        updateRecipe.updateRecipeName(newName);
        System.out.println("Recipe name changed to: " + recipe.getTitle());
        System.out.println("Here is your new recipe: ");
        RecipeCardHelper.printRecipeCard(recipe);
        undoModification(oldName, "name");
    }

    private void undoModification(Object a, String type) {
        String choice = ConsoleUtils.readLine("Do you want to undo the modification? (y/n)").toLowerCase();

        if (choice.startsWith("y")) {
            System.out.println("Undoing modification...");

            switch (type) {
                case "name" -> updateRecipe.updateRecipeName((String) a);
                case "description" -> updateRecipe.updateRecipeDescription((String) a);
                case "size" -> updateRecipe.updateRecipeSize((int) a);
                case "ingredients" -> updateRecipe.updateRecipeIngredients((List<Ingredient>) a);
                case "instructions" -> updateRecipe.updateRecipeInstructions((String) a);
                case "categories" -> updateRecipe.updateRecipeCategories((HashSet<Category>) a);
                case "tags" -> updateRecipe.updateRecipeTags((HashSet<Tag>) a);
                default -> System.out.println("Invalid choice, please try again.");
            }
            RecipeCardHelper.printRecipeCard(recipe);
        } else if (choice.startsWith("n")) {
            System.out.println("Modification saved.");
        } else {
            System.out.println("Invalid choice, please try again.");
            undoModification(a, type);
        }
    }

    private Recipe selectRecipeToModify() {
        return getSingletonInstance(SelectRecipeHelper.class).selectRecipe();
    }


}
